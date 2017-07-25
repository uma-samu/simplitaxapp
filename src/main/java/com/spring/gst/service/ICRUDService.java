package com.spring.gst.service;

import java.util.List;

import com.spring.gst.model.User;

public interface ICRUDService {
	
	public List<User> getAllUsers();
	public int addUser(User user);
	public int updateUser(User user);
	public int deleteUser(String id);
	
}
