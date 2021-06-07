package com.cg.pack.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.cg.pack.entities.Account;
import com.cg.pack.entities.Pack;
import com.cg.pack.exception.AccountNotFoundException;
import com.cg.pack.exception.PackNotFoundException;

@Service
public interface IAccountService {
	Account addAccount(Account account);
	Account fetchById(long accountId) throws AccountNotFoundException, NumberFormatException;
	Account updateAccount(Account account) throws AccountNotFoundException;
	void deleteByAccountId(long accountId) throws AccountNotFoundException;
	int countCreatedAccountsInPeriod(LocalDate startDate, LocalDate endDate);
	int countAccounts();
	void removePackFromAccount(Account account, Pack pack) throws AccountNotFoundException,PackNotFoundException;

}
