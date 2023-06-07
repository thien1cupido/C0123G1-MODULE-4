package com.example.blogging_app.repository;

import com.example.blogging_app.model.AppUser;
import com.example.blogging_app.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {

    List<UserRole> findByAppUser(AppUser appUser);

}
