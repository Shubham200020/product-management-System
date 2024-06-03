package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.pojo.Account;

@Service
public class Transection {
	public Account addBalance(Account currentBalance,Account subBalance) {
	
			currentBalance.setAccountBalance(currentBalance.getAccountBalance()+subBalance.getAccountBalance());
		
		return currentBalance;
	
	}
	public Account removeBalance(Account currentBalance,Account subBalance) {
		if(currentBalance.getAccountBalance()<subBalance.getAccountBalance())
			currentBalance.setAccountBalance(currentBalance.getAccountBalance()-subBalance.getAccountBalance());
		else
			return null;
		return currentBalance;
	}
	
}
