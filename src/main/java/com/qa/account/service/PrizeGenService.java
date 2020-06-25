package com.qa.account.service;

import org.springframework.stereotype.Service;

@Service
public class PrizeGenService {

	public double genPrize(String accountNum) {
		double prize = 0;
		accountNum = accountNum.toLowerCase();
		final int NUM_LENGTH  = accountNum.length();
		if (accountNum.startsWith("b")) {
			if (NUM_LENGTH == 7) {
				prize =  50;
			} else if (NUM_LENGTH == 9) {
				prize =  500;
			} else if (NUM_LENGTH == 10) {
				prize =  5000;
			}
		} else if (accountNum.startsWith("c")) {
			if (NUM_LENGTH == 7) {
				prize =  100;
			} else if (NUM_LENGTH == 9) {
				prize =  750;
			} else if (NUM_LENGTH == 10) {
				prize =  10000;
			}
		}
		return prize;
	}
}
