package com.spring.user.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.user.entities.User;
public interface UserRepository extends CrudRepository<User, Integer> {
	
	
	public User findByEmail(String email);
}
