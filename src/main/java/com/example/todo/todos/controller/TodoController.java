package com.example.todo.todos.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.todo.todos.Todo;
import com.example.todo.todos.dto.TodoCreateDto;
import com.example.todo.todos.dto.TodoUpdateDto;
import com.example.todo.todos.service.TodoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TodoController {
    private final TodoService todoService;
    private final ModelMapper modelMapper;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoService.getByUsername(username);
    }

    @PostMapping("/users/{username}/todos")
    @ResponseStatus(HttpStatus.CREATED)
    public Todo create(@PathVariable String username, @Valid @RequestBody TodoCreateDto todoDto) {
        Todo todo = modelMapper.map(todoDto, Todo.class);
        todo.setUsername(username);
        todo.setDone(false);
        return todoService.create(todo);
    }

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return todoService.get(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/todos/{id}")
    public Todo updateById(@PathVariable Long id, @Valid @RequestBody TodoUpdateDto todoUpdateDto) {
        log.info("dto: {}", todoUpdateDto);
        Todo todo = modelMapper.map(todoUpdateDto, Todo.class);
        Todo original = todoService.get(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        original.setTitle(todo.getTitle());
        original.setDescription(todo.getDescription());
        original.setDone(todo.getDone());
        original.setExpiredDate(todo.getExpiredDate());

        return todoService.update(original);
    }

    @DeleteMapping("/todos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        if (!todoService.deleteById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

}
