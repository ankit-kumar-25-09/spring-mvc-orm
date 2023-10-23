package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;

@Service
public class UserDAOImpl implements UserDAO {
	@Autowired
	private AppDAO appDAO;
	List<User> al = new ArrayList<>();

	@Override
	public boolean loginValidate(User user) {
		for(User user1:al) {
			if(user1.getUserName().equals(user.getUserName()) && user1.getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		appDAO.save(user);
	}

	@Override
	public List<User> loadAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>)appDAO.findAll();
	}

	@Override
	public User loadUser(int userId) {
		// TODO Auto-generated method stub
		Optional<User> op = appDAO.findById(userId);
		return op.get();
	}

	@Override
	public boolean deleteUser(String userName) {
		// TODO Auto-generated method stub
		int idx = -1;
		for(int i=0;i<al.size();i++) {
			if(al.get(i).getUserName().equals(userName)) {
				idx = i;
				break;
			}
		}
		if(idx == -1)return false;
		al.remove(idx);
		return true;
	}

	@Override
	public boolean updateUser(String userName, User user) {
		// TODO Auto-generated method stub
		int idx = -1;
		for(int i=0;i<al.size();i++) {
			if(al.get(i).getUserName().equals(userName)) {
				idx = i;
				break;
			}
		}
		
		if(idx==-1)return false;
		
		al.set(idx, user);
		return true;
	}
	
	

}
