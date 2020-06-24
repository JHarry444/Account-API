package com.qa.account.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.account.persistence.domain.Account;
import com.qa.account.persistence.repo.AccountRepo;
import com.qa.account.util.exceptions.AccountNotFoundException;

@Service
public class AccountService {

	private AccountRepo repo;
	private AccountNumGenService numGen;
	private PrizeGenService prizeGen;

	public AccountService(AccountRepo repo, AccountNumGenService numGen, PrizeGenService prizeGen) {
		super();
		this.repo = repo;
		this.numGen = numGen;
		this.prizeGen = prizeGen;
	}

	public List<Account> getAccounts() {
		return repo.findAll();
	}

	public Account getAccount(Long id) {
		return repo.findById(id).orElseThrow(() -> new AccountNotFoundException(id.toString()));

	}

	public Account addAccount(Account account) {
		account.setAccountNumber(this.numGen.genNumber());
		account.setPrize(prizeGen.genPrize(account.getAccountNumber()));
		return this.repo.save(account);
	}

	public boolean deleteAccount(Long id) {
		if (accountExists(id)) {
			repo.deleteById(id);
		}
		return repo.existsById(id);
	}

	private boolean accountExists(Long id) {
		return repo.findById(id).isPresent();
	}

	public Account updateAccount(Account account, Long id) {
		if (accountExists(id)) {
			Account toUpdate = this.repo.findById(id).get();
			toUpdate.setFirstName(account.getFirstName());
			toUpdate.setLastName(account.getLastName());
			return repo.save(account);
		}
		return null;
	}

}
