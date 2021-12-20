package org.tinkoff.notifications.dao;

import org.apache.ibatis.annotations.Mapper;
import org.tinkoff.notifications.model.Project;

@Mapper
public interface ProjectDao {

    long save(Project project);

    Project findById(long id);

    void update(Project course);

    void delete(Project course);
}
