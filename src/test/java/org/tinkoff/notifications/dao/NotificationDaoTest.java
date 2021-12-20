package org.tinkoff.notifications.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.tinkoff.notifications.dto.NotificationDto;
import org.tinkoff.notifications.model.Employee;
import org.tinkoff.notifications.model.Notification;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public
class NotificationDaoTest {

//    @Autowired private NotificationDao notificationDao;
//    @Autowired private EmployeeDao employeeDao;
//
//    @Test
//    public void save() {
//        notificationDao.save(preparedNotificationDto(employeeDao.findById(1L)));
//        assertEquals(
//                notificationDao.findById(1L), preparedNotification(1L, employeeDao.findById(1L)));
//    }
//
//    @Test
//    public void findByIdTest() {
//        assertEquals(
//                preparedNotification(2L, employeeDao.findById(2L)), notificationDao.findById(2L));
//    }
//
//    @Test
//    public void update() {
//        Notification notification = preparedNotification(4L, employeeDao.findById(3L));
//        notification.setType("BIRTHDAY");
//        notificationDao.update(notification);
//        assertEquals(notificationDao.findById(4L), notification);
//    }
//
//    @Test
//    public void delete() {
//        Employee employee = employeeDao.findById(3L);
//        notificationDao.delete(preparedNotification(3L, employee));
//        assertEquals(notificationDao.findById(3L), null);
//    }
//
//    public Notification preparedNotification(long id, Employee employee) {
//        return new Notification(id, "BIRTHDAY", employee);
//    }
//
//    public NotificationDto preparedNotificationDto(Employee employee) {
//        return new NotificationDto("BIRTHDAY", employee);
//    }
}
