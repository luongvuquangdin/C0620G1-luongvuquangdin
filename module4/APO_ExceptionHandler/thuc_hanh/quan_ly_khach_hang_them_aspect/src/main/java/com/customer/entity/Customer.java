package com.customer.entity;

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

@Entity(name = "customer")
public class Customer implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotBlank(message = "Name cannot be left blank ")
    @Size(min = 2,max = 30,message = "Name have minimum length of 2 and maximum of 30 characters")
    String name;

    @NotNull(message = "Age cannot be left blank ")
    @Min(value = 18,message = "Age have minimum value of 18")
    Integer age;

    @NotBlank(message = "Phone cannot be left blank")
//    @Pattern(regexp = "^0\\d{9,10}$", message = "Phone is Start with 0,length from 10 to 11 character and number only")
    String phone;

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer=(Customer) target;
        if (!customer.phone.matches("^0\\d{9,10}$")){
            errors.rejectValue("phone","phone.number");
        }
    }
}
