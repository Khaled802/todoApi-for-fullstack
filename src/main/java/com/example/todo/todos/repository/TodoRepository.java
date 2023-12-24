package com.example.todo.todos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.todos.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUsername(String username);
}
