package org.kyou.stack.dubbo.dao.impl;

import com.alibaba.fastjson.JSON;
import org.kyou.stack.dubbo.dao.BaseDao;
import org.kyou.stack.dubbo.dao.PersonDao;
import org.kyou.stack.dubbo.domain.po.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PersonDaoImpl extends BaseDao implements PersonDao {
    private static final Logger logger = LoggerFactory.getLogger(PersonDaoImpl.class);

    @Override
    public void insertPerson(Person person) {
        int ret = this.insert("org.kyou.stack.dubbo.domain.po.Person.insertPerson", person);
        logger.info("insert person ret:{}", ret);
    }

    @Override
    public void updatePerson(Person person) {
        int ret = this.update("org.kyou.stack.dubbo.domain.po.Person.updatePerson", person);
        logger.info("delete person ret:{}", ret);
    }

    @Override
    public void deletePerson(Integer personId) {
        int ret = this.delete("org.kyou.stack.dubbo.domain.po.Person.deletePerson", personId);
        logger.info("delete person ret:{}, personId:{}", ret, personId);
    }

    @Override
    public List<Person> queryPersonList(Person person) {
        List<Person> personList = this.selectList("org.kyou.stack.dubbo.domain.po.Person.queryPersonList", person);
        logger.info("query person list:{}", JSON.toJSON(personList));
        return personList;
    }

    @Override
    public Person queryPersonByPersonId(Integer personId) {
        Person person = this.selectOne("org.kyou.stack.dubbo.domain.po.Person.queryPersonByPersonId", personId);
        logger.info("query person:{}, personId:{}", JSON.toJSON(person), personId);
        return person;
    }
}
