package com.app.todo.dto;

import com.app.todo.model.Project;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

    public ProjectDto(Project project) {
        this.id = project.getId();
        this.title = project.getTitle();
        this.createdAt = project.getCreatedAt();
    }

    Long id;

    String title;

    Date createdAt;
}
