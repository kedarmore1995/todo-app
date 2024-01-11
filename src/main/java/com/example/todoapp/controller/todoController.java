package com.example.todoapp.controller;

import com.example.todoapp.dto.TodoDto;
import com.example.todoapp.model.ToDo;
import com.example.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class todoController {

    @Autowired
    TodoService todoService;

    @PostMapping("/create")
    public ToDo createTodo(@RequestBody TodoDto todoDto){
        return todoService.createTodo(todoDto);
    }

    @PutMapping("/changeStatus")
    public void changeStatus(@RequestParam int id, @RequestParam boolean status){
        todoService.changeStatus(id, status);
    }

    @PutMapping("/editDesc")
    public void editDescription(@RequestParam int id, @RequestParam String description){
        todoService.editDescription(id, description);
    }
    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam int id){
        todoService.deleteById(id);
    }

    @GetMapping("/getAll")
    public List<ToDo> getTodoList(){
        return todoService.getTodoList();
    }

    @GetMapping("/getById")
    public ToDo GetById(@RequestParam int id){
        return todoService.GetById(id);
    }
}
