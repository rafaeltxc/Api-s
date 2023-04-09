package com.api.factory;

import com.api.dao.AccountDAO;
import com.api.dao.BankDAO;
import com.api.dao.UserDAO;

public class Factory {

	public static UserDAO user() {
		return new UserDAO();
	}
	
	public static BankDAO bank() {
		return new BankDAO();
	}
	
	public static AccountDAO account() {
		return new AccountDAO();
	}
	
}
