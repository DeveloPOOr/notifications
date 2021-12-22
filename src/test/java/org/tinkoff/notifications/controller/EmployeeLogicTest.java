package org.tinkoff.notifications.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.tinkoff.notifications.AbstractTest;
import org.tinkoff.notifications.constraint.ApplicationError;
import org.tinkoff.notifications.dto.UserDto;
import org.tinkoff.notifications.service.EmployeeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.tinkoff.notifications.constraint.ApplicationError.NO_EMPLOYEE;

@AutoConfigureMockMvc
public class EmployeeLogicTest extends AbstractTest {

    private final ObjectMapper jackson = new ObjectMapper();
    @Autowired private MockMvc mockMvc;
    @Autowired private EmployeeService employeeService;

    @Test
    public void successSaveEmployee() throws Exception {
        long id = 11;
        var employee = jackson.writeValueAsString(preparedUserDto(id));

        mockMvc.perform(
                        post("/auth/register")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(employee))
                .andExpect(status().isOk());
    }

    @Test
    public void notValidSaveEmployee() throws Exception {
        long id = 12;
        var employee = jackson.writeValueAsString(notValidPreparedUserDto(id));

        mockMvc.perform(
                        post("/api/employee/save")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(employee))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getEmployee() throws Exception {
        long id = 1;
        var employee = jackson.writeValueAsString(employeeService.findById(id));

        mockMvc.perform(
                        get("/api/employee/get")
                                .param("employee_id", String.valueOf(id))
                                .with(httpBasic("admin", "admin")))
                .andExpect(status().isOk())
                .andExpect(content().string(employee));
    }

    @Test
    public void getNotExistEmployee() throws Exception {
        long id = 12;
        var noEmployeeException = jackson.writeValueAsString(noEmployeeException(id));
        mockMvc.perform(
                        get("/api/employee/get")
                                .param("employee_id", String.valueOf(id))
                                .with(httpBasic("admin", "admin")))
                .andExpect(status().is(NO_EMPLOYEE.code))
                .andExpect(content().string(noEmployeeException));
    }

    @Test
    public void updateEmployee() throws Exception {
        long id = 2;
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
    public void deleteEmployee() throws Exception {
        long id = 8;
        mockMvc.perform(
                        delete("/auth/delete")
                                .contentType(MediaType.APPLICATION_JSON)
                                .with(httpBasic("admin", "admin"))
                                .param("username", "user" + id))
                .andExpect(status().isOk());

        assertEquals(null, employeeService.findById(id));
    }

    private ApplicationError.ApplicationException.ApplicationExceptionCompanion noEmployeeException(
            long id) {
        return NO_EMPLOYEE.exception(String.format("with id %d", id)).companion;
    }

    public UserDto preparedUserDto(long id) {
        UserDto employee = new UserDto();
        employee.setPassword("user");
        employee.setBirthday("2002-12-28");
        employee.setPhone("+79992434271");
        employee.setStart_work("2018-10-10");
        employee.setFull_name("Zubenko Mikhail Petrovich" + id);
        employee.setCity("London");
        employee.setUsername("user" + id);
        return employee;
    }

    public UserDto notValidPreparedUserDto(long id) {
        UserDto employee = new UserDto();
        employee.setPassword("user");
        employee.setBirthday("2002-"); // not valid birthday
        employee.setPhone("+79992434271");
        employee.setStart_work("2018-10-10");
        employee.setFull_name("Zubenko Mikhail Petrovich" + id);
        employee.setCity("London");
        employee.setUsername("user" + id);
        return employee;
    }
}
