package org.tinkoff.notifications.dao;


import org.apache.ibatis.annotations.Mapper;
import org.tinkoff.notifications.model.Employee;
import org.tinkoff.notifications.model.Project;

import java.util.Set;

@Mapper
public interface EmployeeProjectDao {

    void addEmployee(long project, long employee);

    void deleteEmployee(long project, long employee);

    Set<Employee> getEmployees(Project project);

    Set<Project> getProjects(Employee employee);
}
