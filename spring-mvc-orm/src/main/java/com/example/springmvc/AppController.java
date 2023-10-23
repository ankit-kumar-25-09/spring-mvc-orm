package com.example.springmvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.UserDAO;
import com.model.User;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/mainline")

public class AppController {
	
	@Autowired
	private UserDAO userDAO;
	
	@GetMapping("/welcome")
	
	public String sayWelcome() {
		return "Welcome to spring mvc";
	}
	
	
	
	@PostMapping("/login")
	
	public String loginHandle(@RequestBody User user) {
		System.out.println(user);
		boolean loggedIn = userDAO.loginValidate(user);
		return loggedIn==true?"Login success":"Login failed";
		
	}
	
	
	@PostMapping("/register")
	public String registerHandler(@RequestBody User user) {
		
		
		userDAO.registerUser(user);
		return "User registered";
	}
	
	@GetMapping("/loadAll")
	public List<User> loadAll() {
		return userDAO.loadAllUsers();
	}
	
	@GetMapping("/findUser/{userId}")
	@ApiOperation(value="find details by id",notes = "provide id for the data",response=User.class)
	public User findUser(@PathVariable int userId) {
		return userDAO.loadUser(userId);
	}
	
	@DeleteMapping("/deleteUser/{userName}")
	public String deleteUser(@PathVariable String userName) {
		boolean deleted = userDAO.deleteUser(userName);
		return deleted==true?"User deleted":"could not find the user";
	}
	
	
	@PutMapping("/updateUser/{userName}")
	public String updateUser(@PathVariable String userName,@RequestBody User user) {
		boolean updated = userDAO.updateUser(userName, user);
		return updated==true?userName+" has been updated":"Could not find the user";
	}
}
