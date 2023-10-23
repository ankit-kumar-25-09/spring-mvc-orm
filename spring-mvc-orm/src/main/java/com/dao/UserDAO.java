package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.model.User;

public interface UserDAO {
	
	
	
	public boolean loginValidate(User user) ;
	public void registerUser(User user);
	public List<User> loadAllUsers();
	public User loadUser(int userId);
	public boolean deleteUser(String userName);
	public boolean updateUser(String userName,User user);
	
}
