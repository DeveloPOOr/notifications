package org.tinkoff.notifications.controller;

import org.springframework.web.bind.annotation.*;
import org.tinkoff.notifications.dto.ProjectDto;
import org.tinkoff.notifications.model.Project;
import org.tinkoff.notifications.service.ProjectService;

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
        return project;
    }

    @PatchMapping("/update")
    public void updateProject(@RequestBody Project project) {
        projectService.update(project);
    }

    @DeleteMapping("/delete")
    public void deleteProject(@RequestBody Project project) {
        projectService.delete(project);
    }
}
