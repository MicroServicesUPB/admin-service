package com.upb.adminservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

import com.upb.adminservice.error.UserNotFoundException;
import com.upb.adminservice.model.User;

@Service
@Log4j2
public class UserServiceImpl implements UserService {


    List<User> userList = new ArrayList<>();

    @Override
    public User save(User user) {
        log.info("Saving user with name: " + user.getUsername());
        if (user.getId() == null) {
            user.setId(UUID.randomUUID().toString());
        }
        userList.add(user);
        return user;
    }

    @Override
    public User findById(String id) {
        log.info("Finding user with ID: " + id);
        return userList
                .stream()
                .filter(user -> user.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found with ID " + id));
    }

    @Override
    public List<User> findAll() {
        log.info("Finding all users");
        return userList;
    }

    @Override
    public User deleteById(String id) {
        log.info("Deleting user with ID: " + id);
        User deletedUser = userList.stream()
                .filter(user -> user.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found with ID " + id));
        userList.remove(deletedUser);
        return deletedUser;
    }

    @Override
    public User deleteAll() {
        userList.clear();
        return null;
    }

    @Override
    public User updateById(String id, User user) {
        User updatedUser = userList.stream()
                .filter(user1 -> user1.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found with ID " + id));
        updatedUser.setUsername(user.getUsername());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.getPassword());
        return updatedUser;
    }
    
}
