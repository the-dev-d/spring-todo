package com.app.todo.dto;

import com.app.todo.model.Todo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class TodoDto {

    public TodoDto(Todo todo) {
        this.id = todo.getId();
        this.description = todo.getDescription();
        this.status = todo.getStatus();
        this.createdAt = todo.getCreatedAt();
        this.updatedAt = todo.getUpdatedAt();
        this.projectId = todo.getProject().getId();
    }

    private Long id;

    private String description;

    private Boolean status;

    private Date createdAt;

    private Date updatedAt;

    private Long projectId;

    private ProjectDto projectDto;

}
