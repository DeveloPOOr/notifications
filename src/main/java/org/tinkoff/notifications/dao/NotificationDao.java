package org.tinkoff.notifications.dao;

import org.apache.ibatis.annotations.Mapper;
import org.tinkoff.notifications.dto.NotificationDto;
import org.tinkoff.notifications.model.Notification;


@Mapper
public interface NotificationDao {

    void save(NotificationDto notification);

    Notification findById(long id);

    void update(Notification course);

    void delete(Notification course);
}
