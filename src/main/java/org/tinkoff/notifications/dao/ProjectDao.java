package org.tinkoff.notifications.dao;


import org.apache.ibatis.annotations.Mapper;
import org.tinkoff.notifications.dto.ProjectDto;
import org.tinkoff.notifications.model.Employee;
import org.tinkoff.notifications.model.Project;

import java.util.List;

@Mapper
public interface ProjectDao {

    void save(ProjectDto project);

    Project findById(long id);

    void update(Project course);

    void delete(Project course);
}
