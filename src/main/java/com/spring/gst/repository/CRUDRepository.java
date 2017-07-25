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

import com.spring.gst.model.User;

@Repository
public class CRUDRepository implements ICRUDRepository {

	private static final String updateSql = "UPDATE user SET name = ?,username = ?,password = ?,email = ?,mobile = ?,role = ?,business_id = ? WHERE id = ?";
	private static final String deleteSql = "UPDATE user SET is_deleted = 'Y' WHERE id = ?";
	private static final String insertSql = "INSERT INTO user(name,username,password,email,mobile,role,business_id) VALUES(?,?,?,?,?,?,?)";
	private static final String selectSql = "SELECT * FROM user WHERE is_deleted='N' ";
			
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

}
