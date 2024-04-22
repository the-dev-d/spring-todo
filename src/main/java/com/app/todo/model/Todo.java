package com.app.todo.model;

import com.app.todo.dto.TodoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Table(name = "TODO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    public Todo(TodoDto todo) {
        this.id = todo.getId();
        this.description = todo.getDescription();
        this.status = todo.getStatus();
        this.createdAt = todo.getCreatedAt();
        this.updatedAt = todo.getUpdatedAt();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TODO_ID")
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "CREATED_AT")
    private Date createdAt;

    @Column(name = "UPDATED_AT")
    private Date updatedAt;

    @ManyToOne()
    @JoinColumn(name = "PROJECT_ID")
    Project project;
}
