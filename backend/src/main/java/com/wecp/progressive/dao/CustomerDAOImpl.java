package com.wecp.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.dto.CustomerAccountInfo;
import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.entity.Customers;
@Repository
public class CustomerDAOImpl implements CustomerDAO{
    private List<Customers> customersList = new ArrayList<Customers>();
   private Connection connection;

public CustomerDAOImpl() {
    try{
        this.connection = DatabaseConnectionManager.getConnection();
    }
    catch(SQLException s)
    {
    
    }
}

@Override
public int addCustomer(Customers customers) throws SQLException {
    // TODO Auto-generated method stub
    String query="insert into customers(name, email, username, password, role) values(?, ?, ?, ?, ?)";
        try(PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
        {
            ps.setString(1, customers.getName());
            ps.setString(2, customers.getEmail());
            ps.setString(3, customers.getUsername());
            ps.setString(4, customers.getPassword());
            ps.setString(5, customers.getRole());
            int n=ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
            {
                customers.setCustomerId(rs.getInt(1));
            }
        }
        return customers.getCustomerId();
}

@Override
public void deleteCustomer(int customerId) throws SQLException {
    // TODO Auto-generated method stub
    String query = "delete from customers where customer_id=?";
        try(PreparedStatement ps = connection.prepareStatement(query))
        {
            ps.setInt(1, customerId);
            ps.executeUpdate();
        }
}

@Override
public List<Customers> getAllCustomers() throws SQLException {
    // TODO Auto-generated method stub
    
    String query = "Select * from customers";
        try(PreparedStatement ps = connection.prepareStatement(query))
        { 
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                customersList.add(new Customers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        }

        return customersList;
}

@Override
public CustomerAccountInfo getCustomerAccountInfo(int customerId) throws SQLException {
    // TODO Auto-generated method stub
    String query = "select customers.customer_id, customers.name, customers.email, accounts.account_id, accounts.balance from customers join accounts on customers.customer_id=accounts.customer_id where customers.customer_id=?";
    try(PreparedStatement ps = connection.prepareStatement(query))
        {
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return new CustomerAccountInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5));
            }
        }
        return null;
}

@Override
public Customers getCustomerById(int customerId) throws SQLException {
    // TODO Auto-generated method stub
    String query = "Select * from customers where customer_id=?";
        try(PreparedStatement ps = connection.prepareStatement(query))
        {
            ps.setInt(1, customerId);
            
            
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return new Customers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        }
        return null;
}

@Override
public void updateCustomer(Customers customers) throws SQLException {
    // TODO Auto-generated method stub
    String query = "update customers set name=?, email=?, username=?, password=?, role=? where customer_id=?";
        try(PreparedStatement ps = connection.prepareStatement(query))
        {
            ps.setString(1, customers.getName());
            ps.setString(2, customers.getEmail());
            ps.setString(3, customers.getUsername());
            ps.setString(4, customers.getPassword());
            ps.setString(5, customers.getRole());
            ps.setInt(6, customers.getCustomerId());
            ps.executeUpdate();
        }
}
}

