package com.example.tuneclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tuneclub.entity.User;
import com.example.tuneclub.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/register")
	public String addUser(@ModelAttribute User user) {

		//email taken from registration form
		String email=user.getEmail();

		//checking if email as entered in registration form is present in DB or not.
		boolean status=userService.emailExists(email);
		if(status==false) {
			System.out.println("Usename: "+user.getUsername()+"Email: "+user.getEmail()+"Password: "+user.getPassword()+"Gender: "+user.getGender()+"Role: "+user.getRole()+"Address: "+user.getAddress());

			userService.addUser(user);
		}
		else {
			System.out.println("User already exists...");
		}
		return "login";
	}

	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
		if(userService.validateUser(email, password)==true) {
			String role=userService.getRole(email);
			session.setAttribute("email", email);
			if(role.equals("admin")) {
				return "adminhome";
			}
			else {
				User user=userService.getUser(email);
				if(user.getIsPremium()) {
					return "premiumhome";
				}
				else {
					return "customerhome";
				}
			}
		}
			else {
				return "login";
			}
		}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	}
