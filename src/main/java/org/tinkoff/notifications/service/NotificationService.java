package org.tinkoff.notifications.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.tinkoff.notifications.dao.NotificationDao;
import org.tinkoff.notifications.dto.NotificationDto;
import org.tinkoff.notifications.model.Notification;

import java.sql.Date;
import java.util.Calendar;

@Service
public class NotificationService {

    private NotificationDao notificationDao;
    private Logger logger = LoggerFactory.getLogger(NotificationService.class);

    public NotificationService(NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }

    public void save(NotificationDto notificationDto) {
        notificationDao.save(notificationDto);
        logger.info("Notification " + notificationDto + " was saved to employee with id " + notificationDto.getEmployee().getId());
    }

    public Notification findById(long id) {
        Notification notification = notificationDao.findById(id);
        logger.info("Notification with id " + id + " was found");
        return notification;
    }

    public void update(Notification notification) {
        notificationDao.update(notification);
        logger.info("Notification " + notification + " was updated");
    }

    public void delete(Notification notification) {
        notificationDao.delete(notification);
        logger.info("Notification " + notification + " was deleted");
    }

    @Scheduled(fixedDelayString = "${notifications.delay}")
    public void createNotifications() {
        java.sql.Date startPeriod = new java.sql.Date(new java.util.Date().getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(startPeriod);
        c.add(Calendar.DATE, 7);
        java.sql.Date endPeriod = new java.sql.Date(c.getTimeInMillis());
//        java.sql.Date startPeriod = Date.valueOf("1999-12-20");
//        java.sql.Date endPeriod = new java.sql.Date(new java.util.Date().getTime());
        notificationDao.createBirthdays(startPeriod, endPeriod);
        notificationDao.createAnniversaries(startPeriod, endPeriod);
    }

}
