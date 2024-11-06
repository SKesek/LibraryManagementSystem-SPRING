package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Elements.Book;
import com.example.LibraryManagementSystem.Elements.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoanRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String loanBook(Book book, User user){
        jdbcTemplate.update("UPDATE books SET user_id=?, isAvailable = 0  WHERE id=?", user.getId(), book.getId());

        return "Succeed";
    }
    public String returnBook(Book book){
        jdbcTemplate.update("UPDATE books SET user_id=0, isAvailable = 1 WHERE id=?", book.getId());
        return "Succeed";
    }

    public List<Book> userLoanedBooks (User user){
        return jdbcTemplate.query("SELECT books.id, books.title, users.name, users.cardNumber  FROM books, users WHERE books.user_id=? AND users.id=?",
                BeanPropertyRowMapper.newInstance(Book.class), user.getId(), user.getId());
    }
}
