package com.registration.registration.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotBlank(message = "First name cannot left blank")
    @Size(min = 5,max = 45,message = "First name minimum length 5 and maximum length 45 character")
    String firstName;

    @NotBlank(message = "Last name cannot left blank")
    @Size(min = 5,max = 45,message = "First name minimum length 5 and maximum length 45 character")
    String lastName;

    @NotBlank(message = "Number phone cannot left blank")
    String numberPhone;

    @NotNull(message = "Age cannot left blank")
    @Min(value = 18,message = "Age >= 18")
    Integer age;

    @NotBlank(message = "Email cannot left blank")
    String email;

    public User() {
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

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
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
        User user= (User) target;
        if (!user.email.matches("^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9]+$")){
            errors.rejectValue("email","email.format");
        }
        if (!user.numberPhone.matches("^0\\d{9,10}$")){
            errors.rejectValue("numberPhone","numberPhone.format");
        }


    }
}
