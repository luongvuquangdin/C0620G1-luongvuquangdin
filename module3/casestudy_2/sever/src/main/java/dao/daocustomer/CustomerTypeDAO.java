package dao.daocustomer;

import model.modelcustomer.CustomerType;

import java.util.List;

public interface CustomerTypeDAO {
    List<CustomerType> findAllCustomerType();
}
