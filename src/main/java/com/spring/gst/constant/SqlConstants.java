package com.spring.gst.constant;

public class SqlConstants {

	private SqlConstants(){}
	
	public static final String UPDATE_SQL = "UPDATE user SET name = ?,username = ?,password = ?,email = ?,mobile = ?,role = ?,business_id = ? WHERE id = ?";
	public static final String DELETE_SQL = "UPDATE user SET is_deleted = 'Y' WHERE id = ?";
	public static final String INSERT_SQL = "INSERT INTO user(name,username,password,email,mobile,role,business_id) VALUES(?,?,?,?,?,?,?)";
	public static final String SELECT_SQL = "SELECT * FROM \"user\" WHERE is_deleted='N' ";
	public static final String SELECT_INVOICES_SQL = "SELECT * FROM \"b2b_invoice_gstr1\" ";
	public static final String INSERT_B2B_INVOICE_SQL = "INSERT INTO b2b_invoice_gstr1(invoice_num, invoice_date, invoice_value, place_of_supply, reverse_charge, provisional_assessment, order_no, order_date, e_commerce_gstin,item_serial_no, item_type, item_hsn_sac_code, item_taxable_value, item_igst_rate, item_igst_amount, item_cgst_rate, item_cgst_amount, item_sgst_rate, item_sgst_amount, item_cess_rate, item_cess_amount, gstr1_id, gstin) "
														+ "	VALUES (?, to_timestamp(?, 'DD/MM/YYYY HH24:MI:SS'), ?, ?, ?, ?, ?, to_timestamp(?, 'DD/MM/YYYY HH24:MI:SS'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String DELETE_B2B_INVOICE_SQL = "DELETE FROM b2b_invoice_gstr1 where gstr1_id IN (SELECT id FROM GSTR1 where status = 'Pending' ) AND invoice_num =? AND item_serial_no=?";			
	
	public static final String SELECT_INVOICES_SQL1 = "SELECT * FROM b2b_invoice_gstr1_new ";
	public static final String SELECT_INVOICES_SQL2 = "SELECT * FROM invoice_items ";
	public static final String SELECT_INVOICES_SQL3 = "SELECT type,hsn_sac_code FROM items WHERE id = ?";
	public static final String INSERT_B2B_INVOICE_SQL1 = "INSERT INTO b2b_invoice_gstr1_new(invoice_num, invoice_date, invoice_value, place_of_supply, reverse_charge, provisional_assessment, order_no, order_date, e_commerce_gstin,taxable_value,igst_amount,cgst_amount,sgst_amount,cess_amount, gstr1_id, gstin) "
			+ "	VALUES (?, to_date(?, 'DD-MM-YYYY'), ?, ?, ?, ?, ?, to_date(?, 'DD-MM-YYYY'), ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String INSERT_B2B_INVOICE_SQL2 = "INSERT INTO invoice_items(invoice_num, serial_no, item_id, taxable_value, igst_rate, igst_amount, cgst_rate, cgst_amount,sgst_rate, sgst_amount,cess_rate,cess_amount ) "
			+ "	VALUES (?, ?, (SELECT id FROM items WHERE type = ? AND hsn_sac_code = ?), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String DELETE_B2B_INVOICE_SQL1 = "DELETE FROM b2b_invoice_gstr1_new WHERE gstr1_id IN (SELECT id FROM gstr1 WHERE status = 'Pending' ) AND invoice_num = ?";
	
}
