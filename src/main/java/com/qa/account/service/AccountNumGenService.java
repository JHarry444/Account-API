package com.qa.account.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class AccountNumGenService {

	private char[] type = { 'a', 'b', 'c' };
	private Random rand = new Random();

	/* 6 + 2 x 0  = 6
	 * 6 + 2 x 1 = 8
	 * 6  + 2 x 2 = 10
	 */
	public String genNumber() {
		int length = 6 + (2 * rand.nextInt(3));
		char accountType = type[rand.nextInt(3)];
		String output = "" + accountType;
		for (int i = 0; i < length; i++) {
			output += rand.nextInt(10);
		}
		return output;
	}
}
