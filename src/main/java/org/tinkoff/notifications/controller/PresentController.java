package org.tinkoff.notifications.controller;

import org.springframework.web.bind.annotation.*;
import org.tinkoff.notifications.model.Employee;
import org.tinkoff.notifications.model.Present;
import org.tinkoff.notifications.service.EmployeeService;
import org.tinkoff.notifications.service.PresentService;

import static org.tinkoff.notifications.constraint.ApplicationError.NO_EMPLOYEE;
import static org.tinkoff.notifications.constraint.ApplicationError.NO_PRESENT;

@RestController
@RequestMapping("/api/present")
public class PresentController {

    private final PresentService presentService;
    private final EmployeeService employeeService;

    public PresentController(PresentService presentService, EmployeeService employeeService) {
        this.presentService = presentService;
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public Present savePresent(
            @RequestBody Present present, @RequestParam("employee_id") long employee_id) {
        Employee employee = employeeService.findById(employee_id);
        if (employee == null) {
            throw NO_EMPLOYEE.exception(String.format("with id %d", employee_id));
        }
        return presentService.save(present, employee_id);
    }

    @GetMapping("/get")
    public Present findById(@RequestParam("present_id") long present_id) {
        Present present = presentService.findById(present_id);
        if (present == null) {
            throw NO_PRESENT.exception(String.format("with id %d", present_id));
        }
        return present;
    }

    @PatchMapping("/update")
    public void updatePresent(@RequestBody Present present) {
        Present presentCheck = presentService.findById(present.getId());
        if (presentCheck == null) {
            throw NO_PRESENT.exception(String.format("with id %d", present.getId()));
        }
        presentService.update(present);
    }

    @DeleteMapping("/delete")
    public void deletePresent(@RequestBody Present present) {
        Present presentCheck = presentService.findById(present.getId());
        if (presentCheck == null) {
            throw NO_PRESENT.exception(String.format("with id %d", present.getId()));
        }
        presentService.delete(present);
    }
}
