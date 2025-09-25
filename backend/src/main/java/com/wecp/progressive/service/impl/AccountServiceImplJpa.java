package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.dao.AccountDAO;
import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.repository.AccountRepository;
import com.wecp.progressive.service.AccountService;
@Service
public class AccountServiceImplJpa implements AccountService{
    
    private AccountRepository accountRepository; 
    
    public AccountServiceImplJpa(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public int addAccount(Accounts accounts) throws SQLException {
        // TODO Auto-generated method stub
       // accountRepository.save(accounts);
        //return accounts.getAccountId();
        return -1;
    }

    @Override
    public void deleteAccount(int accountId) throws SQLException {
        // TODO Auto-generated method stub
        //AccountService.super.deleteAccount(accountId);
        //accountRepository.deleteById(accountId);
    }

    @Override
    public Accounts getAccountById(int accountId) throws SQLException {
        // TODO Auto-generated method stub
        //return accountRepository.findById(accountId).get();
        return null;
    }

    @Override
    public List<Accounts> getAccountsByUser(int userId) throws SQLException {
        // TODO Auto-generated method stub
       // return AccountService.super.getAccountsByUser(userId);
        return null;
    }

    @Override
    public List<Accounts> getAllAccounts() throws SQLException {
        // TODO Auto-generated method stub
        //return accountRepository.findAll();
        return null;
    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {
        // TODO Auto-generated method stub
        // List<Accounts> ls = accountRepository.findAll();
        // Collections.sort(ls);
        // return ls;
        return null;
    }

    @Override
    public void updateAccount(Accounts accounts) throws SQLException {
        // TODO Auto-generated method stub
        //AccountService.super.updateAccount(accounts);
        //accountRepository.save(accounts);
    }
    
    
}