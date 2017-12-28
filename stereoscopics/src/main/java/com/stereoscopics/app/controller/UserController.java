package com.stereoscopics.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stereoscopics.app.models.User;
import com.stereoscopics.app.repo.UserRepo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserRepo userRepo;
	
	@Autowired
	public UserController(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@GetMapping("/createUser")
	public String createBlogPost(Model model) {
		model.addAttribute("user", new User());
		return "createUser";
	}

	@PostMapping("/createUser")
	public String submitBlogPost(@ModelAttribute User user) {
		userRepo.save(user);
		return "createUser";
	}

	}