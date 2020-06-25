package com.qa.account.services;

import static org.junit.Assert.assertTrue;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.account.service.AccountNumGenService;

@RunWith(SpringRunner.class)
public class AccountNumGenServiceUnitTest {

	private final AccountNumGenService NUM_GEN = new AccountNumGenService();

	private final String ACCOUNT_NUM_PATTERN = "^[abc](\\d{10}|\\d{8}|[0-9]{6})$";

	@Test
	public void testGenNumber() {
		String accountNum;
		char firstChar;
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			accountNum = NUM_GEN.genNumber();
			firstChar = accountNum.charAt(0);
			assertTrue("Incorrect start charact", firstChar == 'a' || firstChar == 'b' || firstChar == 'c');
			assertTrue("Incorrect length",
					accountNum.length() == 7 || accountNum.length() == 9 || accountNum.length() == 11);
			// regex version
			assertTrue("Incorrect account number", accountNum.matches(ACCOUNT_NUM_PATTERN));
		}
	}

	@Test
	public void coolerTestGenNumber() {
		assertTrue(IntStream.range(0, 100).mapToObj(i -> this.NUM_GEN.genNumber())
				.allMatch(accountNum -> accountNum.matches(ACCOUNT_NUM_PATTERN)));
	}

}
