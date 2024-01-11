package com.example.todoapp.model;

import com.example.todoapp.dto.TodoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

        public int id;
        public String description;
        public boolean completed = false;

    public ToDo(TodoDto todoDto) {
        this.completed = todoDto.completed;
        this.description = todoDto.description;
    }
}
