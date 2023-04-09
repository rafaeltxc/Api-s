package com.api.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class App {
	
	private static EntityManager instance;
	
	private App() {}
	
    public static EntityManager em() {
    	try {
        	EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
			instance = factory.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return instance;
    }
}
