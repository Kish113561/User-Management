package com.spring.user.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.user.dao.UserDao;
import com.spring.user.entities.User;

import jakarta.validation.Valid;

@RequestMapping("/user-management")
@RestController
public class UserController {


	@Autowired
	UserDao userdao ;
	
	@GetMapping("/user")
	public ResponseEntity< List<User>> getAllUsers()
	{
		 List<User> users = userdao.getAllUsers();
		 if(users.size()<=0)
		 {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		return ResponseEntity.of(Optional.of(users));
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable String id)
	{
		 User user = userdao.getUserById(id);
		 if(user == null)
		 {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		 return ResponseEntity.of(Optional.of(user));
	}
	
	@PostMapping("/user")
	@Valid
	public ResponseEntity<User> saveUser(@RequestBody User user)
	{
		User user_created = userdao.saveUser(user);
		
		if(user_created!= null)
		{
			System.err.println("inside if");
			return ResponseEntity.status(HttpStatus.CREATED).body(user_created);
			
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	@PutMapping("/user/{id}")
	public User updateUser(@RequestBody User user,@PathVariable String id)
	{
		return userdao.updateUser(user, id);
	}
	
	@DeleteMapping("/user")
	public ResponseEntity<String> updateUser()
	{
		userdao.deleteAllUsers();
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity deleteUserById(@PathVariable String id)
	{
		try {
			User user = userdao.getUserById(id);
			 if(user != null)
			 {
					userdao.deleteUserById(id);
					return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			 }else {
				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	@PostMapping("/user/batch")
	public ResponseEntity<User> saveUserBulk(@RequestBody List<User> user)
	{
		user.stream().forEach(u ->userdao.saveUser(u));
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	

}
