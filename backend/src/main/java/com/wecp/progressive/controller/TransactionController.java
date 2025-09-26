package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.service.impl.AccountServiceImplJpa;
import com.wecp.progressive.service.impl.TransactionServiceImplJpa;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionServiceImplJpa transactionServiceImplJpa;
    private final AccountServiceImplJpa accountServiceImplJpa;
    
    
    public TransactionController(TransactionServiceImplJpa transactionServiceImplJpa,
            AccountServiceImplJpa accountServiceImplJpa) {
        this.transactionServiceImplJpa = transactionServiceImplJpa;
        this.accountServiceImplJpa = accountServiceImplJpa;
    }
    @GetMapping
    public List<Transactions> getAllTransactions() {
        List<Transactions> ls = new ArrayList<>();

        return ls;

    }
    @GetMapping("/{transactionId}")
    public ResponseEntity<Transactions> getTransactionById(@PathVariable Integer transactionId) throws SQLException{
        Transactions t = transactionServiceImplJpa.getTransactionById(transactionId);
        
        if (t != null) {
            return new ResponseEntity<>(t, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public int addTransaction(@RequestBody Transactions transaction) throws SQLException{
        
Accounts account = accountServiceImplJpa.getAccountById(transaction.getAccountId());
transaction.setAccount(account);

// Now save the transaction
Integer id = transactionServiceImplJpa.addTransaction(transaction);

if (id != null && id >= 1) {
    transaction.setTransactionId(id);
    return id;
}

        return -1;
    }
    public ResponseEntity<Void> updateTransaction(int transactionId, Transactions transaction) throws SQLException{
        if(transactionServiceImplJpa.getTransactionById(transactionId)!=null) 
        transactionServiceImplJpa.updateTransaction(transaction);
        return new ResponseEntity<>(HttpStatus.OK);
        
    }
    public ResponseEntity<Void> deleteTransaction(int transactionId) throws SQLException{
        if(transactionServiceImplJpa.getTransactionById(transactionId)!=null) 
        transactionServiceImplJpa.deleteTransaction(transactionId);
        return new ResponseEntity<>(HttpStatus.OK);
        
    }
    public List<Transactions> getAllTransactionsByCustomerId(int customerId) throws SQLException
    {
        return transactionServiceImplJpa.getTransactionsByCustomerId(customerId);
    }
}