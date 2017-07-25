package com.spring.gst.repository;
import java.util.List;

import com.spring.gst.model.User;

public interface ICRUDRepository{

	public List<User> getAllUsers();
	public int addUser(User user);
	public int updateUser(User user);
	public int deleteUser(String id);
}
