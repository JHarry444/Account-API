package com.qa.account.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.account.persistence.domain.Account;
import com.qa.account.service.AccountService;

@RestController
public class AccountController {

	
	private AccountService service;

	public AccountController(AccountService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/register")
	public Account register(@RequestBody Account newAccount) {
		return this.service.addAccount(newAccount);
	}
}
