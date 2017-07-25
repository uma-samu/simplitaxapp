package com.spring.gst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.gst.model.User;
import com.spring.gst.repository.ICRUDRepository;

@Service
public class CRUDService implements ICRUDService {

	@Autowired
	private ICRUDRepository crudRepository;
	
	@Override
	public List<User> getAllUsers() {
		return crudRepository.getAllUsers();
	}

	@Override
	public int addUser(User user) {
		return crudRepository.addUser(user);
	}

	@Override
	public int updateUser(User user) {
		return crudRepository.updateUser(user);
	}

	@Override
	public int deleteUser(String id) {
		return crudRepository.deleteUser(id);
	}

}
