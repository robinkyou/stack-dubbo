package org.kyou.stack.dubbo.domain.res;

import org.kyou.stack.dubbo.common.domain.Result;
import org.kyou.stack.dubbo.domain.po.Person;

import java.util.List;

public class PersonRes {
    private Result result;
    private Integer count;
    private List<Person> personList;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
