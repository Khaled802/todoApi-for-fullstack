package com.example.todo.todos.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class TodoCreateDto {
    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private String description;
    
    @Future
    private LocalDate expiredDate;
}
