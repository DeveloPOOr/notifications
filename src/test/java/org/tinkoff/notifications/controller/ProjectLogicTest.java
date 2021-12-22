package org.tinkoff.notifications.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.tinkoff.notifications.AbstractTest;
import org.tinkoff.notifications.constraint.ApplicationError;
import org.tinkoff.notifications.model.Project;
import org.tinkoff.notifications.service.ProjectService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.tinkoff.notifications.constraint.ApplicationError.NO_PROJECT;

@AutoConfigureMockMvc
public class ProjectLogicTest extends AbstractTest {

    private final ObjectMapper jackson = new ObjectMapper();
    @Autowired private MockMvc mockMvc;
    @Autowired private ProjectService projectService;

    @Test
    public void successSaveProject() throws Exception {
        long id = 8;
        var project = jackson.writeValueAsString(preparedProject(id));

        mockMvc.perform(
                        post("/api/project/save")
                                .contentType(MediaType.APPLICATION_JSON)
                                .with(httpBasic("admin", "admin"))
                                .content(project))
                .andExpect(status().isOk());
    }

    @Test
    public void notValidSaveProject() throws Exception {
        long id = 8;
        var project = jackson.writeValueAsString(preparedNotValidProject(id));

        mockMvc.perform(
                        post("/api/project/save")
                                .contentType(MediaType.APPLICATION_JSON)
                                .with(httpBasic("admin", "admin"))
                                .content(project))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getProject() throws Exception {
        long id = 1;
        var project = jackson.writeValueAsString(preparedProject(id));

        mockMvc.perform(
                        get("/api/project/get")
                                .param("project_id", String.valueOf(id))
                                .with(httpBasic("admin", "admin")))
                .andExpect(status().isOk())
                .andExpect(content().string(project));
    }

    @Test
    public void getNotExistProject() throws Exception {
        long id = 10;
        var noProjectException = jackson.writeValueAsString(noProjectException(id));
        mockMvc.perform(
                        get("/api/project/get")
                                .param("project_id", String.valueOf(id))
                                .with(httpBasic("admin", "admin")))
                .andExpect(status().is(NO_PROJECT.code))
                .andExpect(content().string(noProjectException));
    }

    @Test
    public void updateProject() throws Exception {
        long id = 2;
        var project = preparedProject(id);
        project.setDescription("update");
        var projectString = jackson.writeValueAsString(project);
        mockMvc.perform(
                        patch("/api/project/update")
                                .contentType(MediaType.APPLICATION_JSON)
                                .with(httpBasic("admin", "admin"))
                                .content(projectString))
                .andExpect(status().isOk());

        assertEquals(projectString, jackson.writeValueAsString(projectService.findById(id)));
    }

    @Test
    public void deleteProject() throws Exception {
        long id = 3;
        var project = jackson.writeValueAsString(preparedProject(id));
        mockMvc.perform(
                        delete("/api/project/delete")
                                .contentType(MediaType.APPLICATION_JSON)
                                .with(httpBasic("admin", "admin"))
                                .content(project))
                .andExpect(status().isOk());

        assertEquals(null, projectService.findById(3));
    }

    private ApplicationError.ApplicationException.ApplicationExceptionCompanion noProjectException(
            long id) {
        return NO_PROJECT.exception(String.format("with id %d", id)).companion;
    }

    public Project preparedProject(long id) {
        return new Project(id, "Just Tinkoff" + id, "Just description" + id);
    }

    public Project preparedNotValidProject(long id) {
        return new Project(id, "", "Just description" + id);
    }
}
