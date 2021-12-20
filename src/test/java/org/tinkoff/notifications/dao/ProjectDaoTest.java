package org.tinkoff.notifications.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.tinkoff.notifications.dto.ProjectDto;
import org.tinkoff.notifications.model.Project;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class ProjectDaoTest {

    @Autowired private ProjectDao projectDao;

    @Test
    public void saveProject() {
        projectDao.save(preparedProjectDto());
        assertEquals(projectDao.findById(4L), preparedProject(4L));
    }

    @Test
    public void getProject() {
        assertEquals(
                projectDao.findById(1L), new Project(1L, "Тинькофф инвестиции", "Про инвестиции"));
    }

    @Test
    public void updateProject() {
        Project project = preparedProject(2L);
        project.setDescription("update");
        projectDao.update(project);
        assertEquals(projectDao.findById(2L), project);
    }

    @Test
    public void deleteProject() {
        projectDao.delete(preparedProject(3L));
        assertEquals(projectDao.findById(3L), null);
    }

    public Project preparedProject(long id) {
        return new Project(id, "TestName", "good Present");
    }

    public ProjectDto preparedProjectDto() {
        return new ProjectDto("TestName", "good Present");
    }
}
