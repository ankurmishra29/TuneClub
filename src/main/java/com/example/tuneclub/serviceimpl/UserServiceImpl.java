package com.example.tuneclub.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.tuneclub.entity.User;
import com.example.tuneclub.repository.UserRepository;
import com.example.tuneclub.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	@Override
	public String addUser(User user) {
		userRepository.save(user);
		return "success";
	}

	// To check the duplicate entries
	@Override
	public boolean emailExists(String email) {
		if(userRepository.findByEmail(email) !=null) {
			return true;
		}
		else {
			return false;
		}
	}
    
	@Override
	public boolean validateUser(String email, String password) {
		User user=userRepository.findByEmail(email);
		if(user!=null) {
				String dbpw=user.getPassword();
				if(password.equals(dbpw)) {
					return true;
				}
		}
		return false;
	}
    
	@Override
	public String getRole(String email) {
		User user=userRepository.findByEmail(email);
		return user.getRole();
	}

	@Override
	public User getUser(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
		
	}
}
