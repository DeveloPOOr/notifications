package org.tinkoff.notifications.controller;

import org.springframework.web.bind.annotation.*;
import org.tinkoff.notifications.dto.ProjectDto;
import org.tinkoff.notifications.model.Project;
import org.tinkoff.notifications.service.ProjectService;

import static org.tinkoff.notifications.constraint.ApplicationError.NO_PROJECT;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/save")
    public void saveProject(@RequestBody ProjectDto projectDto) {
        projectService.save(projectDto);
    }

    @GetMapping("/get")
    public Project findById(@RequestParam("project_id")long project_id) {
        Project project = projectService.findById(project_id);
        if(project == null) {
            throw NO_PROJECT.exception(String.format("with id %d", project_id));
        }
        return project;
    }

    @PatchMapping("/update")
    public void updateProject(@RequestBody Project project) {
        Project projectCheck = projectService.findById(project.getId());
        if(projectCheck == null) {
            throw NO_PROJECT.exception(String.format("with id %d", project.getId()));
        }
        projectService.update(project);
    }

    @DeleteMapping("/delete")
    public void deleteProject(@RequestBody Project project) {
        Project projectCheck = projectService.findById(project.getId());
        if(projectCheck == null) {
            throw NO_PROJECT.exception(String.format("with id %d", project.getId()));
        }
        projectService.delete(project);
    }
}
