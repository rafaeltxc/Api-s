package com.api.repository;

import java.util.ArrayList;

import com.api.bean.Account;

public interface AccountInterface {

	ArrayList<Account> doGet();
	
	Account doGetById(int id);
	
	int doUpdate(int id, Account ac);
	
	int doPost(Account ac);
	
	int doDelete(int id);
	
}
