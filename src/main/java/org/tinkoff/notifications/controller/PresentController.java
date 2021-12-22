package org.tinkoff.notifications.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;
import org.tinkoff.notifications.model.Employee;
import org.tinkoff.notifications.model.Present;
import org.tinkoff.notifications.service.EmployeeService;
import org.tinkoff.notifications.service.PresentService;

import javax.validation.Valid;

import static org.tinkoff.notifications.constraint.ApplicationError.ACCESS_DENIED;
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
            @RequestBody @Valid Present present,
            @RequestParam("employee_id") long employee_id,
            Authentication authentication) {
        ProjectController.check(employee_id, authentication, employeeService);
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
    public void updatePresent(@RequestBody @Valid Present present, Authentication authentication) {
        checkAuth(present, authentication);
        presentService.update(present);
    }

    @DeleteMapping("/delete")
    public void deletePresent(@RequestBody @Valid Present present, Authentication authentication) {
        checkAuth(present, authentication);
        presentService.delete(present);
    }

    private void checkAuth(@RequestBody @Valid Present present, Authentication authentication) {
        Present presentCheck = presentService.findById(present.getId());
        if (presentCheck == null) {
            throw NO_PRESENT.exception(String.format("with id %d", present.getId()));
        }
        Employee employee = employeeService.findById(presentCheck.getEmployee_id());
        if (!authentication.getName().equals(employee.getUsername())
                && !authentication
                        .getAuthorities()
                        .contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            throw ACCESS_DENIED.exception("");
        }
    }
}
