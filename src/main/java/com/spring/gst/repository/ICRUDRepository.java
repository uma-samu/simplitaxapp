package com.spring.gst.repository;
import java.util.List;

import com.spring.gst.model.GSTR1_Invoice;
import com.spring.gst.model.User;

public interface ICRUDRepository{

	public List<User> getAllUsers();
	public int addUser(User user);
	public int updateUser(User user);
	public int deleteUser(String id);
	public List<GSTR1_Invoice> getAllB2bs();
}
