package com.spring.gst.model;

import java.io.Serializable;
import java.util.Date;


public class GSTR1 implements Serializable{


	private static final long serialVersionUID = 1L;
	private int id;
	private Date for_period;
	private String status;
	private int business_id;
	private String gstin;
	private Date due_date;
	private Date submitted_date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFor_period() {
		return for_period;
	}
	public void setFor_period(Date for_period) {
		this.for_period = for_period;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getBusiness_id() {
		return business_id;
	}
	public void setBusiness_id(int business_id) {
		this.business_id = business_id;
	}
	public String getGstin() {
		return gstin;
	}
	public void setGstin(String gstin) {
		this.gstin = gstin;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public Date getSubmitted_date() {
		return submitted_date;
	}
	public void setSubmitted_date(Date submitted_date) {
		this.submitted_date = submitted_date;
	}
	
	
	
}
