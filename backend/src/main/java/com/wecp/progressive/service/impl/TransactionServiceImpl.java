package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.springframework.stereotype.Service;

import com.wecp.progressive.dao.TransactionDAO;
import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.service.TransactionService;
@Service
public class TransactionServiceImpl implements TransactionService{

    private TransactionDAO transactionDAO;

    
    public TransactionServiceImpl(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    @Override
    public int addTransaction(Transactions transaction) throws SQLException {
        // TODO Auto-generated method stub
        return transactionDAO.addTransaction(transaction);
    }

    @Override
    public void deleteTransaction(int transactionId) throws SQLException {
        // TODO Auto-generated method stub
        transactionDAO.deleteTransaction(transactionId);
        
    }

    @Override
    public List<Transactions> getAllTransactions() throws SQLException {
        // TODO Auto-generated method stub
        return transactionDAO.getAllTransactions();
    }

    @Override
    public Transactions getTransactionById(int transactionId) throws SQLException {
        // TODO Auto-generated method stub
        return transactionDAO.getTransactionById(transactionId);
    }

    @Override
    public List<Transactions> getTransactionsByCustomerId(int customerId) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateTransaction(Transactions transaction) throws SQLException {
        // TODO Auto-generated method stub
        transactionDAO.updateTransaction(transaction);
        
    }

    
}
