package com.spring.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.user.entities.Bank;

@Controller
public class BankDao {

	@Autowired
	BankRepository bankRepository;
	
	public Bank saveBank(Bank bank)
	{
		return bankRepository.save(bank);
	}
	

}
