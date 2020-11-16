package com.casestudy.entity.customer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_type")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_type_id")
    Integer customerTypeId;
    @Column(name = "customer_type_name")
    String customerTypeName;
    @OneToMany(mappedBy = "customerType",cascade = CascadeType.ALL)
    List<Customer> customers;

    public CustomerType() {
    }

    public Integer getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Integer customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}
