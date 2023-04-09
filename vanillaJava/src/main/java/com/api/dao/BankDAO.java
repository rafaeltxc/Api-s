package com.api.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.api.bean.Bank;
import com.api.connection.Connection;
import com.api.repository.BankInterface;

public class BankDAO implements BankInterface {

	Bank b;
	java.sql.Connection conn;
	
	public ArrayList<Bank> doGet() {
		ArrayList<Bank> bList = new ArrayList<>();
		
		try {
			conn = Connection.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tbl_bank");
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Bank b = new Bank();
				b.setBankId(rs.getInt("bank_id"));
				b.setBankName(rs.getString("bank_name"));
				bList.add(b);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bList;
	}
	
	public Bank doGetById(int id) {
		try {
			conn = Connection.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tbl_bank WHERE bank_id=?");
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int bankId = rs.getInt("bank_id");
				String bankName = rs.getString("bank_name");
				
				b = new Bank(bankId, bankName);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public int doUpdate(int id, Bank b) {
		try {
			conn = Connection.getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE tbl_bank SET "
					+ "bank_name=?"
					+ "WHERE bank_id=?");
			stmt.setString(1, b.getBankName());
			stmt.setInt(2, id);
			return stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int doPost(Bank b) {
		try {
			conn = Connection.getConnection();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO tbl_bank (bank_name) VALUES (?)");
			stmt.setString(1, b.getBankName());
			return stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int doDelete(int id) {
		try {
			conn = Connection.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM tbl_bank WHERE bank_id=?");
			stmt.setInt(1, id);
			return stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
