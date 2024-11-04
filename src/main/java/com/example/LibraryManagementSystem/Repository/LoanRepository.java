package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Elements.Book;
import com.example.LibraryManagementSystem.Elements.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoanRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String loanBook(Book book, User user){
        jdbcTemplate.update("UPDATE books SET user_id=?, isAvailable = 0  WHERE id=?", user.getId(), book.getId());

        return "Succeed";
    }
    public String returnBook(int bookId, int userId){
        jdbcTemplate.update("");
        return "Succeed";
    }

    public Book test(int bookId){
        return  jdbcTemplate.queryForObject("SELECT id, title, author FROM books WHERE id=?",
                BeanPropertyRowMapper.newInstance(Book.class), bookId);
        //jdbcTemplate.query("SELECT id, name, cardNumber FROM users WHERE id=?", BeanPropertyRowMapper.newInstance(User.class), userId);


    }
}
