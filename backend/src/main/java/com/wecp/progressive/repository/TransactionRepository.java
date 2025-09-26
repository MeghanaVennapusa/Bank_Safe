package com.wecp.progressive.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wecp.progressive.entity.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, Integer>{
    @Query("SELECT t FROM Transactions t WHERE t.account.accountId = :accountId")
List<Transactions> findByAccountsAccountId(@Param("accountId") int accountId);
    

    @Modifying
    @Transactional
    @Query("DELETE FROM Transactions t WHERE t.account.accountId = :accountId")
    void deleteByAccountId(@Param("accountId") int accountId);
    
    
    @Modifying
    @Transactional
    @Query("DELETE FROM Transactions t WHERE t.account.customer.id = :customerId")
    void deleteByCustomerId(@Param("customerId") int customerId);
        
    @Modifying
    @Transactional
    @Query("SELECT t FROM Transactions t WHERE t.account.customer.id = :customerId")
    List<Transactions> getByCustomerId(@Param("customerId") int customerId);
        


    
}
