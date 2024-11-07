package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Elements.Book;
import com.example.LibraryManagementSystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
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
    public String addBook(@RequestBody Book book){
        return bookRepository.addBook(book);

    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable("id") int id, @RequestBody Book updatedBook){
        Book book = bookRepository.getById(id);
        if(book != null){
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            return bookRepository.updateBook(book);
        } else{
            return "Something wrong";
        }
    }

    @PatchMapping("{id}")
        public String partiallyUpdate(@PathVariable("id") int id, @RequestBody Book updatedBook) {
        Book book = bookRepository.getById(id);
        if (book != null) {
            if (updatedBook.getTitle() != null) {
                book.setTitle(updatedBook.getTitle());
            }
            if (updatedBook.getAuthor() != null) {
                book.setAuthor(updatedBook.getAuthor());
            }

            return bookRepository.updateBook(book);
        } else {
            return "Something wrong";
        }
    }

    @DeleteMapping("{id}")
    public String deleteBook(@PathVariable("id") int id){
        return bookRepository.deleteBook(id);
    }

}
