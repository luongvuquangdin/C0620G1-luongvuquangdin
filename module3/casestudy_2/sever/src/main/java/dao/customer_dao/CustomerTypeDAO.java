package dao.customer_dao;

import model.customer.CustomerType;

import java.util.List;

public interface CustomerTypeDAO {
    List<CustomerType> findAllCustomerType();
}
