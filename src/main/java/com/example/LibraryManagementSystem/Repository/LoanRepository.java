package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Elements.Book;
import com.example.LibraryManagementSystem.Elements.User;
import com.example.LibraryManagementSystem.Elements.UserLoanedBook;
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
        jdbcTemplate.update("UPDATE books SET user_id=null, isAvailable = 1 WHERE id=?", book.getId());
        return "Succeed";
    }

    public List<UserLoanedBook> userLoanedBooks (User user){
        return jdbcTemplate.query("SELECT books.id AS bookId, books.title AS bookTitle, users.name AS userName, users.cardNumber AS userCardNumber " +
                        "FROM books " +
                        "JOIN users ON books.user_id = users.id " +
                        "WHERE books.user_id = ?",
                BeanPropertyRowMapper.newInstance(UserLoanedBook.class), user.getId());
    }
}
