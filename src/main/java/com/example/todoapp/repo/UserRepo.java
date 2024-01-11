package com.example.todoapp.repo;

import com.example.todoapp.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<ToDo, Integer> {
}
