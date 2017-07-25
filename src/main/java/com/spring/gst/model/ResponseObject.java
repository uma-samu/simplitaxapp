package com.spring.gst.model;

import java.io.Serializable;

public class ResponseObject implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private String success;
	private String token;
	private User user;
	

	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
