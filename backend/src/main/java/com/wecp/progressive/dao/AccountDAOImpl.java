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
import com.wecp.progressive.entity.Accounts;
@Repository
public class AccountDAOImpl implements AccountDAO{
    private List<Accounts> accountsList = new ArrayList<Accounts>();

    private Connection connection;
    
    public AccountDAOImpl() {
        try{
        this.connection = DatabaseConnectionManager.getConnection();
    }
    catch(SQLException s)
    {
    
    }
}

    @Override
    public int addAccount(Accounts accounts) throws SQLException {
        // TODO Auto-generated method stub
        String query="insert into accounts(customer_id, balance) values(?, ?)";
        try(PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
        {
            ps.setInt(1, accounts.getCustomerId());
            ps.setDouble(2, accounts.getBalance());
            int n=ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
            {
                accounts.setAccountId(rs.getInt(1));
                return accounts.getAccountId();
            }
        }
        return 0;
    }

    @Override
    public void deleteAccount(int accountId) throws SQLException {
        // TODO Auto-generated method stub
        String query = "delete from accounts where account_id=?";
        try(PreparedStatement ps = connection.prepareStatement(query))
        {
            ps.setInt(1, accountId);
            ps.executeUpdate();
        }
    }

    @Override
    public Accounts getAccountById(int accountId) throws SQLException {
        // TODO Auto-generated method stub
        String query = "Select * from accounts where account_id=?";
        try(PreparedStatement ps = connection.prepareStatement(query))
        {
            ps.setInt(1, accountId);
            
            
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return new Accounts(rs.getInt(1), rs.getInt(2), rs.getDouble(3));
            }
        }
        return null;
    }

    @Override
    public List<Accounts> getAllAccounts() throws SQLException {
        // TODO Auto-generated method stub
    
        String query = "Select * from accounts";
        try(PreparedStatement ps = connection.prepareStatement(query))
        { 
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                accountsList.add(new Accounts(rs.getInt(1), rs.getInt(2), rs.getDouble(3)));
            }
        }

        return accountsList;
    }

    @Override
    public void updateAccount(Accounts accounts) throws SQLException {
        // TODO Auto-generated method stub
        String query = "update accounts set customer_id = ?, balance = ? where account_id=?";
        try(PreparedStatement ps = connection.prepareStatement(query))
        {
            ps.setInt(1, accounts.getCustomerId());
            ps.setDouble(2, accounts.getBalance());
            ps.setInt(3, accounts.getAccountId());
            ps.executeUpdate();
        }
        
    }
    
}
