package org.tinkoff.notifications.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.tinkoff.notifications.dto.PresentDto;
import org.tinkoff.notifications.dto.ProjectDto;

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
        System.out.println(projectDao.findById(1L));
    }



    public ProjectDto preparedProjectDto() {
        return new ProjectDto(
                "TestName",
                "good Present"
        );
    }
}
