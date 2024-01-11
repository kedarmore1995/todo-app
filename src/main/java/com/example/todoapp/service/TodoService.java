package com.example.todoapp.service;

import com.example.todoapp.dto.TodoDto;
import com.example.todoapp.model.ToDo;
import com.example.todoapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService implements iTodoService{

    @Autowired
    UserRepo userRepo;

    @Override
    public ToDo createTodo(TodoDto todoDto) {
        ToDo toDo = new ToDo(todoDto);
        userRepo.save(toDo);
        return toDo;
    }

    @Override
    public void changeStatus(int id, boolean status) {
        if(userRepo.existsById(id) && !status){
            ToDo toDo =  userRepo.findById(id).get();
            toDo.setCompleted(status);
            userRepo.save(toDo);
        }else {
            throw new RuntimeException("Id not found or status is same as before");
        }
    }

    @Override
    public void editDescription(int id, String description) {
        if (userRepo.existsById(id)){
            ToDo toDo = userRepo.findById(id).get();
            toDo.setDescription(description);
            userRepo.save(toDo);
            userRepo.save(toDo);
        }
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<ToDo> getTodoList() {
        List<ToDo> toDoList = userRepo.findAll();
        return toDoList;
    }

    @Override
    public ToDo GetById(int id) {
        return userRepo.findById(id).get();
    }
}
