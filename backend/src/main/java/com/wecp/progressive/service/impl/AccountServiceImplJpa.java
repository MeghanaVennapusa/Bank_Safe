package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.service.AccountService;

public class AccountServiceImplJpa implements AccountService{

    @Override
    public int addAccount(Accounts accounts) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void deleteAccount(int accountId) throws SQLException {
        // TODO Auto-generated method stub
        AccountService.super.deleteAccount(accountId);
    }

    @Override
    public Accounts getAccountById(int accountId) throws SQLException {
        // TODO Auto-generated method stub
        return AccountService.super.getAccountById(accountId);
    }

    @Override
    public List<Accounts> getAccountsByUser(int userId) throws SQLException {
        // TODO Auto-generated method stub
        return AccountService.super.getAccountsByUser(userId);
    }

    @Override
    public List<Accounts> getAllAccounts() throws SQLException {
        // TODO Auto-generated method stub
        return null;
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