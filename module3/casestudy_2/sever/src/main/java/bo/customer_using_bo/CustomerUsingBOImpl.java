package bo.customer_using_bo;

import dao.customer_using_dao.CustomerUsingDAO;
import dao.customer_using_dao.CustomerUsingDAOImpl;
import model.customer_using.CustomerUsing;

import java.util.List;

public class CustomerUsingBOImpl implements CustomerUsingBO {
    CustomerUsingDAO customerUsingDAO=new CustomerUsingDAOImpl();
    @Override
    public List<CustomerUsing> findAllCustomerUsing() {
        return this.customerUsingDAO.findAllCustomerUsing();
    }
}
