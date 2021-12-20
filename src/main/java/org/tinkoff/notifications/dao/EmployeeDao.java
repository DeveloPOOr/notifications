package org.tinkoff.notifications.dao;

import org.apache.ibatis.annotations.Mapper;
import org.tinkoff.notifications.model.Employee;

@Mapper
public interface EmployeeDao {

    long save(Employee employee);

    Employee findById(long id);

    void update(Employee course);

    void delete(Employee course);
}
