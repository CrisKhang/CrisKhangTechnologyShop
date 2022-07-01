package com.tcoshop.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcoshop.model.Account;
import com.tcoshop.model.VerifyAccount;
import com.tcoshop.service.database.AccountRepository;
import com.tcoshop.service.database.VerifyAccountRepository;

@Service
public class VerifySignUpAccount {
	@Autowired
	VerifyAccountRepository verifyAccountRepository;
	@Autowired
	AccountRepository accountRepository;
	
	public String verifyAccount(String verifyCode) {
		try {
			VerifyAccount verifyAccount = verifyAccountRepository.findVerifyAccountByVerifyCode(verifyCode);
			Account account = accountRepository.findAccountByUsername(verifyAccount.getUsername());
			account.setActivated(true);
			accountRepository.save(account);
			return "Thành công";
		} catch(Exception ex) {
			ex.printStackTrace();
			return "Thất bại";
		}
	}
	
}
