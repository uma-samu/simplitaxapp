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
	public List<GSTR1_Invoice> getB2bsByCriteria(String criteria,String value);
	public int addB2b(GSTR1_Invoice invoice);
	public int removeB2b(String invoiceNum,String itemSerialNo);
}
