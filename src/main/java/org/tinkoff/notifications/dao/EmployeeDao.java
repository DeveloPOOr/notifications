package org.tinkoff.notifications.dao;


import org.apache.ibatis.annotations.Mapper;
import org.tinkoff.notifications.model.Employee;

import java.util.List;

@Mapper
public interface EmployeeDao {

    void save(Employee employee);

    Employee findById(long id);

    void update(Employee course);

    void delete(Employee course);
}
