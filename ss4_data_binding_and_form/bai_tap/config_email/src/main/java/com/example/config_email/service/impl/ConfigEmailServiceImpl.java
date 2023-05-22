package com.example.config_email.service.impl;

import com.example.config_email.model.ConfigEmail;
import com.example.config_email.repository.IConfigEmailRepository;
import com.example.config_email.service.IConfigEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigEmailServiceImpl implements IConfigEmailService {
    @Autowired
    private IConfigEmailRepository configEmailRepository;
    @Override
    public ConfigEmail getConfigEmail() {
        return configEmailRepository.getAllConfigEmail().get(0);
    }

    @Override
    public void updateConfigEmail(ConfigEmail configEmail) {
        configEmailRepository.updateConfigEmail(configEmail);
    }
}
