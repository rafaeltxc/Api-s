package com.api.vanillaJava;

import java.math.BigDecimal;
import java.util.Calendar;

import com.api.bean.Account;
import com.api.bean.Bank;
import com.api.bean.User;
import com.api.dao.AccountDAO;
import com.api.dao.BankDAO;
import com.api.dao.UserDAO;

public class App {
	
    public static void main( String[] args ) {
    	// DataBase population
    	// Users
    	UserDAO userDao = new UserDAO();
    	User u1 = new User();
    	User u2 = new User();
    	User u3 = new User();
    	
    	Calendar instance = Calendar.getInstance();

    	u1.setUserFirstName("user-1");
    	u1.setUserLastName("user-1");
    	u1.setUserBirth(instance);
    	u1.setUserCountry("Brazil");
    	
    	u2.setUserFirstName("user-2");
    	u2.setUserLastName("user-2");
    	u2.setUserBirth(instance);
    	u2.setUserCountry("France");
    	
    	u3.setUserFirstName("user-3");
    	u3.setUserLastName("user-3");
    	u3.setUserBirth(instance);
    	u3.setUserCountry("Canada");
    	
    	userDao.doPost(u1);
    	userDao.doPost(u2);
    	userDao.doPost(u3);
    	
    	// Banks
    	BankDAO bankDao = new BankDAO();
    	Bank b1 = new Bank();
    	Bank b2 = new Bank();
    	Bank b3 = new Bank();
    	
    	b1.setBankName("bank-1");
    	
    	b2.setBankName("bank-2");
    	
    	b3.setBankName("bank-3");
    	
    	bankDao.doPost(b1);
    	bankDao.doPost(b2);
    	bankDao.doPost(b3);
    	
    	// Accounts
    	AccountDAO accDao = new AccountDAO();
    	Account acc1 = new Account();
    	Account acc2 = new Account();
    	Account acc3 = new Account();
    	
    	acc1.setAccountTotalMoney(new BigDecimal(5000));
    	acc1.setUserfK(1);
    	acc1.setBankfk(1);
    	
    	acc2.setAccountTotalMoney(new BigDecimal(10000));
    	acc2.setUserfK(2);
    	acc2.setBankfk(2);
    	
    	acc3.setAccountTotalMoney(new BigDecimal(1000));
    	acc3.setUserfK(3);
    	acc3.setBankfk(3);
    	
    	accDao.doPost(acc1);
    	accDao.doPost(acc2);
    	accDao.doPost(acc3);
    }
}
