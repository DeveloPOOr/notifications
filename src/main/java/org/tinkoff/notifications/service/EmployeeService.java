package org.tinkoff.notifications.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tinkoff.notifications.dao.EmployeeDao;
import org.tinkoff.notifications.model.Employee;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;
    private final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public Employee save(Employee employee) {
        employeeDao.save(employee);
        logger.info("Employee " + employee + " was saved");
        return employee;
    }

    public Employee findById(long id) {
        Employee employee = employeeDao.findById(id);
        logger.info("Employee with id " + id + " was found");
        return employee;
    }

    public void update(Employee employee) {
        employeeDao.update(employee);
        logger.info("Employee " + employee + " was updated");
    }

    public void delete(Employee employee) {
        employeeDao.delete(employee);
        logger.info("Employee " + employee + " was deleted");
    }
}
