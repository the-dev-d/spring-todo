package com.app.todo.model;

import com.app.todo.dto.ProjectDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "PROJECT")
@NoArgsConstructor
public class Project {

    public Project(ProjectDto project) {
        this.id = project.getId();
        this.title = project.getTitle();
        this.createdAt = project.getCreatedAt();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_ID")
    Long id;

    @Column(name = "TITLE")
    String title;

    @Column(name = "CREATED_AT")
    Date createdAt;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "project")
    List<Todo> todos;

}
