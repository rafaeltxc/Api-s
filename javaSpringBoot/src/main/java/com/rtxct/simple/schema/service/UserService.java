package com.rtxct.simple.schema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rtxct.simple.schema.model.UserModel;
import com.rtxct.simple.schema.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<UserModel> findAll() {
		return repository.findAll();
	}
	
	public UserModel findById(Long id) {
		return repository.findById(id).get();
	}
	
	public UserModel saveOne(UserModel model) {
		return repository.save(model);
	}
	
	public UserModel updateOne(UserModel model, Long id) {
		UserModel user = repository.findById(id).get();
		
		model.setUserId(id);
		if (model.getUserFirstName() == null || model.getUserFirstName().isEmpty()) model.setUserFirstName(user.getUserFirstName());
		if (model.getUserLastName() == null || model.getUserLastName().isEmpty()) model.setUserLastName(user.getUserLastName());
		if (model.getUserBirth() == null || model.getUserCountry().isEmpty()) model.setUserBirth(user.getUserBirth());
		if (model.getUserCountry() == null || model.getUserCountry().isEmpty()) model.setUserCountry(user.getUserCountry());
		
		return repository.save(model);
	}
	
	public void deleteOne(Long id) {
		repository.deleteById(id);
	}

}
