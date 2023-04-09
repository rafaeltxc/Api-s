package com.api.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import com.api.bean.Account;
import com.api.connection.Connection;
import com.api.repository.AccountInterface;

public class AccountDAO implements AccountInterface {

	Account ac;
	java.sql.Connection conn;
	
	public ArrayList<Account> doGet() {
		ArrayList<Account> acList = new ArrayList<>();
		
		try {
			conn = Connection.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tbl_account");
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Account ac = new Account();
				Calendar clInstance = Calendar.getInstance();
				Date sqlDate = rs.getDate("account_creation_date");
				clInstance.setTime(sqlDate);
				
				ac.setAccountId(rs.getInt("account_id"));
				ac.setAccountTotalMoney(rs.getBigDecimal("account_total_money"));
				ac.setAccountCreationDate(clInstance);
				ac.setUserfK(rs.getInt("fk_tbl_user_tbl_account"));
				ac.setBankfk(rs.getInt("fk_tbl_bank_tbl_account"));
				acList.add(ac);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return acList;
	}
	
	public Account doGetById(int id) {
		try {
			conn = Connection.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tbl_account WHERE account_id=?");
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int accountId = rs.getInt("account_id");
				BigDecimal totalMoney = rs.getBigDecimal("account_total_money");
				int userFk = rs.getInt("fk_tbl_user_tbl_account");
				int bankFk = rs.getInt("fk_tbl_bank_tbl_account");
				
				Calendar clInstance = Calendar.getInstance();
				Date sqlDate = rs.getDate("account_creation_date");
				clInstance.setTime(sqlDate);
				ac = new Account(accountId, totalMoney, clInstance, userFk, bankFk);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ac;
	}
	
	public int doUpdate(int id, Account ac) {
		try {
			conn = Connection.getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE tbl_account SET "
					+ "account_total_money=? "
					+ "WHERE account_id=?");
			
			stmt.setBigDecimal(1, ac.getAccountTotalMoney());
			stmt.setInt(2, id);
			return stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int doPost(Account ac) {
		try {
			conn = Connection.getConnection();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO tbl_account"
					+ "(account_total_money, account_creation_date, fk_tbl_user_tbl_account, fk_tbl_bank_tbl_account) "
					+ "VALUES (?, ?, ?, ?)");
			
			stmt.setBigDecimal(1, ac.getAccountTotalMoney());
			stmt.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
			stmt.setInt(3, ac.getUserfK());
			stmt.setInt(4, ac.getBankfk());
			return stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int doDelete(int id) {
		try {
			conn = Connection.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM tbl_account WHERE account_id=?");
			stmt.setInt(1, id);
			return stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
