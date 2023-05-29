package com.example.validate_form_register.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;

@Entity
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name", columnDefinition = "VARCHAR(45)")
    private String firstName;
    @Column(name = "last_name", columnDefinition = "VARCHAR(45)")
    private String lastName;
    @Column(columnDefinition = "VARCHAR(50)")
    private String pass;

    @Column(name = "phone_number")
    private Integer phoneNumber;
    private Integer age;
    @Column(columnDefinition = "VARCHAR(50)")
    private String email;

    public User() {
    }

    public User(String firstName, String lastName, String pass, Integer phoneNumber, Integer age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pass = pass;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
    }
}
