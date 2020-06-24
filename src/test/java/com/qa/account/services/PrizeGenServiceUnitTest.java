package com.qa.account.services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qa.account.service.PrizeGenService;

@RunWith(SpringJUnit4ClassRunner.class)
public class PrizeGenServiceUnitTest {

	private PrizeGenService prizeGen = new PrizeGenService();

	@Test
	public void testGenPrize() {
		String accountNum = "b123456";

		assertEquals("Wrong prize!", 50, prizeGen.genPrize(accountNum), 0.1);
	}

}
