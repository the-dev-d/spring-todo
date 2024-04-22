package com.app.todo.service;


import com.app.todo.dto.ProjectDto;
import com.app.todo.model.Project;
import com.app.todo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<ProjectDto> getAllProjects() {
        List<Project> projects = projectRepository.findAll();

        return projects
                .stream()
                .map(ProjectDto::new)
                .toList();
    }

    public ProjectDto getByProjectId(Long id) {

        Optional<Project> project = projectRepository.findById(id);
        return project
                .map(ProjectDto::new)
                .orElse(null);
    }

    public ProjectDto addProject(ProjectDto projectDto) {
        Project project = new Project(projectDto);
        project.setCreatedAt(new Date());
        project = projectRepository.save(project);
        return new ProjectDto(project);
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}
