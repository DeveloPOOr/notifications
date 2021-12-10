package org.tinkoff.notifications.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.tinkoff.notifications.dto.NotificationDto;
import org.tinkoff.notifications.model.Notification;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NotificationDaoTest {

    @Autowired
    private NotificationDao notificationDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void save() {
        notificationDao.save(new NotificationDto("BIRTHDAY", employeeDao.findById(1)));
    }

    @Test
    public void findByIdTest() {
        System.out.println(notificationDao.findById(3L));
    }

}