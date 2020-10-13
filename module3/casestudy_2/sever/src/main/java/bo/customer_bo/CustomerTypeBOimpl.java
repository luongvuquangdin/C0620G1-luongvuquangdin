package bo.customer_bo;

import dao.customer_dao.CustomerTypeDAO;
import dao.customer_dao.CustomerTypeDAOimpl;
import model.customer.CustomerType;

import java.util.List;

public class CustomerTypeBOimpl implements CustomerTypeBO {
    private CustomerTypeDAO customerTypeDAO=new CustomerTypeDAOimpl();
    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerTypeDAO.findAllCustomerType();
    }
}
