package com.app.todo.controller;

import com.app.todo.dto.ProjectDto;
import com.app.todo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/")
    List<ProjectDto> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{projectId}")
    ResponseEntity<ProjectDto> getProjectById(@PathVariable(name = "projectId") Long projectId) {

        ProjectDto projectDto = projectService.getByProjectId(projectId);
        if (projectId == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(projectDto, HttpStatus.OK);
    }

    @PostMapping("/")
    ProjectDto addProject(@RequestBody ProjectDto projectDto) {
        return projectService.addProject(projectDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable(name = "id") Long id) {
        projectService.deleteProject(id);
    }
}
