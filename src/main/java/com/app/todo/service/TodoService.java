package com.app.todo.service;

import com.app.todo.dto.TodoDto;
import com.app.todo.model.Project;
import com.app.todo.model.Todo;
import com.app.todo.repository.ProjectRepository;
import com.app.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {



    private final TodoRepository todoRepository;
    private final ProjectRepository projectRepository;


    public TodoDto getTodoById(Long id) {

        return todoRepository
                .findById(id)
                .map(TodoDto::new)
                .orElse(null);
    }

    public TodoDto addTodo(TodoDto todoDto) {

        Todo todo = new Todo(todoDto);
        Optional<Project> optionalProject = projectRepository.findById(todoDto.getProjectId());

        Project project = optionalProject.orElse(null);
        if(project == null)
            return null;

        todo.setProject(project);
        todo.setCreatedAt(new Date());
        todo = todoRepository.save(todo);
        return new TodoDto(todo);
    }

    public TodoDto updateTodo(TodoDto todoDto) {
        Optional<Todo> optionalTodo = todoRepository.findById(todoDto.getId());
        if(optionalTodo.isEmpty())
            return null;
        Todo todo = optionalTodo.get();
        todo.setDescription(todoDto.getDescription());
        todo.setCreatedAt(todoDto.getCreatedAt());
        todo.setStatus(todoDto.getStatus());
        todo.setUpdatedAt(new Date());
        todo = todoRepository.save(todo);
        return new TodoDto(todo);
    }

    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }

}
