package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.service.CustomerService;

public class CustomerServiceImplJpa implements CustomerService{

    @Override
    public int addCustomer(Customers customers) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void deleteCustomer(int customerId) throws SQLException {
        // TODO Auto-generated method stub
        CustomerService.super.deleteCustomer(customerId);
    }

    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Customers getCustomerById(int customerId) throws SQLException {
        // TODO Auto-generated method stub
        return CustomerService.super.getCustomerById(customerId);
    }

    @Override
    public void updateCustomer(Customers customers) throws SQLException {
        // TODO Auto-generated method stub
        CustomerService.super.updateCustomer(customers);
    }
    

    
}