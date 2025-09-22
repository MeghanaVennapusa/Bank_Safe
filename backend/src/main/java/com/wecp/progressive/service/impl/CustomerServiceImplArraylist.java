package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.service.CustomerService;

public class CustomerServiceImplArraylist implements CustomerService{

    private static List<Customers> customerList = new ArrayList<>();
    @Override
    public int addCustomer(Customers customers) throws SQLException {
        // TODO Auto-generated method stub
         customerList.add(customers);
         return customerList.size();
    }

    @Override
    public void emptyArrayList() {
        // TODO Auto-generated method stub
        //CustomerService.super.emptyArrayList();
        customerList.clear();
    }

    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        // TODO Auto-generated method stub
        return customerList;
    }

    @Override
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        // TODO Auto-generated method stub
        Collections.sort(customerList);
        return customerList;
    }
}


