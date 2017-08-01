package com.spring.gst.model;

import java.io.Serializable;

public class InvoiceItemNw implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String invoice_num;
	private int serial_no;
	private int item_id;
	private String item_type;
	private String hsn_sac_code;
	private Double taxable_value;
	private Double igst_rate;
	private Double igst_amount;
	private Double cgst_rate;
	private Double cgst_amount;
	private Double sgst_rate;
	private Double sgst_amount;
	private Double cess_rate;
	private Double cess_amount;


	public String getInvoice_num() {
		return invoice_num;
	}
	public void setInvoice_num(String invoice_num) {
		this.invoice_num = invoice_num;
	}
	public int getSerial_no() {
		return serial_no;
	}
	public void setSerial_no(int serial_no) {
		this.serial_no = serial_no;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public Double getTaxable_value() {
		return taxable_value;
	}
	public void setTaxable_value(Double taxable_value) {
		this.taxable_value = taxable_value;
	}
	public Double getIgst_rate() {
		return igst_rate;
	}
	public void setIgst_rate(Double igst_rate) {
		this.igst_rate = igst_rate;
	}
	public Double getIgst_amount() {
		return igst_amount;
	}
	public void setIgst_amount(Double igst_amount) {
		this.igst_amount = igst_amount;
	}
	public Double getCgst_rate() {
		return cgst_rate;
	}
	public void setCgst_rate(Double cgst_rate) {
		this.cgst_rate = cgst_rate;
	}
	public Double getCgst_amount() {
		return cgst_amount;
	}
	public void setCgst_amount(Double cgst_amount) {
		this.cgst_amount = cgst_amount;
	}
	public Double getSgst_rate() {
		return sgst_rate;
	}
	public void setSgst_rate(Double sgst_rate) {
		this.sgst_rate = sgst_rate;
	}
	public Double getSgst_amount() {
		return sgst_amount;
	}
	public void setSgst_amount(Double sgst_amount) {
		this.sgst_amount = sgst_amount;
	}
	public Double getCess_rate() {
		return cess_rate;
	}
	public void setCess_rate(Double cess_rate) {
		this.cess_rate = cess_rate;
	}
	public Double getCess_amount() {
		return cess_amount;
	}
	public void setCess_amount(Double cess_amount) {
		this.cess_amount = cess_amount;
	}

	public String getItem_type() {
		return item_type;
	}
	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}
	public String getHsn_sac_code() {
		return hsn_sac_code;
	}
	public void setHsn_sac_code(String hsn_sac_code) {
		this.hsn_sac_code = hsn_sac_code;
	}
	

}
