package com.example.validate_form_register.service.impl;

import com.example.validate_form_register.model.User;
import com.example.validate_form_register.repository.IUserRepository;
import com.example.validate_form_register.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> findAllUser() {
        return iUserRepository.findAll();
    }

    @Override
    public Boolean createUser(User user) {
        try {
            iUserRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
