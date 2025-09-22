package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.dao.AccountDAO;
import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.service.AccountService;

public class AccountServiceImpl implements AccountService{

    private AccountDAO accountDAO;

    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public int addAccount(Accounts accounts) throws SQLException {
        // TODO Auto-generated method stub
        return -1;
    }

    @Override
    public Accounts getAccountById(int accountId) throws SQLException {
        // TODO Auto-generated method stub
        return null;//AccountService.super.getAccountById(accountId);
    }

    @Override
    public List<Accounts> getAccountsByUser(int userId) throws SQLException {
        // TODO Auto-generated method stub
        return null;//AccountService.super.getAccountsByUser(userId);
    }

    @Override
    public List<Accounts> getAllAccounts() throws SQLException {
        // TODO Auto-generated method stub
        return new ArrayList<>();
    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {
        // TODO Auto-generated method stub
        return new ArrayList<>();
    }

    @Override
    public void deleteAccount(int accountId) throws SQLException {
        // TODO Auto-generated method stub
        //AccountService.super.deleteAccount(accountId);
    }

    @Override
    public void updateAccount(Accounts accounts) throws SQLException {
        // TODO Auto-generated method stub
        //AccountService.super.updateAccount(accounts);
    }
    
    

}

