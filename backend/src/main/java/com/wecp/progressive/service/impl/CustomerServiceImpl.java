package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.wecp.progressive.dao.CustomerDAO;
import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

    private CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    List<Customers> ls =new ArrayList<>(); 
    @Override
    public int addCustomer(Customers customers) throws SQLException {
        // TODO Auto-generated method stub
        return -1;
    }

    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        // TODO Auto-generated method stub
        return ls;
    }

    @Override
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        // TODO Auto-generated method stub
        return ls;
    }

    @Override
    public void updateCustomer(Customers customers) throws SQLException {
        // TODO Auto-generated method stub
        //CustomerService.super.updateCustomer(customers);
    }

    @Override
    public void deleteCustomer(int customerId) throws SQLException {
        // TODO Auto-generated method stub
        //CustomerService.super.deleteCustomer(customerId);
        
    }

    @Override
    public Customers getCustomerById(int customerId) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}


