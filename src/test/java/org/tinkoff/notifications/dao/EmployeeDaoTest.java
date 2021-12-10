package org.tinkoff.notifications.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeDaoTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void findEmployee() {
        System.out.println(employeeDao.findById(1L));
    }
}
