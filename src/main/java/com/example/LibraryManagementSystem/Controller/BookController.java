package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Elements.Book;
import com.example.LibraryManagementSystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("")
    public List<Book> getAll(){
        return bookRepository.getAll();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable("id") int id){
        return bookRepository.getById(id);
    }

    @PostMapping("")
    public String add(@RequestBody Book book){
        return bookRepository.save(book);

    }
}
