package com.example.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//Resource controller
@Controller
@RequestMapping("/mainline")
public class ResController {

	@GetMapping("/register")
	
	public String regsiter() {
		return "register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	
	
}
