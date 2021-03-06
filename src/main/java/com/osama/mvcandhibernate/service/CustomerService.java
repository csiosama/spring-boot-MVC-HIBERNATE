package com.osama.mvcandhibernate.service;

import com.osama.mvcandhibernate.dao.CustomerDao;
import com.osama.mvcandhibernate.model.Customer;
import com.osama.mvcandhibernate.service.interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    private CustomerDao customerDao;


    /*
     * Injecting CustomerDao
     * Constructor Injection */
    @Autowired
    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    /*
     * Get all customers
     * The @Transactional Annotation removes the use of:
     * "session.getTransaction().commit()" and "session.startTransaction" */
    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }


    /*
    * Get customer by Id from DAO*/
    @Override
    @Transactional
    public Customer getCustomer(int id) {
        return customerDao.getCustomer(id);
    }


    /*
    * Saving Customer in the database */
    @Transactional
    @Override
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Transactional
    @Override
    public void deleteCustomer(int id) {
        customerDao.deleteCustomer(this.getCustomer(id));
    }

}
