package org.tinkoff.notifications.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;
import org.tinkoff.notifications.model.Employee;
import org.tinkoff.notifications.model.Project;
import org.tinkoff.notifications.service.EmployeeService;
import org.tinkoff.notifications.service.ProjectService;

import javax.validation.Valid;

import static org.tinkoff.notifications.constraint.ApplicationError.*;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;
    private final EmployeeService employeeService;

    public ProjectController(ProjectService projectService, EmployeeService employeeService) {
        this.projectService = projectService;
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public Project saveProject(@RequestBody @Valid Project project) {
        return projectService.save(project);
    }

    @GetMapping("/get")
    public Project findById(@RequestParam("project_id") long project_id) {
        Project project = projectService.findById(project_id);
        if (project == null) {
            throw NO_PROJECT.exception(String.format("with id %d", project_id));
        }
        return project;
    }

    @PatchMapping("/update")
    public void updateProject(@RequestBody @Valid Project project) {
        Project projectCheck = projectService.findById(project.getId());
        if (projectCheck == null) {
            throw NO_PROJECT.exception(String.format("with id %d", project.getId()));
        }
        projectService.update(project);
    }

    @DeleteMapping("/delete")
    public void deleteProject(@RequestBody @Valid Project project) {
        Project projectCheck = projectService.findById(project.getId());
        if (projectCheck == null) {
            throw NO_PROJECT.exception(String.format("with id %d", project.getId()));
        }
        projectService.delete(project);
    }

    static void check(
            @RequestParam("employee_id") long employee_id,
            Authentication authentication,
            EmployeeService employeeService) {
        Employee employee = employeeService.findById(employee_id);
        if (employee == null) {
            throw NO_EMPLOYEE.exception(String.format("with id %d", employee_id));
        }
        if (!authentication.getName().equals(employee.getUsername())
                && !authentication
                        .getAuthorities()
                        .contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            throw ACCESS_DENIED.exception("");
        }
    }

    @PostMapping("/addEmployee")
    public void addEmployee(
            @RequestParam("employee_id") long employee_id,
            @RequestParam("project_id") long project_id,
            Authentication authentication) {
        Project project = projectService.findById(project_id);
        if (project == null) {
            throw NO_PROJECT.exception(String.format("with id %d", project_id));
        }
        check(employee_id, authentication, employeeService);
        projectService.addEmployee(employee_id, project_id);
    }
}
