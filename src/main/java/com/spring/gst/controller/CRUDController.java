package com.spring.gst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.gst.model.GSTR1InvoiceResponse;
import com.spring.gst.model.GSTR1_Invoice;
import com.spring.gst.model.ResponseObject;
import com.spring.gst.model.User;
import com.spring.gst.service.ICRUDService;
import com.spring.gst.util.ResponseUserUtil;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/crud")
@CrossOrigin(origins="http://localhost:4200")
public class CRUDController {

	@Autowired
	private ICRUDService crudService;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public ResponseEntity<?> test()
	{
		String success = "CRUD API Services OK";
		return new ResponseEntity<String>(success,HttpStatus.OK);
	}
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public ResponseEntity<?> getUsers()
	{
		List<User> users = crudService.getAllUsers();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/update/{id}",method=RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") String id,@RequestBody User user)
	{
		user.setId(id);
		int row = crudService.updateUser(user);
		HttpStatus status = HttpStatus.NOT_FOUND;
		if(row > 0)
			status = HttpStatus.OK;
		return new ResponseEntity<Object>(status);
	}
	
	@RequestMapping(value="/user/create",method=RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user)
	{
		int row = crudService.addUser(user);
		HttpStatus status = HttpStatus.NOT_MODIFIED;
		if(row > 0)
			status = HttpStatus.CREATED;
		return new ResponseEntity<Object>(status);
	}
	
	@RequestMapping(value="/user/delete/{id}",method=RequestMethod.PUT)
	public ResponseEntity<?> deleteUser(@PathVariable("id") String id)
	{
		int row = crudService.deleteUser(id);
		HttpStatus status = HttpStatus.NOT_FOUND;
		if(row > 0)
			status = HttpStatus.NO_CONTENT;
		return new ResponseEntity<Object>(status);
	}
	
	@RequestMapping(value="/user/test",method=RequestMethod.GET)
	public ResponseEntity<?> testUser()
	{
		ResponseObject res = ResponseUserUtil.createResponseUser();
		return new ResponseEntity<ResponseObject>(res,HttpStatus.OK);
	}
	
	@RequestMapping(value="/gstr1/b2b",method=RequestMethod.GET)
	public ResponseEntity<?> getB2bGstr1Invoice()
	{
		List<GSTR1_Invoice> invoices = crudService.getAllB2bs();
		GSTR1InvoiceResponse response = new GSTR1InvoiceResponse();
		
		response.setSuccess("true");
		response.setInvoices(invoices);
		
		return new ResponseEntity<GSTR1InvoiceResponse>(response,HttpStatus.OK);
	}
}
