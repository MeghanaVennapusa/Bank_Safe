package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.repository.AccountRepository;
import com.wecp.progressive.repository.TransactionRepository;
import com.wecp.progressive.service.TransactionService;
@Service
public class TransactionServiceImplJpa implements TransactionService{
    
    private TransactionRepository transactionRepository;
    
    private AccountRepository accountRepository;
    
    public TransactionServiceImplJpa(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }
    @Override
    public int addTransaction(Transactions transaction) throws SQLException {
        // TODO Auto-generated method stub
        
        
Accounts account = accountRepository.findById(transaction.getAccountId()).orElse(null);

if (account == null) {
    return -1;
}

// Set the account object before saving
transaction.setAccount(account);

// Save the transaction
Transactions savedTransaction = transactionRepository.save(transaction);

        

        return savedTransaction.getTransactionId();
    }
    @Override
    public void deleteTransaction(int transactionId) throws SQLException {
        // TODO Auto-generated method stub
        transactionRepository.deleteById(transactionId);
        
    }
    @Override
    public List<Transactions> getAllTransactions() throws SQLException {
        // TODO Auto-generated method stub
        return transactionRepository.findAll();
    }
    @Override
    public Transactions getTransactionById(int transactionId) throws SQLException {
        // TODO Auto-generated method stub
        if(transactionRepository.findById(transactionId).isPresent())
        return transactionRepository.findById(transactionId).get();
        else
        return null;
        
    }
    @Override
    public List<Transactions> getTransactionsByCustomerId(int customerId) throws SQLException {
        // TODO Auto-generated method stub
        return transactionRepository.getByCustomerId(customerId);
    }
    @Override
    public void updateTransaction(Transactions transaction) throws SQLException {
        // TODO Auto-generated method stub

        
    }
    


}
