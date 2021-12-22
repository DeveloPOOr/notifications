package org.tinkoff.notifications.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.tinkoff.notifications.AbstractTest;
import org.tinkoff.notifications.constraint.ApplicationError;
import org.tinkoff.notifications.model.Present;
import org.tinkoff.notifications.service.PresentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.tinkoff.notifications.constraint.ApplicationError.NO_PRESENT;

@AutoConfigureMockMvc
public class PresentLogicTest extends AbstractTest {

    private final ObjectMapper jackson = new ObjectMapper();
    @Autowired private MockMvc mockMvc;
    @Autowired private PresentService presentService;

    @Test
    public void successSavePresent() throws Exception {
        long id = 8;
        long employee_id = 5;
        var present = jackson.writeValueAsString(preparedPresent2(id, employee_id));

        mockMvc.perform(
                        post("/api/present/save")
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("employee_id", String.valueOf(employee_id))
                                .with(httpBasic("admin", "admin"))
                                .content(present))
                .andExpect(status().isOk());
    }

    @Test
    public void notValidSavePresent() throws Exception {
        long id = 8;
        long employee_id = 5;
        var present = jackson.writeValueAsString(preparedNotValidPresent(id, employee_id));

        mockMvc.perform(
                        post("/api/present/save")
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("employee_id", String.valueOf(employee_id))
                                .with(httpBasic("admin", "admin"))
                                .content(present))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getPresent() throws Exception {
        long id = 1;
        long employee_id = 1;
        var present = jackson.writeValueAsString(preparedPresent(id, employee_id));

        mockMvc.perform(
                        get("/api/present/get")
                                .param("present_id", String.valueOf(id))
                                .with(httpBasic("admin", "admin")))
                .andExpect(status().isOk())
                .andExpect(content().string(present));
    }

    @Test
    public void getNotExistPresent() throws Exception {
        long id = 100;
        var noPresentException = jackson.writeValueAsString(noPresentException(id));
        mockMvc.perform(
                        get("/api/present/get")
                                .param("present_id", String.valueOf(id))
                                .with(httpBasic("admin", "admin")))
                .andExpect(status().is(NO_PRESENT.code))
                .andExpect(content().string(noPresentException));
    }

    @Test
    public void updatePresent() throws Exception {
        long id = 2;
        long employee_id = 1;
        var present = preparedPresent(id, employee_id);
        present.setLink("https://www.google.com");
        var presentString = jackson.writeValueAsString(present);
        mockMvc.perform(
                        patch("/api/present/update")
                                .contentType(MediaType.APPLICATION_JSON)
                                .with(httpBasic("admin", "admin"))
                                .content(presentString))
                .andExpect(status().isOk());

        assertEquals(presentString, jackson.writeValueAsString(presentService.findById(id)));
    }

    @Test
    public void deletePresent() throws Exception {
        long id = 3;
        long employee_id = 1;
        var present2 = preparedPresent(id, employee_id);
        present2.setLink("https://www.google.com");
        var present = jackson.writeValueAsString(present2);
        mockMvc.perform(
                        delete("/api/present/delete")
                                .contentType(MediaType.APPLICATION_JSON)
                                .with(httpBasic("admin", "admin"))
                                .content(present))
                .andExpect(status().isOk());

        assertEquals(null, presentService.findById(3));
    }

    private ApplicationError.ApplicationException.ApplicationExceptionCompanion noPresentException(
            long id) {
        return NO_PRESENT.exception(String.format("with id %d", id)).companion;
    }

    public Present preparedPresent(long id, long employee_id) {
        return new Present(id, "Present" + id, "link" + id, "Description" + id, employee_id);
    }

    public Present preparedPresent2(long id, long employee_id) {
        return new Present(
                id, "Present" + id, "https://www.google.com", "Description" + id, employee_id);
    }

    public Present preparedNotValidPresent(long id, long employee_id) {
        return new Present(id, "", "Description" + id, "link" + id, employee_id);
    }
}
