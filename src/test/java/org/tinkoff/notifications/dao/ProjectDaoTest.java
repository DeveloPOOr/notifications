package org.tinkoff.notifications.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.tinkoff.notifications.dto.ProjectDto;
import org.tinkoff.notifications.model.Project;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProjectDaoTest {

    @Autowired
    private ProjectDao projectDao;

    @Test
    public void saveProject() {
        projectDao.save(preparedProjectDto());
    }

    @Test
    public void getProject() {
        assertEquals(projectDao.findById(1L), preparedProject(1L));
    }

    @Test
    public void updateProject() {
        Project project = preparedProject(4L);
        project.setDescription("update");
        projectDao.update(project);
        assertEquals(projectDao.findById(4L), project);
    }

    @Test
    public void deleteProject() {
        projectDao.delete(preparedProject(4L));
    }


    public Project preparedProject(long id) {
        return new Project(
                id,
                "TestName",
                "good Present"
        );
    }

    public ProjectDto preparedProjectDto() {
        return new ProjectDto(
                "TestName",
                "good Present"
        );
    }
}
