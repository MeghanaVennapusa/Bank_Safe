package com.wecp.progressive.controller;


import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.entity.Transactions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CustomerController {

    public List<Customers> getAllCustomers() {
        return null;
    }

    public Customers getCustomerById(int customerId) {
        return null;
    }

    public Integer addCustomer(Customers customers) {
        return null;
    }

    public void updateCustomer(int customerId, Customers customers) {
        //return null;
    }
    public void deleteCustomer(int customerId) {
        //return null;
    }

    public List<Transactions> getAllTransactionsByCustomerId(int customerId) {
        return null;
    }
}
