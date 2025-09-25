package com.wecp.progressive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wecp.progressive.entity.Accounts;

public interface AccountRepository extends JpaRepository<Accounts, Integer>{
}
