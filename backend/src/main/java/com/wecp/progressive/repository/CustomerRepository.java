package com.wecp.progressive.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wecp.progressive.entity.Customers;

public interface CustomerRepository extends JpaRepository<Customers, Integer>{
    @Query("select c from Customers c where c.customerId = :customerId")
    Customers findByCustomerId(@Param("customerId") int customerId);
    @Modifying
    @Transactional
    @Query("DELETE FROM Customers c WHERE c.customerId = :customerId")
    void deleteByCustomerId(@Param("customerId") int customerId);


}
