package com.app.todo.controller;

import com.app.todo.dto.TodoDto;
import com.app.todo.service.ProjectService;
import com.app.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/todo")
public class TodoController {

    public final TodoService todoService;

    public final ProjectService projectService;

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable(name = "id") Long todoId) {
        TodoDto todo = todoService.getTodoById(todoId);
        if(todo == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PostMapping("/")
    public TodoDto addTodo(@RequestBody TodoDto todoDto) {
        return todoService.addTodo(todoDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable(name = "id") Long id) {
        todoService.deleteTodo(id);
    }

    @PutMapping("/")
    public TodoDto updateTodo(@RequestBody TodoDto todoDto) {
        return todoService.updateTodo(todoDto);
    }

}
