package com.rtxct.simple.schema.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rtxct.simple.schema.model.AccountModel;
import com.rtxct.simple.schema.model.BankModel;
import com.rtxct.simple.schema.model.UserModel;
import com.rtxct.simple.schema.repository.AccountRepository;
import com.rtxct.simple.schema.repository.BankRepository;
import com.rtxct.simple.schema.repository.UserRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BankRepository bankRepository;

	public List<AccountModel> findAll() {
		return accountRepository.findAll();
	}

	public AccountModel findById(Long id) {
		return accountRepository.findById(id).get();
	}
	
	public AccountModel saveOne(AccountModel model) {
		Calendar calInstance = Calendar.getInstance();
		model.setAccountCreationDate(calInstance.getTime());
		
		UserModel user = userRepository.findById(model.getFkUser().getUserId()).get();
		model.setFkUser(user);
		
		BankModel bank = bankRepository.findById(model.getFkBank().getBankId()).get();
		model.setFkBank(bank);
		
		return accountRepository.save(model);
	}
	
	public AccountModel updateOne(AccountModel model, Long id) {
		AccountModel account = accountRepository.findById(id).get();
		
		model.setAccountId(id);
		if (model.getAccountTotalMoney() == null) model.setAccountTotalMoney(account.getAccountTotalMoney());
		model.setAccountCreationDate(account.getAccountCreationDate());
		model.setFkUser(account.getFkUser());
		model.setFkBank(account.getFkBank());
		
		return accountRepository.save(model);
	}
	
	public void deleteOne(Long id) {
		accountRepository.deleteById(id);
	}
	
}
