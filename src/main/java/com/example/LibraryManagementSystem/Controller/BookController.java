package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Elements.Book;
import com.example.LibraryManagementSystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;
    @GetMapping("/")
    public String welcome(){
        return "Welcome in Library Management System with SPRING! What do you want to do?";
    }

    @GetMapping("/books")
    public List<Book> getAll(){
        return bookRepository.getAll();
    }
}
