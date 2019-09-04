package org.kyou.stack.dubbo.service.impl;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.kyou.stack.dubbo.dao.PersonDao;
import org.kyou.stack.dubbo.domain.po.Person;
import org.kyou.stack.dubbo.service.PersonService;
import org.kyou.stack.dubbo.service.cache.CacheService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Resource
    private PersonDao personDao;
    @Resource
    private CacheService cacheService;

    @Override
    public void insertPerson(Person person) {
        personDao.insertPerson(person);
    }

    @Override
    public void updatePerson(Person person) {
        personDao.updatePerson(person);
        this.refreshPersonCache(person.getPersonId());
    }

    @Override
    public void deletePerson(Integer personId) {
        personDao.deletePerson(personId);
        this.refreshPersonCache(personId);
    }

    @Override
    public List<Person> queryPersonList(Person person) {
        return personDao.queryPersonList(person);
    }

    @Override
    public Person queryPersonByPersonId(Integer personId) {
        String personCacheKey = "person_" + personId;

        String personJson = cacheService.get(personCacheKey);
        if (StringUtils.isNotBlank(personJson)) {
            return JSON.parseObject(personJson, Person.class);
        }
        Person person = personDao.queryPersonByPersonId(personId);
        if (person != null) {
            cacheService.set(personCacheKey, JSON.toJSONString(person));
        }
        return person;
    }

    @Override
    public void refreshPersonCache(Integer personId) {
        String personCacheKey = "person_" + personId;
        cacheService.del(personCacheKey);
    }
}
