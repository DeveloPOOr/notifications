package org.tinkoff.notifications.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tinkoff.notifications.dao.EmployeeProjectDao;
import org.tinkoff.notifications.dao.ProjectDao;
import org.tinkoff.notifications.model.Project;

@Service
public class ProjectService {

    private final ProjectDao projectDao;
    private final EmployeeProjectDao employeeProjectDao;
    private final Logger logger = LoggerFactory.getLogger(ProjectService.class);

    public ProjectService(ProjectDao projectDao, EmployeeProjectDao employeeProjectDao) {
        this.projectDao = projectDao;
        this.employeeProjectDao = employeeProjectDao;
    }

    public Project save(Project project) {
        projectDao.save(project);
        logger.info("Project " + project + " was saved");
        return project;
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

    public void addEmployee(long employeeId, long projectId) {
        employeeProjectDao.addEmployee(projectId, employeeId);
        logger.info("Employee with id " + employeeId + " was added to project with id" + projectId);
    }
}
