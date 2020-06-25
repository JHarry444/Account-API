package com.qa.account.services;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.account.persistence.domain.Account;
import com.qa.account.persistence.repo.AccountRepo;
import com.qa.account.service.AccountNumGenService;
import com.qa.account.service.AccountService;
import com.qa.account.service.PrizeGenService;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceUnitTest {

	private Account testAccount;

	private Account savedAccount;
	
	@Mock
	private AccountRepo repo;

	@Mock
	private AccountNumGenService numGen;

	@Mock
	private PrizeGenService prizeGen;

	@InjectMocks
	private AccountService service;

	@Before
	public void init() {
		this.testAccount = new Account("J", "H");
		this.savedAccount = new Account(testAccount.getFirstName(), testAccount.getLastName());
		savedAccount.setId(1L);
	}

	@Test
	public void testRegister() {
		final String accountNum = "a123456";
		final double prize = 44.94;
		this.savedAccount.setAccountNumber(accountNum);
		this.savedAccount.setPrize(prize);
		Account accWithNumberAndPrizeButNoID = new Account(testAccount.getFirstName(), testAccount.getLastName(), accountNum, prize);
		
		Mockito.when(this.numGen.genNumber()).thenReturn(accountNum);
		Mockito.when(this.prizeGen.genPrize(accountNum)).thenReturn(prize);
		Mockito.when(this.repo.save(accWithNumberAndPrizeButNoID)).thenReturn(this.savedAccount);

		assertEquals(this.savedAccount, this.service.addAccount(testAccount));
		
		Mockito.verify(this.numGen, Mockito.times(1)).genNumber();
		Mockito.verify(this.prizeGen, Mockito.times(1)).genPrize(accountNum);
		Mockito.verify(this.repo, Mockito.times(1)).save(accWithNumberAndPrizeButNoID);
	}

}
