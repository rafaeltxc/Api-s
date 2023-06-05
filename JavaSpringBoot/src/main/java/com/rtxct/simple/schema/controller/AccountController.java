package com.rtxct.simple.schema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rtxct.simple.schema.model.AccountModel;
import com.rtxct.simple.schema.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	@GetMapping("/")
	public List<AccountModel> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public AccountModel findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping("/")
	public AccountModel saveOne(@RequestBody AccountModel model) {
		return service.saveOne(model);
	}
	
	@PutMapping("/{id}")
	public AccountModel updateOne(@RequestBody AccountModel model, @PathVariable("id") Long id) {
		return service.updateOne(model, id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteOne(@PathVariable("id") Long id) {
		service.deleteOne(id);
		return "Deleted with success";
	}

}
