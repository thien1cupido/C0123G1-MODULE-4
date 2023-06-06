package com.example.blogging_app.repository;


import com.example.blogging_app.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String username);
}
