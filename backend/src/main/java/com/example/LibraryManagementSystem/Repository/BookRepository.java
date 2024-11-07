package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Elements.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Book> getAll(){
       return jdbcTemplate.query("SELECT id, title, author, isAvailable, user_id  FROM books",
               BeanPropertyRowMapper.newInstance(Book.class));
    }

    public Book getById(int id){
        return  jdbcTemplate.queryForObject("SELECT id, title, isAvailable, user_id author FROM books WHERE id=?",
                BeanPropertyRowMapper.newInstance(Book.class), id);
    }

    public String addBook(Book book) {
        jdbcTemplate.update("INSERT INTO books(title, author) VALUES(?, ?)",book.getTitle(), book.getAuthor());
        return "Succeed";
    }

    public String updateBook(Book book){
        jdbcTemplate.update("UPDATE books SET title=?, auhtor=? WHERE id=?", book.getTitle(), book.getAuthor(), book.getId());
        return "Update succeed";
    }

    public String deleteBook(int id){
        jdbcTemplate.update("DELETE FROM books WHERE id=?", id);
        return "Book deleted";
    }
}
