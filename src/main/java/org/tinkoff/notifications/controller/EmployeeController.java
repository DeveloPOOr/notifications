package org.tinkoff.notifications.controller;

import org.springframework.web.bind.annotation.*;
import org.tinkoff.notifications.dto.EmployeeDto;
import org.tinkoff.notifications.model.Employee;
import org.tinkoff.notifications.service.EmployeeService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public void saveEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        employeeService.save(employeeDto);
    }

    @GetMapping("/get")
    public Employee findById(@RequestParam("employee_id")long employee_id) {
        Employee employee = employeeService.findById(employee_id);
        return employee;
    }

    @PatchMapping("/update")
    public void updateEmployee(@RequestBody @Valid Employee employee) {
        employeeService.update(employee);
    }

    @DeleteMapping("/delete")
    public void deleteEmployee(@RequestBody @Valid Employee employee) {
        employeeService.delete(employee);
    }
}
