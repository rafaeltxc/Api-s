package com.api.repository;

import java.util.ArrayList;

import com.api.bean.Bank;

public interface BankInterface {

	ArrayList<Bank> doGet();
	
	Bank doGetById(int id);
	
	int doUpdate(int id, Bank ac);
	
	int doPost(Bank ac);
	
	int doDelete(int id);
	
}
