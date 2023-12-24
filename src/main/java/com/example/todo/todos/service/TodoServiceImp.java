package com.example.todo.todos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.todo.todos.Todo;
import com.example.todo.todos.repository.TodoRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class TodoServiceImp implements TodoService {
    private final TodoRepository todoRepository;


    @Override
    public List<Todo> getByUsername(String username) {
        return todoRepository.findByUsername(username);
    }

    @Override
    public Optional<Todo> get(Long id) {
        return todoRepository.findById(id);
    }

    @Override
    public Todo update(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public boolean deleteById(Long id) {
        if (!todoRepository.existsById(id)) return false;
        todoRepository.deleteById(id);
        return true;
    }

    @Override
    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }
}
