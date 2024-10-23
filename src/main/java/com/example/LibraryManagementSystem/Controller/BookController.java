package com.example.LibraryManagementSystem.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping("/")
    public String welcome(){
        return "Welcome in Library Management System with SPRING! What do you want to do?";
    }
}
