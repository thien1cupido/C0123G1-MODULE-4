package com.example.validate_form_register.model;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name", columnDefinition = "VARCHAR(50)")
    private String firstName;
    @Column(name = "last_name", columnDefinition = "VARCHAR(50)")
    private String lastName;
    @Column(columnDefinition = "VARCHAR(100)")
    private String pass;
    @Column(name = "phone_number", columnDefinition = "VARCHAR(11)")
    private String phoneNumber;
    private Integer age;
    @Column(columnDefinition = "VARCHAR(100)")
    private String email;

    public User() {
    }


    public User(Integer id, String firstName, String lastName, String pass, String phoneNumber, Integer age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pass = pass;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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

}
