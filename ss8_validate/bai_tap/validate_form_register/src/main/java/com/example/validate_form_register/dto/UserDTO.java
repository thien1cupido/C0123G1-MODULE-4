package com.example.validate_form_register.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDTO implements Validator {
    @Size(min = 5, max = 45, message = "Firstname minimum length 5, maximum 45 characters")
    @NotBlank(message = "cannot be left blank")
    @Column(name = "first_name",columnDefinition = "VARCHAR(45)")
    private String firstName;
    @Size(min = 5, max = 45, message = "Lastname minimum length 5, maximum 45 characters")
    @NotBlank(message = "cannot be left blank")
    @Column(name = "last_name",columnDefinition = "VARCHAR(45)")
    private String lastName;
    @NotBlank(message = "cannot be left blank")
    @Column(columnDefinition = "VARCHAR(50)")
    private String pass;
    @NotBlank(message = "cannot be left blank")
    @Column(name = "phone_number")
    private Integer phoneNumber;
    @Size(min = 10, max = 11, message = "Lastname minimum length 5, maximum 45 characters")
    @NotBlank(message = "cannot be left blank")
    private Integer age;
    @NotBlank(message = "cannot be left blank")
    @Column(columnDefinition = "VARCHAR(50)")
    private String email;

    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, String pass, Integer phoneNumber, Integer age, String email) {
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
        UserDTO user = (UserDTO) target;
    }
}
