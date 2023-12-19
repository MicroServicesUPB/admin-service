package com.upb.adminservice.service;

import java.util.List;

import com.upb.adminservice.model.User;

public interface UserService {
    User save(User user);

    User findById(String id);

    List<User> findAll();

    User deleteById(String id);

    User deleteAll();

    User updateById(String id, User user);
    
}
