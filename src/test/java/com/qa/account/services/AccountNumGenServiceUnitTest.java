package com.qa.account.services;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qa.account.service.AccountNumGenService;

@RunWith(SpringJUnit4ClassRunner.class)
public class AccountNumGenServiceUnitTest {

	private AccountNumGenService numGen = new AccountNumGenService();

	@Test
	public void testGenNumber() {
		String accountNum;

		for (int i = 0; i < 100; i++) {
			accountNum = numGen.genNumber();
			char firstChar = accountNum.charAt(0);
			assertTrue("Incorrect start charact", firstChar == 'a' || firstChar == 'b' || firstChar == 'c');
			assertTrue("Incorrect length", accountNum.length() == 7 || accountNum.length() == 9 || accountNum.length() == 11);
			// regex version
			assertTrue("Incorrect account number", accountNum.matches("[abc](\\d{10}|\\d{8}|[0-9]{6})"));
		}
	}

}
