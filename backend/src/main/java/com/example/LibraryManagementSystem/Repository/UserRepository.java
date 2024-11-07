package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Elements.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getAll(){
        return jdbcTemplate.query("SELECT id, name, cardNumber FROM users",
                BeanPropertyRowMapper.newInstance(User.class));
    }
    public User getById(int id){
        return jdbcTemplate.queryForObject("SELECT id, name, cardNumber FROM users WHERE id=?",
                BeanPropertyRowMapper.newInstance(User.class), id);
    }

    public String addUser(User user){
        jdbcTemplate.update("INSERT INTO users (name, cardNumber) VALUES (?, ?)", user.getName(), user.getCardNumber());
        return "Succeed";
    }

    public String updateUser(int id){
        jdbcTemplate.update("UPDATE name, cardNumber FROM users WHERE id=?", id);
        return "Succeed";
    }

    public String deleteUser(int id){
        jdbcTemplate.update("DELETE FROM users WHERE id=?");
        return "Deleted";
    }
}
