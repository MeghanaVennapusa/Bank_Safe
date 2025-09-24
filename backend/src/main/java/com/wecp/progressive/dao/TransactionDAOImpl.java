package com.wecp.progressive.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.entity.Transactions;

public class TransactionDAOImpl implements TransactionDAO{

    private Connection connection;

    public TransactionDAOImpl() {
        try{
        this.connection = DatabaseConnectionManager.getConnection();
    }
    catch(SQLException s)
    {
    
    }
    }

    @Override
    public int addTransaction(Transactions transaction) throws SQLException {
        // TODO Auto-generated method stub
       String query="insert into transactions(account_id, amount, transaction_date, transaction_type) values(?, ?, ?, ?)";
        try(PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
        {   //java.util.Date utilDate = new java.util.Date(); // Current date
            //java.sql.Date sqlDate = new java.sql.Date(transaction.getTransactionDate().getTime());
            ps.setInt(1, transaction.getAccountId());
            ps.setDouble(2, transaction.getAmount());
            ps.setDate(3, (Date) transaction.getTransactionDate());
            ps.setString(4, transaction.getTransactionType());
            int n=ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
            {
                transaction.setTransactionId(rs.getInt(1));
            }
        }
        return transaction.getAccountId();
}

    @Override
    public void deleteTransaction(int transactionId) throws SQLException {
        // TODO Auto-generated method stub
        String query = "delete from transactions where transaction_id=?";
        try(PreparedStatement ps = connection.prepareStatement(query))
        {
            ps.setInt(1, transactionId);
            ps.executeUpdate();
        }
        
    }

    @Override
    public List<Transactions> getAllTransactions() throws SQLException {
        // TODO Auto-generated method stub
        List<Transactions> ls = new ArrayList<>();
        String query = "Select * from transactions";
        try(PreparedStatement ps = connection.prepareStatement(query))
        { 
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                ls.add(new Transactions(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4), rs.getString(5)));
            }
        }

        return ls;
    }

    @Override
    public Transactions getTransactionById(int transactionId) throws SQLException {
        // TODO Auto-generated method stub
        String query = "Select * from transactions where transaction_id=?";
        try(PreparedStatement ps = connection.prepareStatement(query))
        {
            ps.setInt(1, transactionId);
            
            
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return new Transactions(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4), rs.getString(5));
            }
        }
        return null;
    }

    @Override
    public void updateTransaction(Transactions transaction) throws SQLException {
        // TODO Auto-generated method stub
        String query = "update transactions set account_id=?, amount=?, transaction_date=?, transaction_type=? where transaction_id=?";
        try(PreparedStatement ps = connection.prepareStatement(query))
        {
            //java.sql.Date sqlDate = new java.sql.Date(transaction.getTransactionDate().getTime());
            ps.setInt(1, transaction.getAccountId());
            ps.setDouble(2, transaction.getAmount());
            ps.setDate(3, (Date) transaction.getTransactionDate());
            ps.setString(4, transaction.getTransactionType());
            ps.setInt(5, transaction.getTransactionId());
            ps.executeUpdate();
        }
        
    }

    
    

    

}

