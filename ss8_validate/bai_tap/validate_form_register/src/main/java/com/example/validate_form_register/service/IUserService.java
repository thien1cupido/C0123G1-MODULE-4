package com.example.validate_form_register.service;

import com.example.validate_form_register.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAllUser();

    Boolean createUser(User user);
}
