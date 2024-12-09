package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Elements.Book;
import com.example.LibraryManagementSystem.Elements.Loan;
import com.example.LibraryManagementSystem.Elements.User;
import com.example.LibraryManagementSystem.Elements.UserLoanedBook;
import com.example.LibraryManagementSystem.Repository.BookRepository;
import com.example.LibraryManagementSystem.Repository.LoanRepository;
import com.example.LibraryManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class LoanController {

    BookRepository bookRepository;
    UserRepository userRepository;
    LoanRepository loanRepository;

    public LoanController(BookRepository bookRepository, UserRepository userRepository, LoanRepository loanRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.loanRepository = loanRepository;
    }

    @Autowired


    @PatchMapping("/loan/{bookId}/{userId}")
    public String loanBook(@PathVariable("bookId") int bookId, @PathVariable("userId") int userId){
        Book book = bookRepository.getById(bookId);
        User user = userRepository.getById(userId);
        System.out.println(book.getIsAvailable());

        if(book != null && user != null){
            if(book.getIsAvailable() == 1){
                book.setIsAvailable(0);
                book.setUser_id(user.getId());
                return loanRepository.loanBook(book, user);
            } else{
                return "This book is loaded";
            }

        } else {
            return "Something wrong";
        }
    }

    @PatchMapping("return/{bookId}")
    public String returnBook(@PathVariable("bookId") int bookId){
        Book book  = bookRepository.getById(bookId);
        loanRepository.returnBook(book);
        return "Succeed";
    }

    @GetMapping("userLoanedBooks/{userId}")
    public List<UserLoanedBook> userLoanedBooks(@PathVariable("userId") int userId){
        User user = userRepository.getById(userId);
        return loanRepository.userLoanedBooks(user);
    }
}
