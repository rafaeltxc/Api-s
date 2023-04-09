package com.api.repository;

import java.util.ArrayList;

import com.api.bean.User;

public interface UserInterface {

	ArrayList<User> doGet();
	
	User doGetById(int id);
	
	int doUpdate(int id, User ac);
	
	int doPost(User ac);
	
	int doDelete(int id);
	
}
