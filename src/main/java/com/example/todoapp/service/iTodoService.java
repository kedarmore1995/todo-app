package com.example.todoapp.service;

import com.example.todoapp.dto.TodoDto;
import com.example.todoapp.model.ToDo;
import java.util.List;

public interface iTodoService {

    //  createTodo
    //  changeStatus
    //  editDescriptionById
    //  deleteById

    public ToDo createTodo(TodoDto todoDto);

    public void changeStatus(int id, boolean status);

    public void editDescription(int id, String description);

    public void deleteById(int id);

    public List<ToDo> getTodoList();

    public ToDo GetById(int id);


}
