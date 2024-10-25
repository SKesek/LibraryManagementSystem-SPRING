package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Elements.User;
import com.example.LibraryManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public List<User> getAll(){
        return  userRepository.getAll();
    }

    @GetMapping ("/{id}")
    public User getById(@PathVariable("id") int id){
        return userRepository.getById(id);
    }

    @PostMapping
    public String add(@RequestBody User user){
        return userRepository.add(user);
    }
}
