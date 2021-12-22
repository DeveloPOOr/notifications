package org.tinkoff.notifications.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.tinkoff.notifications.AbstractTest;
import org.tinkoff.notifications.service.EmployeeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class AuthTest extends AbstractTest {

    private final ObjectMapper jackson = new ObjectMapper();
    @Autowired private MockMvc mockMvc;
    @Autowired private EmployeeService employeeService;

    @Test
    public void getYourInformation() throws Exception {
        long id = 1;

        mockMvc.perform(
                        get("/api/employee/get")
                                .param("employee_id", String.valueOf(id))
                                .with(httpBasic("user" + id, "user")))
                .andExpect(status().isOk());
    }

    @Test
    public void getOtherInformation() throws Exception {
        long id = 1;
        long anotherId = 2;
        mockMvc.perform(
                        get("/api/employee/get")
                                .param("employee_id", String.valueOf(id))
                                .with(httpBasic("user" + anotherId, "user")))
                .andExpect(status().isOk());
    }

    @Test
    public void updateYourInformation() throws Exception {
        long id = 2;
        var employee = employeeService.findById(id);
        employee.setCity("New York");
        var employeeString = jackson.writeValueAsString(employee);
        mockMvc.perform(
                        patch("/api/employee/update")
                                .contentType(MediaType.APPLICATION_JSON)
                                .with(httpBasic("user" + id, "user"))
                                .content(employeeString))
                .andExpect(status().isOk());

        assertEquals(employeeString, jackson.writeValueAsString(employeeService.findById(id)));
    }

    @Test
    public void updateByAdmin() throws Exception {
        long id = 7;
        var employee = employeeService.findById(id);
        employee.setCity("New York");
        var employeeString = jackson.writeValueAsString(employee);
        mockMvc.perform(
                        patch("/api/employee/update")
                                .contentType(MediaType.APPLICATION_JSON)
                                .with(httpBasic("admin", "admin"))
                                .content(employeeString))
                .andExpect(status().isOk());

        assertEquals(employeeString, jackson.writeValueAsString(employeeService.findById(id)));
    }

    @Test
    public void otherUsersCantUpdateYourInformation() throws Exception {
        long id = 7;
        long otherId = 10;
        var employee = employeeService.findById(id);
        employee.setCity("New York");
        var employeeString = jackson.writeValueAsString(employee);
        mockMvc.perform(
                        patch("/api/employee/update")
                                .contentType(MediaType.APPLICATION_JSON)
                                .with(httpBasic("user" + otherId, "admin"))
                                .content(employeeString))
                .andExpect(status().isUnauthorized());
    }
}
