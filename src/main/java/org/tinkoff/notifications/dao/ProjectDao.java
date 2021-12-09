package org.tinkoff.notifications.dao;


import org.apache.ibatis.annotations.Mapper;
import org.tinkoff.notifications.model.Employee;
import org.tinkoff.notifications.model.Project;

import java.util.List;

@Mapper
public interface ProjectDao {

    void save(Project project);

    Project findById(long id);

    void update(Project course);

    void delete(Project course);
}
