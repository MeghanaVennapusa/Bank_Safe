package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.service.CustomerService;

public class CustomerServiceImplArraylist implements CustomerService{

    private static List<Customers> customersList = new ArrayList<>();
    @Override
    public int addCustomer(Customers customers) throws SQLException {
        // TODO Auto-generated method stub
         customersList.add(customers);
         return customersList.size();
    }

    @Override
    public void emptyArrayList() {
        // TODO Auto-generated method stub
        //CustomerService.super.emptyArrayList();
        customersList=new ArrayList<>();
    }

    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        // TODO Auto-generated method stub
        return customersList;
    }

    @Override
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        // TODO Auto-generated method stub
        Collections.sort(customersList);
        List<Customers> sortedCustomers = customersList;
        
        Collections.sort(customersList);
        return sortedCustomers;
    }
}


