package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.repository.CustomerRepository;
import com.wecp.progressive.service.CustomerService;
@Service
public class CustomerServiceImplJpa implements CustomerService{
    
    private CustomerRepository customerRepository;
    
    public CustomerServiceImplJpa(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public int addCustomer(Customers customers) throws SQLException {
        // TODO Auto-generated method stub
        // customers.setCustomerId(customerRepository.save(customers).getCustomerId());
        

        // return customers.getCustomerId();
        Customers savedCustomer = customerRepository.save(customers);
        if (savedCustomer != null) {
            customers.setCustomerId(savedCustomer.getCustomerId());
            return customers.getCustomerId(); }
            return -1;
        

    }

    @Override
    public void deleteCustomer(int customerId) throws SQLException {
        // TODO Auto-generated method stub
        //CustomerService.super.deleteCustomer(customerId);
        customerRepository.deleteByCustomerId(customerId);
    }

    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        // TODO Auto-generated method stub
        return customerRepository.findAll();
    }

    @Override
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        // TODO Auto-generated method stub
        List<Customers> ls = customerRepository.findAll();
        Collections.sort(ls);
        return ls;
    }

    @Override
    public Customers getCustomerById(int customerId) throws SQLException {
        // TODO Auto-generated method stub
        if(customerRepository.existsById(customerId))
        return customerRepository.findByCustomerId(customerId);
        else
        return null;
    }

    @Override
    public void updateCustomer(Customers customers) throws SQLException {
        // TODO Auto-generated method stub
        //CustomerService.super.updateCustomer(customers);
        if(customerRepository.findById(customers.getCustomerId()).isPresent())
        {
            Customers c = customerRepository.findById(customers.getCustomerId()).get();
            c.setName(customers.getName());
            c.setEmail(customers.getEmail());
            c.setPassword(customers.getPassword());
            c.setUsername(customers.getUsername());
            c.setRole(customers.getRole());
            customerRepository.save(c);
        }
    }
    

    
}