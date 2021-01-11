package com.example.Webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Webapp.entity.Account;
import com.example.Webapp.entity.Post;
import com.example.Webapp.service.AccountService;
import com.example.Webapp.service.PostService;

@Controller
public class loginController {

	@Autowired
	AccountService accountService;

	@Autowired
	PostService postService;

	@GetMapping("/login")
	public String getLogin (
			Model model) {
		List<Account> accounts = accountService.findAll();
		model.addAttribute("Accounts", accounts);

		return "login";
	}

	@GetMapping("/home")
	public String getHome (
			Model model) {
		List<Post> posts = postService.findAll();
		model.addAttribute("Posts", posts);

		return "home";
	}
}
