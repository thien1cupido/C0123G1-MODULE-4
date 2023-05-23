package com.example.config_email.repository;

import com.example.config_email.model.ConfigEmail;

import java.util.List;

public interface IConfigEmailRepository {
    List<ConfigEmail> getAllConfigEmail();

    void updateConfigEmail(ConfigEmail configEmail);
}
