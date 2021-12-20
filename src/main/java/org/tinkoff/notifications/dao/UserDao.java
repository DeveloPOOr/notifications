package org.tinkoff.notifications.dao;

import org.apache.ibatis.annotations.Mapper;
import org.tinkoff.notifications.model.Employee;
import org.tinkoff.notifications.security.User;

@Mapper
public interface UserDao {

    User findByName(String name);
    User save(User user, Employee employee);
}
