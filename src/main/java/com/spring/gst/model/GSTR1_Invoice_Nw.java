package com.spring.gst.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonFormat;


public class GSTR1_Invoice_Nw implements Serializable{


	private static final long serialVersionUID = 1L;
	
	
	private String invoice_num;
	private int gstr1_id;
	private String gstin;
	private String invoice_Date;
	private Double invoice_Value;
	private int place_of_supply;
	private String reverse_charge;
	private String provisional_assessment;
	private String order_no;
	private String order_date;
	private String e_commerce_gstin;
	private Double taxable_value;
	private Double igst_amount;
	private Double cgst_amount;
	private Double sgst_amount;
	private Double cess_amount;

	private List<InvoiceItemNw> items;
	
	public String getInvoice_num() {
		return invoice_num;
	}
	public void setInvoice_num(String invoice_num) {
		this.invoice_num = invoice_num;
	}
	public int getGstr1_id() {
		return gstr1_id;
	}
	public void setGstr1_id(int gstr1_id) {
		this.gstr1_id = gstr1_id;
	}
	public String getGstin() {
		return gstin;
	}
	public void setGstin(String gstin) {
		this.gstin = gstin;
	}
	public String getInvoice_Date() {
		return invoice_Date;
	}
	public void setInvoice_Date(String invoice_Date) {
		this.invoice_Date = invoice_Date;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	
	public Double getInvoice_Value() {
		return invoice_Value;
	}
	public void setInvoice_Value(Double invoice_Value) {
		this.invoice_Value = invoice_Value;
	}
	public int getPlace_of_supply() {
		return place_of_supply;
	}
	public void setPlace_of_supply(int place_of_supply) {
		this.place_of_supply = place_of_supply;
	}
	public String getReverse_charge() {
		return reverse_charge;
	}
	public void setReverse_charge(String reverse_charge) {
		this.reverse_charge = reverse_charge;
	}
	public String getProvisional_assessment() {
		return provisional_assessment;
	}
	public void setProvisional_assessment(String provisional_assessment) {
		this.provisional_assessment = provisional_assessment;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getE_commerce_gstin() {
		return e_commerce_gstin;
	}
	public void setE_commerce_gstin(String e_commerce_gstin) {
		this.e_commerce_gstin = e_commerce_gstin;
	}
	public Double getTaxable_value() {
		return taxable_value;
	}
	public void setTaxable_value(Double taxable_value) {
		this.taxable_value = taxable_value;
	}
	public Double getIgst_amount() {
		return igst_amount;
	}
	public void setIgst_amount(Double igst_amount) {
		this.igst_amount = igst_amount;
	}
	public Double getCgst_amount() {
		return cgst_amount;
	}
	public void setCgst_amount(Double cgst_amount) {
		this.cgst_amount = cgst_amount;
	}
	public Double getSgst_amount() {
		return sgst_amount;
	}
	public void setSgst_amount(Double sgst_amount) {
		this.sgst_amount = sgst_amount;
	}
	public Double getCess_amount() {
		return cess_amount;
	}
	public void setCess_amount(Double cess_amount) {
		this.cess_amount = cess_amount;
	}
	public List<InvoiceItemNw> getItems() {
		return items;
	}
	public void setItems(List<InvoiceItemNw> items) {
		this.items = items;
	}

	
}
