package com.wecp.progressive.controller;


import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.service.impl.CustomerServiceImplArraylist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerServiceImplArraylist customerServiceImplArraylist;
    @GetMapping("")
    public List<Customers> getAllCustomers() throws SQLException {
        return customerServiceImplArraylist.getAllCustomers();
    }
    @GetMapping("/{customerID}")
    public Customers getCustomerById(@PathVariable int customerId) throws SQLException{
        return customerServiceImplArraylist.getCustomerById(customerId);
    }
    //@PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public int addCustomer(Customers customers) throws SQLException{
        return 0;
        //return customerServiceImplArraylist.addCustomer(customers);
    }
    @PutMapping("/{customerID}")
    public void updateCustomer(@PathVariable int customerId, @RequestBody Customers customers) throws SQLException{
        //return null;
        customerServiceImplArraylist.updateCustomer(customers);
    }
    @DeleteMapping("/{customerID}")
    public void deleteCustomer(@PathVariable int customerId) throws SQLException{
        //return null;
        customerServiceImplArraylist.deleteCustomer(customerId);
    }
    @GetMapping("/fromArrayList")
    public List<Customers> getAllCustomersFromArrayList() throws SQLException{
        return customerServiceImplArraylist.getAllCustomers();
    }
    @GetMapping("/fromArrayList/all")
    public List<Customers> getAllCustomersSortedByNameFromArrayList() throws SQLException
    {
        return customerServiceImplArraylist.getAllCustomersSortedByName();
    }
}
