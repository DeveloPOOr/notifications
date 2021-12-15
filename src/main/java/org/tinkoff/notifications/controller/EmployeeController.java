package org.tinkoff.notifications.controller;

import org.springframework.web.bind.annotation.*;
import org.tinkoff.notifications.dto.EmployeeDto;
import org.tinkoff.notifications.model.Employee;
import org.tinkoff.notifications.model.Notification;
import org.tinkoff.notifications.service.EmployeeService;
import org.tinkoff.notifications.service.NotificationService;

import javax.validation.Valid;
import java.util.Set;

import static org.tinkoff.notifications.constraint.ApplicationError.NO_EMPLOYEE;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final NotificationService notificationService;

    public EmployeeController(
            EmployeeService employeeService, NotificationService notificationService) {
        this.employeeService = employeeService;
        this.notificationService = notificationService;
    }

    @PostMapping("/save")
    public void saveEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        employeeService.save(employeeDto);
    }

    @GetMapping("/get")
    public Employee findById(@RequestParam("employee_id") long employee_id) {
        Employee employee = employeeService.findById(employee_id);
        if (employee == null) {
            throw NO_EMPLOYEE.exception(String.format("with id %d", employee_id));
        }
        return employee;
    }

    @PatchMapping("/update")
    public void updateEmployee(@RequestBody @Valid Employee employee) {
        Employee employeeCheck = employeeService.findById(employee.getId());
        if (employeeCheck == null) {
            throw NO_EMPLOYEE.exception(String.format("with id %d", employee.getId()));
        }
        employeeService.update(employee);
    }

    @DeleteMapping("/delete")
    public void deleteEmployee(@RequestBody @Valid Employee employee) {
        Employee employeeCheck = employeeService.findById(employee.getId());
        if (employeeCheck == null) {
            throw NO_EMPLOYEE.exception(String.format("with id %d", employee.getId()));
        }
        employeeService.delete(employee);
    }

    @GetMapping("/getMyNotifications")
    public Set<Notification> getMyNotifications(@RequestParam("employee_id") long employee_id) {
        Employee employee = employeeService.findById(employee_id);
        if (employee == null) {
            throw NO_EMPLOYEE.exception(String.format("with id %d", employee_id));
        }
        return notificationService.getColleaguesNotificationsById(employee_id);
    }
}
