package org.kyou.stack.dubbo.dao;

import org.kyou.stack.dubbo.domain.po.Person;

import java.util.List;

public interface PersonDao {
    void insertPerson(Person person);

    void updatePerson(Person person);

    void deletePerson(Integer personId);

    List<Person> queryPersonList(Person person);

    Person queryPersonByPersonId(Integer personId);
}
