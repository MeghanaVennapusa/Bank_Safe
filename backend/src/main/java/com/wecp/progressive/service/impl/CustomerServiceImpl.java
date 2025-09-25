package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wecp.progressive.dao.CustomerDAO;
import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerDAO customerDAO;
    private static List<Customers> customersList = new ArrayList<>();

    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    
    @Override
    public int addCustomer(Customers customers) throws SQLException {
        // TODO Auto-generated method stub
        return customerDAO.addCustomer(customers);
    }

    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        // TODO Auto-generated method stub
        customersList=customerDAO.getAllCustomers();
        return customersList;
    }

    @Override
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        // TODO Auto-generated method stub
        customersList=customerDAO.getAllCustomers();
        Collections.sort(customersList);
        return customersList;
    }

    @Override
    public void updateCustomer(Customers customers) throws SQLException {
        // TODO Auto-generated method stub
        //CustomerService.super.updateCustomer(customers);
        customerDAO.updateCustomer(customers);
    }

    @Override
    public void deleteCustomer(int customerId) throws SQLException {
        // TODO Auto-generated method stub
        //CustomerService.super.deleteCustomer(customerId);
        customerDAO.deleteCustomer(customerId);
    }

    @Override
    public Customers getCustomerById(int customerId) throws SQLException {
        // TODO Auto-generated method stub
        return customerDAO.getCustomerById(customerId);
    }

}


