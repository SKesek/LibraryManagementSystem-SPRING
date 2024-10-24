package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Elements.User;
import com.example.LibraryManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAll(){
        return  userRepository.getAll();
    }

    @GetMapping ("/users/{id}")
    public User getById(@PathVariable("id") int id){
        return userRepository.getById(id);
    }
}
