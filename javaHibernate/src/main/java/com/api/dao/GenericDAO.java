package com.api.dao;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.api.hibernate.App;

public abstract class GenericDAO<T, K> {
	
	protected EntityManager em = App.em();
	
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAO() {
		clazz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public List<T> doGet() {
		try {
			return em.createQuery("from " + clazz.getName(), clazz).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public T doGetById(K key) {
		try {
			return em.find(clazz, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void doUpdate(K key, T type) {
		if(doGetById(key) != null) {
			em.merge(type);
		}
	}
	
	public void doPost(T type) {
		em.persist(type);
	}
	
	public void doRemove(K key) {
		T entity = doGetById(key);
		if(entity != null) {
			em.remove(entity);
		}
	}
	
	public void doCommit() throws Exception {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			throw new Exception("Could not commit");
		}
	}
	
}
