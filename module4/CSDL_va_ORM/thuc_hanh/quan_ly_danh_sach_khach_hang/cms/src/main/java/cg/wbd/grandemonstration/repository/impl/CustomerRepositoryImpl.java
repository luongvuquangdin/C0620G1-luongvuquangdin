package cg.wbd.grandemonstration.repository.impl;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.repository.CustomerRepository;
import cg.wbd.grandemonstration.service.impl.BaseDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Autowired
    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> customerTypedQuery=BaseDatabase.entityManager.createQuery("select c from customer c",Customer.class);
        return customerTypedQuery.getResultList();
    }

    @Override
    public Customer findOne(Long id) {
        return BaseDatabase.entityManager.find(Customer.class,id);
    }

    @Override
    public Customer save(Customer customer) {
        Customer customer1;
        EntityTransaction entityTransaction=BaseDatabase.entityManager.getTransaction();
        entityTransaction.begin();
        customer1=BaseDatabase.entityManager.merge(customer);
        entityTransaction.commit();
        return customer1;
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public void delete(List<Customer> customers) {

    }

    @Override
    public void deleteAll() {

    }
}
