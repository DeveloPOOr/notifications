package org.tinkoff.notifications.dao;

import org.apache.ibatis.annotations.Mapper;
import org.tinkoff.notifications.model.Present;

@Mapper
public interface PresentDao {

    long save(Present present, long employeeId);

    Present findById(long id);

    void update(Present present);

    void delete(Present present);
}
