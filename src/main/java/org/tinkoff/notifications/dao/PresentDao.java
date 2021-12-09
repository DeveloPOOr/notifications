package org.tinkoff.notifications.dao;

import org.apache.ibatis.annotations.Mapper;
import org.tinkoff.notifications.model.Present;


@Mapper
public interface PresentDao {
    void save(Present project);

    Present findById(long id);

    void update(Present course);

    void delete(Present course);
}
