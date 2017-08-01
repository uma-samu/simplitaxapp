package com.spring.gst.repository;
import java.util.List;

import com.spring.gst.model.GSTR1_Invoice;
import com.spring.gst.model.GSTR1_Invoice_Nw;
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
	
	//new
	public List<GSTR1_Invoice_Nw> getAllB2bs1();
	public List<GSTR1_Invoice_Nw> getB2bsByCriteria1(String criteria,String value);
	public int addB2b1(GSTR1_Invoice_Nw invoice);
	public int removeB2b1(String invoiceNum);
	//new
}
