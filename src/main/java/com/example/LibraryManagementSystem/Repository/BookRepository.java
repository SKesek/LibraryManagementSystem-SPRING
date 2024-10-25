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
       return jdbcTemplate.query("SELECT id, title, author FROM books",
               BeanPropertyRowMapper.newInstance(Book.class));
    }

    public Book getById(int id){
        return  jdbcTemplate.queryForObject("SELECT id, title, author FROM books WHERE id=?",
                BeanPropertyRowMapper.newInstance(Book.class), id);
    }

    public String save(Book book) {
        jdbcTemplate.update("INSERT INTO books(title, author) VALUES(?, ?)",book.getTitle(), book.getAuthor());
        return "Succeed";
    }
}
