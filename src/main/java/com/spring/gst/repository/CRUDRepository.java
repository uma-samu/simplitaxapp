package com.spring.gst.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.gst.model.GSTR1_Invoice;
import com.spring.gst.model.User;

@Repository
public class CRUDRepository implements ICRUDRepository {

	private static final String updateSql = "UPDATE user SET name = ?,username = ?,password = ?,email = ?,mobile = ?,role = ?,business_id = ? WHERE id = ?";
	private static final String deleteSql = "UPDATE user SET is_deleted = 'Y' WHERE id = ?";
	private static final String insertSql = "INSERT INTO user(name,username,password,email,mobile,role,business_id) VALUES(?,?,?,?,?,?,?)";
	private static final String selectSql = "SELECT * FROM \"user\" WHERE is_deleted='N' ";
	private static final String selectInvoicesSql = "SELECT * FROM \"b2b_invoice_gstr1\" ";
	private static final String INSERT_B2B_INVOICE_SQL = "INSERT INTO b2b_invoice_gstr1(invoice_num, invoice_date, invoice_value, place_of_supply, reverse_charge, provisional_assessment, order_no, order_date, e_commerce_gstin,item_serial_no, item_type, item_hsn_sac_code, item_taxable_value, item_igst_rate, item_igst_amount, item_cgst_rate, item_cgst_amount, item_sgst_rate, item_sgst_amount, item_cess_rate, item_cess_amount, gstr1_id, gstin) "
														+ "	VALUES (?, to_timestamp(?, 'DD/MM/YYYY HH24:MI:SS'), ?, ?, ?, ?, ?, to_timestamp(?, 'DD/MM/YYYY HH24:MI:SS'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String DELETE_B2B_INVOICE_SQL = "DELETE FROM b2b_invoice_gstr1 where gstr1_id IN (SELECT id FROM GSRT1 where status =\"Pending\" ) AND invoice_num =? AND item_serial_no=?";			
	@Autowired
	@Qualifier("mysqlTemplate")
	private JdbcTemplate jdbc;
	
	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		users = jdbc.query(selectSql, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User dbUser = new User();
				dbUser.setId(String.valueOf(rs.getInt("id")));
				dbUser.setName(rs.getString("name"));
				dbUser.setUsername(rs.getString("username"));
				dbUser.setPassword(rs.getString("password"));
				dbUser.setEmail(rs.getString("email"));
				dbUser.setMobile(rs.getString("mobile"));
				dbUser.setRole(rs.getString("role"));
				dbUser.setBusinessId(rs.getString("business_id"));
				
				return dbUser;
			}
			
		});
		return users;
	}

	@Override
	public int addUser(User user) {
		int rows = jdbc.update(insertSql, new Object[]{user.getName(),user.getUsername(),user.getPassword(),user.getEmail(),user.getMobile(),user.getRole(),user.getBusinessId()});
		return rows;
	}

	@Override
	public int updateUser(User user) {
		int rows = jdbc.update(updateSql, new Object[]{user.getName(),user.getUsername(),user.getPassword(),user.getEmail(),user.getMobile(),user.getRole(),user.getBusinessId(),user.getId()});
		return rows;
	}

	@Override
	public int deleteUser(String id) {
		int rows = jdbc.update(deleteSql, new Object[]{id});
		return rows;
	}

	@Override
	public List<GSTR1_Invoice> getAllB2bs() {
		// TODO Auto-generated method stub
		
		List<GSTR1_Invoice> invoices = new ArrayList<GSTR1_Invoice>();
		invoices = jdbc.query(selectInvoicesSql, new RowMapper<GSTR1_Invoice>(){

			@Override
			public GSTR1_Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
				GSTR1_Invoice invoice = new GSTR1_Invoice();
				invoice.setGstin(rs.getString("gstin"));
				invoice.setInvoice_num(rs.getString("invoice_num"));
				invoice.setInvoice_date(String.valueOf(rs.getDate("invoice_date")));
				invoice.setInvoice_value(String.valueOf(rs.getDouble("invoice_value")));
				invoice.setPlace_of_supply(String.valueOf(rs.getInt("place_of_supply")));
				invoice.setReverse_charge(rs.getString("reverse_charge"));
				invoice.setProvisional_assessment(rs.getString("provisional_assessment"));
				invoice.setOrder_no(rs.getString("order_no"));
				invoice.setOrder_date(String.valueOf(rs.getDate("order_date")));
				invoice.setE_commerce_gstin(rs.getString("e_commerce_gstin"));
				invoice.setItem_serial_no(String.valueOf(rs.getInt("item_serial_no")));
				invoice.setItem_type(rs.getString("item_type"));
				invoice.setItem_hsn_sac_code(rs.getString("item_hsn_sac_code"));
				invoice.setItem_taxable_value(String.valueOf(rs.getDouble("item_taxable_value")));
				invoice.setItem_igst_rate(String.valueOf(rs.getDouble("item_igst_rate")));
				invoice.setItem_igst_amount(String.valueOf(rs.getDouble("item_igst_amount")));
				invoice.setItem_cgst_rate(String.valueOf(rs.getDouble("item_cgst_rate")));
				invoice.setItem_cgst_amount(String.valueOf(rs.getDouble("item_cgst_amount")));
				invoice.setItem_sgst_rate(String.valueOf(rs.getDouble("item_sgst_rate")));
				invoice.setItem_sgst_amount(String.valueOf(rs.getDouble("item_sgst_amount")));
				invoice.setItem_cess_rate(String.valueOf(rs.getDouble("item_cess_rate")));
				invoice.setItem_cess_amount(String.valueOf(rs.getDouble("item_cess_amount")));
				invoice.setGstr1_id(rs.getString("gstr1_id"));
				
				return invoice;
			}
			
		});
		return invoices;
	}
	@Override
	@Transactional
	public int addB2b(GSTR1_Invoice invoice) {	
		int row = jdbc.update(INSERT_B2B_INVOICE_SQL, new Object[]{invoice.getInvoice_num(),invoice.getInvoice_date(),Double.parseDouble(invoice.getInvoice_value()),Integer.parseInt(invoice.getPlace_of_supply()),invoice.getReverse_charge(),invoice.getProvisional_assessment(),
																	  invoice.getOrder_no(),invoice.getOrder_date(),invoice.getE_commerce_gstin(),Integer.parseInt(invoice.getItem_serial_no()),invoice.getItem_type(),invoice.getItem_hsn_sac_code(),Double.parseDouble(invoice.getItem_taxable_value()),
																	  Double.parseDouble(invoice.getItem_igst_rate()),Double.parseDouble(invoice.getItem_igst_amount()),Double.parseDouble(invoice.getItem_cgst_rate()),Double.parseDouble(invoice.getItem_cgst_amount()),Double.parseDouble(invoice.getItem_sgst_rate()),Double.parseDouble(invoice.getItem_sgst_amount()),
																	  Double.parseDouble(invoice.getItem_cess_rate()),Double.parseDouble(invoice.getItem_cess_amount()),Integer.parseInt(invoice.getGstr1_id()),invoice.getGstin()});	
		return row;
	}
	
	public int removeB2b(String invoiceNum,String itemSerialNo)
	{
		int row = jdbc.update(DELETE_B2B_INVOICE_SQL,new Object[]{invoiceNum, itemSerialNo,});
		return row;
	}

	@Override
	public List<GSTR1_Invoice> getB2bsByCriteria(String criteria,String value) {
		List<GSTR1_Invoice> invoices = new ArrayList<GSTR1_Invoice>();
		invoices = jdbc.query(selectInvoicesSql+"where "+criteria+" = '"+value+"'", new RowMapper<GSTR1_Invoice>(){

			@Override
			public GSTR1_Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
				GSTR1_Invoice invoice = new GSTR1_Invoice();
				invoice.setGstin(rs.getString("gstin"));
				invoice.setInvoice_num(rs.getString("invoice_num"));
				invoice.setInvoice_date(String.valueOf(rs.getDate("invoice_date")));
				invoice.setInvoice_value(String.valueOf(rs.getDouble("invoice_value")));
				invoice.setPlace_of_supply(String.valueOf(rs.getInt("place_of_supply")));
				invoice.setReverse_charge(rs.getString("reverse_charge"));
				invoice.setProvisional_assessment(rs.getString("provisional_assessment"));
				invoice.setOrder_no(rs.getString("order_no"));
				invoice.setOrder_date(String.valueOf(rs.getDate("order_date")));
				invoice.setE_commerce_gstin(rs.getString("e_commerce_gstin"));
				invoice.setItem_serial_no(String.valueOf(rs.getInt("item_serial_no")));
				invoice.setItem_type(rs.getString("item_type"));
				invoice.setItem_hsn_sac_code(rs.getString("item_hsn_sac_code"));
				invoice.setItem_taxable_value(String.valueOf(rs.getDouble("item_taxable_value")));
				invoice.setItem_igst_rate(String.valueOf(rs.getDouble("item_igst_rate")));
				invoice.setItem_igst_amount(String.valueOf(rs.getDouble("item_igst_amount")));
				invoice.setItem_cgst_rate(String.valueOf(rs.getDouble("item_cgst_rate")));
				invoice.setItem_cgst_amount(String.valueOf(rs.getDouble("item_cgst_amount")));
				invoice.setItem_sgst_rate(String.valueOf(rs.getDouble("item_sgst_rate")));
				invoice.setItem_sgst_amount(String.valueOf(rs.getDouble("item_sgst_amount")));
				invoice.setItem_cess_rate(String.valueOf(rs.getDouble("item_cess_rate")));
				invoice.setItem_cess_amount(String.valueOf(rs.getDouble("item_cess_amount")));
				invoice.setGstr1_id(rs.getString("gstr1_id"));
				
				return invoice;
			}
		});
		return invoices;
	}

	
}

	
