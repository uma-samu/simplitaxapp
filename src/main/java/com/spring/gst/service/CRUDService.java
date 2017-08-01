package com.spring.gst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.gst.model.GSTR1_Invoice;
import com.spring.gst.model.GSTR1_Invoice_Nw;
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

	@Override
	public List<GSTR1_Invoice> getAllB2bs() {
		return crudRepository.getAllB2bs();
	}
	
	public int addB2b(GSTR1_Invoice invoice){
		return crudRepository.addB2b(invoice);
	}
	
	public int removeB2b(String invoiceNum,String itemSerialNo){
		return crudRepository.removeB2b(invoiceNum,itemSerialNo);
	}

	@Override
	public List<GSTR1_Invoice> getB2bsByCriteria(String criteria,String value) {
		return crudRepository.getB2bsByCriteria(criteria,value);
	}

	// new 
	
	@Override
	public List<GSTR1_Invoice_Nw> getAllB2bs1() {
		return crudRepository.getAllB2bs1();
	}

	@Override
	public List<GSTR1_Invoice_Nw> getB2bsByCriteria1(String criteria, String value) {
		return crudRepository.getB2bsByCriteria1(criteria, value);
	}

	@Override
	public int addB2b1(GSTR1_Invoice_Nw invoice) {
		return crudRepository.addB2b1(invoice);
	}

	@Override
	public int removeB2b1(String invoiceNum) {
		return crudRepository.removeB2b1(invoiceNum);
	}
	
	//new

}
