package com.wecp.progressive.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wecp.progressive.entity.Accounts;

public interface AccountRepository extends JpaRepository<Accounts, Integer>{
    @Query("select a from Accounts a where customerId=:customerId")
    public List<Accounts> getAccountsByCustomerCustomerId(int customerId);

    @Query("select a from Accounts a where accountId=:accountId")
    public Accounts findByAccountId(int accountId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Accounts acc WHERE acc.customer.customerId = :customerId")
    void deleteacc(@Param("customerId") int customerId);
}
