package org.tinkoff.notifications.dao;

import org.apache.ibatis.annotations.Mapper;
import org.tinkoff.notifications.dto.NotificationDto;
import org.tinkoff.notifications.model.Notification;

import java.sql.Date;
import java.util.Set;

@Mapper
public interface NotificationDao {

    long save(Notification notification);

    Notification findById(long id);

    void update(Notification course);

    void delete(Notification course);

    void createBirthdays(Date startPeriod, Date endPeriod);

    void createAnniversaries(Date startPeriod, Date endPeriod);

    void createColleagueNotifications();

    Set<Notification> getColleaguesNotificationByEmployeeId(long employee_id);
}
