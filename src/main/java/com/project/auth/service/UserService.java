package com.project.auth.service;

import com.project.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
