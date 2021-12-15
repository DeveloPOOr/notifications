package org.tinkoff.notifications.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tinkoff.notifications.dao.ProjectDao;
import org.tinkoff.notifications.dto.ProjectDto;
import org.tinkoff.notifications.model.Project;

@Service
public class ProjectService {

    private final ProjectDao projectDao;
    private final Logger logger = LoggerFactory.getLogger(ProjectService.class);

    public ProjectService(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public void save(ProjectDto projectDto) {
        projectDao.save(projectDto);
        logger.info("Project " + projectDto + " was saved");
    }

    public Project findById(long id) {
        Project project = projectDao.findById(id);
        logger.info("Project with id " + id + " was found");
        return project;
    }

    public void update(Project project) {
        projectDao.update(project);
        logger.info("Project " + project + " was updated");
    }

    public void delete(Project project) {
        projectDao.delete(project);
        logger.info("Project " + project + " was deleted");
    }
}
