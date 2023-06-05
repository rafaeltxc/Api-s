package com.rtxct.simple.schema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rtxct.simple.schema.model.BankModel;
import com.rtxct.simple.schema.repository.BankRepository;

@Service
public class BankService {
	
	@Autowired
	private BankRepository repository;
	
	public List<BankModel> findAll() {
		return repository.findAll();
	}

	public BankModel findById(Long id) {
		return repository.findById(id).get();
	}
	
	public BankModel saveOne(BankModel model) {
		return repository.save(model);
	}
	
	public BankModel updateOne(BankModel model, Long id) {
		BankModel bank = repository.findById(id).get();
	
		model.setBankId(id);
		if (model.getBankName() == null || model.getBankName().isEmpty()) model.setBankName(bank.getBankName());
		
		return repository.save(model);
	}
	
	public void deleteOne(Long id) {
		repository.deleteById(id);
	}
	
}
