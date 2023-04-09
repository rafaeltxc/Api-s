package com.api.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.api.bean.User;
import com.api.connection.Connection;
import com.api.repository.UserInterface;

public class UserDAO implements UserInterface {

	private User u;
	private java.sql.Connection conn;
	
	public ArrayList<User> doGet() {
		ArrayList<User> uList = new ArrayList<>();

		try {
			conn = Connection.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tbl_user");
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				User u = new User();
				Calendar clInstance = Calendar.getInstance();
				Date sqlDate = rs.getDate("user_birth");
				clInstance.setTime(sqlDate);

				u.setUserId(rs.getInt("user_id"));
				u.setUserFirstName(rs.getString("user_first_name"));
				u.setUserLastName(rs.getString("user_last_name"));
				u.setUserBirth(clInstance);
				u.setUserCountry(rs.getString("user_country"));
				uList.add(u);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return uList;
	}
	
	public User doGetById(int id) {
		try {
			conn = Connection.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tbl_user WHERE user_id = ?");
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int userId = rs.getInt("user_id");
				String userFirstName = rs.getString("user_first_name");
				String userLastName = rs.getString("user_last_name");
				Date userBirth = rs.getDate("user_birth");
				String userCountry = rs.getString("user_birth");
				
				Calendar clInstance = Calendar.getInstance();
				clInstance.setTime(userBirth);
				u = new User(userId, userFirstName, userLastName, clInstance, userCountry);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
	public int doUpdate(int id, User u) {
		try {
			conn = Connection.getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE tbl_user SET "
					+ "user_first_name=?,"
					+ "user_last_name=?,"
					+ "user_birth=?,"
					+ "user_country=?"
					+ "WHERE user_id=?");
			
			Date date = new Date(u.getUserBirth().getTimeInMillis());
			stmt.setString(1, u.getUserFirstName());
			stmt.setString(2, u.getUserLastName());
			stmt.setDate(3, date);
			stmt.setString(4, u.getUserCountry());
			stmt.setInt(5, id);
			
			return stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int doPost(User u) {
		try {
			conn = Connection.getConnection();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO "
					+ "tbl_user (user_first_name, user_last_name, user_birth, user_country) "
					+ "VALUES (?, ?, ?, ?)");
			
			Date date = new Date(u.getUserBirth().getTimeInMillis());
			stmt.setString(1, u.getUserFirstName());
			stmt.setString(2, u.getUserLastName());
			stmt.setDate(3, date);
			stmt.setString(4, u.getUserCountry());
			
			return stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int doDelete(int id) {
		try {
			conn = Connection.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM tbl_user WHERE user_id=?");
			stmt.setInt(1, id);
			return stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
