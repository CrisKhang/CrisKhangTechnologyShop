package com.tcoshop.service.verifyAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcoshop.model.Account;
import com.tcoshop.model.VerifyAccount;
import com.tcoshop.service.database.VerifyAccountRepository;
import com.tcoshop.util.PasswordUtil;

@Service
public class CreateVerifyAccountByAccount {
	@Autowired
	VerifyAccountRepository verifyAccountRepository;
	@Autowired
	PasswordUtil passwordUtil;
	public VerifyAccount createVerifyAccount(Account registerAccount) {
		String verifyCode = registerAccount.getUsername() + String.valueOf(passwordUtil.generatePassword(8));
		VerifyAccount verifyAccount = new VerifyAccount(registerAccount.getUsername(), registerAccount, verifyCode);
		verifyAccountRepository.save(verifyAccount);
		return verifyAccount;
	}
}
