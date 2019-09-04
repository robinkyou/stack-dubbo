package org.kyou.stack.dubbo.web.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kyou.stack.dubbo.common.domain.Result;
import org.kyou.stack.dubbo.domain.po.Person;
import org.kyou.stack.dubbo.domain.res.PersonRes;
import org.kyou.stack.dubbo.export.PersonResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config.xml")
public class PersonResourceTest {
    private static final Logger logger = LoggerFactory.getLogger(PersonResourceTest.class);

    @Resource
    private PersonResource personRpc;

    @Test
    public void test_insertPerson() {
        Person person = new Person();
        person.setName("robinkyou");
        person.setAge(32);
        Result res = personRpc.insertPerson(person);
        logger.info(JSON.toJSONString(res));
    }

    @Test
    public void test_updatePerson() {
        Person person = new Person();
        person.setPersonId(11);
        person.setName("luren_yi");
        person.setAge(50);
        Result res = personRpc.updatePerson(person);
        logger.info(JSON.toJSONString(res));
    }

    @Test
    public void test_deletePerson() {
        Integer personId = 100;
        Result res = personRpc.deletePerson(personId);
        logger.info(JSON.toJSONString(res));
    }

    @Test
    public void test_queryPersonList() {
        Person person = new Person();
        person.setName("robinkyou");
        PersonRes res = personRpc.queryPersonList(person);
        logger.info(JSON.toJSONString(res));
    }

    @Test
    public void test_queryPersonByPersonId() {
        Integer personId = 10;
        PersonRes res = personRpc.queryPersonByPersonId(personId);
        logger.info(JSON.toJSONString(res));
    }
}
