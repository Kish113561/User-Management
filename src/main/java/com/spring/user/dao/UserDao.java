package com.spring.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.user.entities.User;

@Controller
public class UserDao {

	
	@Autowired
	UserRepository userRepository ;
	
	public User saveUser(User user)
	{
		try {
			var  temp = userRepository.findByEmail(user.getEmail());
			System.err.println("user data  "+temp);
			if(temp ==null);
			{
			return userRepository.save(user);
			}
		} catch (Exception e) {
			System.err.println("inside catch");
			return null;

		}
	}
	
	public List<User> getAllUsers()
	{
		return (List<User>) userRepository.findAll();
	}

	public User updateUser(User user, String id) {
		
		System.out.println(userRepository.findById(Integer.parseInt(id)).isPresent());
		if(userRepository.findById(Integer.parseInt(id)).isPresent())
		{
			user.setId(Integer.parseInt(id));
			userRepository.save(user);
		}
		return user;
	}

	public void deleteAllUsers() {
		
		userRepository.deleteAll();
	}

	public User getUserById(String id) {
		User user = null;
		try {
			user = userRepository.findById(Integer.parseInt(id)).get();
		} catch (Exception e) {
			System.err.println("user not found");
		}
		return user;
	}

	public void deleteUserById(String id) {
		userRepository.deleteById(Integer.parseInt(id));
	}
}
