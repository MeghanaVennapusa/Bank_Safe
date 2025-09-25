package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Transactions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TransactionController {

    public List<Transactions> getAllTransactions() {
        return null;
    }
    public Transactions getTransactionById(int transactionId) {
        return null;
    }
    public Integer addTransaction(Transactions transaction) {
        return null;
    }
    public void updateTransaction(int transactionId, Transactions transaction) {
        //return null;
    }
    public void deleteTransaction(int transactionId) {
        //return null;
    }
}
