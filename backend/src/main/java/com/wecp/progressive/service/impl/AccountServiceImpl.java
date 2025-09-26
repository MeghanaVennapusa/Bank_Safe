package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.stereotype.Service;

import com.wecp.progressive.dao.AccountDAO;
import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService{

    private AccountDAO accountDAO;
    private static List<Accounts> accountsList = new ArrayList<>();
    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public int addAccount(Accounts accounts) throws SQLException {
        // TODO Auto-generated method stub
        return accountDAO.addAccount(accounts);
    }

    @Override
    public Accounts getAccountById(int accountId) throws SQLException {
        // TODO Auto-generated method stub
        return accountDAO.getAccountById(accountId);//AccountService.super.getAccountById(accountId);
    }

    @Override
    public List<Accounts> getAccountsByUser(int userId) throws SQLException {
        // TODO Auto-generated method stub
        return null;//AccountService.super.getAccountsByUser(userId);
    }

    @Override
    public List<Accounts> getAllAccounts() throws SQLException {
        // TODO Auto-generated method stub
        return accountDAO.getAllAccounts();
    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {
        // TODO Auto-generated method stub
        accountsList=accountDAO.getAllAccounts();
        Collections.sort(accountsList);
        return accountsList;
    }

    @Override
    public void deleteAccount(int accountId) throws SQLException {
        // TODO Auto-generated method stub
        //AccountService.super.deleteAccount(accountId);
        accountDAO.deleteAccount(accountId);
    }

    @Override
    public void updateAccount(Accounts accounts) throws SQLException {
        // TODO Auto-generated method stub
        //AccountService.super.updateAccount(accounts);
        accountDAO.updateAccount(accounts);
    }
    
    

}

