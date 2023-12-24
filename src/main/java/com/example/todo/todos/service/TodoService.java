package com.example.todo.todos.service;

import java.util.List;
import java.util.Optional;

import com.example.todo.todos.Todo;

public interface TodoService {
    Todo create(Todo todo);
    
    List<Todo> getByUsername(String username);

    Optional<Todo> get(Long id);

    Todo update(Todo todo);

    boolean deleteById(Long id);

}
