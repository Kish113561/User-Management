package com.spring.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.user.entities.Bank;

public interface BankRepository extends CrudRepository<Bank, Integer>{

}
