package com.example.config_email.repository.impl;

import com.example.config_email.model.ConfigEmail;
import com.example.config_email.repository.IConfigEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConfigEmailRepositoryImpl implements IConfigEmailRepository {
    private static List<ConfigEmail> configEmailList=new ArrayList<>();
    static {
        configEmailList.add(new ConfigEmail("English",25,false,"Thor"));
    }

    @Override
    public List<ConfigEmail> getAllConfigEmail() {
        return configEmailList;
    }

    @Override
    public void updateConfigEmail(ConfigEmail configEmail) {
        configEmailList.remove(0);
        configEmailList.add(configEmail);
    }
}
