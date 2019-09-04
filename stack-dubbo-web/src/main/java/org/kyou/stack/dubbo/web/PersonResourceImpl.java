package org.kyou.stack.dubbo.web;

import org.kyou.stack.dubbo.common.domain.Result;
import org.kyou.stack.dubbo.common.enums.ErrorCodeEnum;
import org.kyou.stack.dubbo.domain.po.Person;
import org.kyou.stack.dubbo.domain.res.PersonRes;
import org.kyou.stack.dubbo.export.PersonResource;
import org.kyou.stack.dubbo.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class PersonResourceImpl implements PersonResource {

    private static final Logger logger = LoggerFactory.getLogger(PersonResourceImpl.class);

    @Resource
    private PersonService personService;

    @Override
    public Result insertPerson(Person req) {
        Result res = Result.buildCommonResult(ErrorCodeEnum.SUCCESS);
        try {
            personService.insertPerson(req);
        } catch (DuplicateKeyException e) {
            res = Result.buildCommonResult(ErrorCodeEnum.UNIQUE_INDEX);
            logger.error("新增用户已存在", e);
        } catch (Exception e) {
            res = Result.buildCommonResult(ErrorCodeEnum.EXCEPTION);
            logger.error("新增用户异常", e);
        }
        return res;
    }

    @Override
    public Result updatePerson(Person req) {
        Result res = Result.buildCommonResult(ErrorCodeEnum.SUCCESS);
        try {
            personService.updatePerson(req);
        } catch (Exception e) {
            res = Result.buildCommonResult(ErrorCodeEnum.EXCEPTION);
            logger.error("更新用户异常", e);
        }
        return res;
    }

    @Override
    public Result deletePerson(Integer personId) {
        Result res = Result.buildCommonResult(ErrorCodeEnum.SUCCESS);
        try {
            personService.deletePerson(personId);
        } catch (Exception e) {
            res = Result.buildCommonResult(ErrorCodeEnum.EXCEPTION);
            logger.error("删除用户异常", e);
        }
        return res;
    }

    @Override
    public PersonRes queryPersonByPersonId(Integer personId) {
        PersonRes res = new PersonRes();
        res.setResult(Result.buildCommonResult(ErrorCodeEnum.SUCCESS));
        try {
            Person person = personService.queryPersonByPersonId(personId);
            res.setCount(person == null ? 0 : 1);
            List<Person> personList = new ArrayList<>();
            personList.add(person);
            res.setPersonList(personList);
        } catch (Exception e) {
            res.setResult(Result.buildCommonResult(ErrorCodeEnum.EXCEPTION));
            logger.error("查询用户异常", e);
        }
        return res;
    }

    @Override
    public PersonRes queryPersonList(Person req) {
        PersonRes res = new PersonRes();
        res.setResult(Result.buildCommonResult(ErrorCodeEnum.SUCCESS));
        try {
            List<Person> personList = personService.queryPersonList(req);
            res.setCount(CollectionUtils.isEmpty(personList) ? 0 : personList.size());
            res.setPersonList(personList);
        } catch (Exception e) {
            res.setResult(Result.buildCommonResult(ErrorCodeEnum.EXCEPTION));
            logger.error("查询用户列表异常", e);
        }
        return res;
    }
}
