package com.qa.account.service;

import org.springframework.stereotype.Service;

import com.qa.account.util.NumberGenerator;

@Service
public class AccountNumGenService {

	private NumberGenerator numGen;

	public AccountNumGenService(NumberGenerator numGen) {
		this.numGen = numGen;
	}

	public String genNumber() {
		return this.numGen.genNumber();
	}

}
