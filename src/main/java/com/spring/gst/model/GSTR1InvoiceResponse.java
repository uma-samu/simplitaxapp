package com.spring.gst.model;

import java.io.Serializable;
import java.util.List;

public class GSTR1InvoiceResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String success;
	private List<GSTR1_Invoice> invoices;
	private String error="";
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public List<GSTR1_Invoice> getInvoices() {
		return invoices;
	}
	public void setInvoices(List<GSTR1_Invoice> invoices) {
		this.invoices = invoices;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	

}
