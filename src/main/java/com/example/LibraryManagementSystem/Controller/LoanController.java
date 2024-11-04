package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Elements.Book;
import com.example.LibraryManagementSystem.Elements.Loan;
import com.example.LibraryManagementSystem.Elements.User;
import com.example.LibraryManagementSystem.Repository.BookRepository;
import com.example.LibraryManagementSystem.Repository.LoanRepository;
import com.example.LibraryManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")

public class LoanController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LoanRepository loanRepository;


    @GetMapping ("/{bookId}")
    public Book test(@PathVariable("bookId") int bookId){
        return loanRepository.test(bookId);
    }

    @PatchMapping("/{bookId}/{userId}")
    public String loanBook(@PathVariable("bookId") int bookId, @PathVariable("userId") int userId){
        Book book = bookRepository.getById(bookId);
        User user = userRepository.getById(userId);
        if(book != null && user != null){
            book.setIsAvailable(0);
            book.setUser_id(user.getId());
            return loanRepository.loanBook(book, user);
        } else {
            return "Something wrong";
        }
    }
}
