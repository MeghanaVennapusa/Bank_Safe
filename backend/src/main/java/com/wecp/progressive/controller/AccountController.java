package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Accounts;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AccountController {


    public List<Accounts> getAllAccounts() {
        return null;
    }

    public Accounts getAccountById(int accountId) {
        return null;
    }

    public List<Accounts> getAccountsByUser(String param) {
        return null;
    }

    public Integer addAccount(Accounts accounts) {
        return null;
    }

    public void updateAccount(int accountId, Accounts accounts) {
        //return null;
    }

    public void deleteAccount(int accountId) {
        //return null;
    }
}