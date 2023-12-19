package com.upb.adminservice.controller;

import com.upb.adminservice.model.User;
import com.upb.adminservice.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @GetMapping("/all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public User deleteById(@PathVariable String id) {
        return userService.deleteById(id);
    }

    @DeleteMapping("/all")
    public User deleteAll() {
        return userService.deleteAll();
    }

    @PutMapping("/{id}")
    public User updateById(@PathVariable String id, @RequestBody User user) {
        return userService.updateById(id, user);
    }
    
}
