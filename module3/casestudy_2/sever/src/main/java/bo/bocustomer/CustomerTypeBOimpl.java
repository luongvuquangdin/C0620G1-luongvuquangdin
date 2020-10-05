package bo.bocustomer;

import dao.daocustomer.CustomerTypeDAO;
import dao.daocustomer.CustomerTypeDAOimpl;
import model.modelcustomer.CustomerType;

import java.util.List;

public class CustomerTypeBOimpl implements CustomerTypeBO {
    private CustomerTypeDAO customerTypeDAO=new CustomerTypeDAOimpl();
    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerTypeDAO.findAllCustomerType();
    }
}
