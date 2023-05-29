package com.example.validate_form_register.dto;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDTO implements Validator {
    private Integer id;
    @NotBlank(message = "Can't be left blank")
    @Size(min = 5, max = 45, message = "Minimum length 5, maximum 45 characters")
    private String firstName;
    @NotBlank(message = "Can't be left blank")
    @Size(min = 5, max = 45, message = "Minimum length 5, maximum 45 characters")
    private String lastName;
    @NotBlank(message = "Can't be left blank")
    private String pass;
    @NotBlank(message = "Can't be left blank")
    private String confirmPass;
    @NotBlank(message = "Can't be left blank")
    private String phoneNumber;
    @Range(min = 18,max = 150,message = "Age must be over 18")
    @NotNull(message = "Can't be left blank")
    private Integer age;
    @NotBlank(message = "Can't be left blank")
    private String email;

    public UserDTO() {
    }

    public UserDTO(Integer id, String firstName, String lastName, String pass, String confirmPass, String phoneNumber, Integer age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pass = pass;
        this.confirmPass = confirmPass;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;
        String regexPhoneNumber = "^((\\+84)|0)[0-9]{9,10}$";
        String regexEmail = "^[a-z]\\w{5,}\\@[a-z]{3,5}\\.[a-z]{2,5}$";
        if (!userDTO.phoneNumber.matches(regexPhoneNumber)) {
            errors.rejectValue("phoneNumber", "", "Phone numbers start at 0 or +84 and have 10 – 11 numbers");
        }
        if (!userDTO.email.matches(regexEmail)) {
            errors.rejectValue("email", "", "Email must have '@' and end in '.com'");
        }
    }
}
