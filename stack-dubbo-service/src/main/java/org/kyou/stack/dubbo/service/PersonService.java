package org.kyou.stack.dubbo.service;

import org.kyou.stack.dubbo.domain.po.Person;

import java.util.List;

public interface PersonService {
    /**
     * 新增用户
     * @param person
     */
    void insertPerson(Person person);

    /**
     * 更新用户
     * @param person
     */
    void updatePerson(Person person);

    /**
     * 删除用户
     * @param personId
     */
    void deletePerson(Integer personId);

    /**
     * 查询用户列表
     * @param person
     * @return
     */
    List<Person> queryPersonList(Person person);

    /**
     * 根据用户ID查询用户
     * @param personId
     * @return
     */
    Person queryPersonByPersonId(Integer personId);

    /**
     *  刷新用户缓存
     * @param personId
     */
    void refreshPersonCache(Integer personId);
}
