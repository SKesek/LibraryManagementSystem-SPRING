package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Elements.User;
import com.example.LibraryManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public List<User> getAll(){
        return  userRepository.getAll();
    }

    @GetMapping ("/{id}")
    public User getById(@PathVariable("id") int id){
        return userRepository.getById(id);
    }

    @PostMapping("")
    public String addUser(@RequestBody User user){
        return userRepository.addUser(user);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable("id") int id, @RequestBody User updatedUser){
        User user = userRepository.getById(id);
        if(user != null){
            user.setName(updatedUser.getName());
            user.setCardNumber(updatedUser.getCardNumber());
            return userRepository.updateUser(id);
        } else{
            return "Something wrong";
        }
    }

    @PatchMapping("/{id}")
    public String partiallyUpdate(@PathVariable("id") int id, @RequestBody User updatedUser){
        User user = userRepository.getById(id);
        if(user != null){
            if(updatedUser.getName() != null){
                user.setName(updatedUser.getName());
            }
            if(updatedUser.getCardNumber() != null){
                user.setCardNumber(updatedUser.getCardNumber());
            }
            return userRepository.updateUser(id);
        } else{
            return "Something wrong";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id){
        return userRepository.deleteUser(id);
    }
}
