package com.example.config_email.service;

import com.example.config_email.model.ConfigEmail;

public interface IConfigEmailService {
    ConfigEmail getConfigEmail();

    void updateConfigEmail(ConfigEmail configEmail);
}
