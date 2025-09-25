package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.dao.AccountDAO;
import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.repository.AccountRepository;
import com.wecp.progressive.service.AccountService;
@Service
public class AccountServiceImplJpa implements AccountService{
    @Autowired
    private AccountRepository accountRepository; 
    @Override
    public int addAccount(Accounts accounts) throws SQLException {
        // TODO Auto-generated method stub
        accountRepository.save(accounts);
        return accounts.getAccountId();
    }

    @Override
    public void deleteAccount(int accountId) throws SQLException {
        // TODO Auto-generated method stub
        AccountService.super.deleteAccount(accountId);
        accountRepository.deleteById(accountId);
    }

    @Override
    public Accounts getAccountById(int accountId) throws SQLException {
        // TODO Auto-generated method stub
        return accountRepository.findById(accountId).get();
    }

    @Override
    public List<Accounts> getAccountsByUser(int userId) throws SQLException {
        // TODO Auto-generated method stub
        return AccountService.super.getAccountsByUser(userId);

    }

    @Override
    public List<Accounts> getAllAccounts() throws SQLException {
        // TODO Auto-generated method stub
        return accountRepository.findAll();
    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateAccount(Accounts accounts) throws SQLException {
        // TODO Auto-generated method stub
        AccountService.super.updateAccount(accounts);
    }
    
    
}