package com.casestudy.entity.customer;

import com.casestudy.entity.contract.Contract;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "customer_id")
    @Pattern(regexp = "^KH-\\d{4}$", message = "Customer id format is KH-XXXX(X is number from 0 to 9)")
    String customerId;
    @NotBlank(message = "Name can't left blank")
    @Column(name = "customer_name")
    String customerName;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "Birthday can not left blank")
    @Past(message = "Are you from the future?")
    @Column(name = "customer_birthday")
    LocalDate customerBirthday;
    @Column(name = "customer_gender")
    String customerGender;
    @Column(name = "customer_id_card")
    @Pattern(regexp = "^\\d{9}$", message = "IdCard format is XXXXXXXXX (X is number from 0 to 9)")
    String customerIdCard;
    @Column(name = "customer_phone")
    @Pattern(regexp = "^((\\(84\\)\\+)|0)((90)|(91))\\d{7}$", message = "Phone number format is (84)+90XXXXXXX" +
            "or (84)+91XXXXXXX or 090XXXXXXX or 091XXXXXXX")
    String customerPhone;
    @Column(name = "customer_email")
    @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9]+$", message = "Email format is abc@abc.abc")
    String customerEmail;
    @Column(name = "customer_address")
    String customerAddress;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customer_type_id")
    CustomerType customerType;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<Contract> contractsOfCustomer;

    public Customer() {
    }

    public List<Contract> getContractsOfCustomer() {
        return contractsOfCustomer;
    }

    public void setContractsOfCustomer(List<Contract> contractsOfCustomer) {
        this.contractsOfCustomer = contractsOfCustomer;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(LocalDate customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
