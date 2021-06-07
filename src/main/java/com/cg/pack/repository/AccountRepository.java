package com.cg.pack.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.pack.entities.Account;
import com.cg.pack.entities.Pack;
import com.cg.pack.exception.AccountNotFoundException;
import com.cg.pack.exception.PackNotFoundException;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	@Query("SELECT COUNT(AC.accountId) FROM ACCOUNT AC WHERE registeredDate BETWEEN :startDate AND :endDate")
	public int countCreatedAccountsInPeriod(LocalDate startDate, LocalDate endDate);
	
	public int countAccounts();
	
	@Query("DELETE currentPack FROM ACCOUNT WHERE accountId== account.getAccountId AND currentPack.packId == pack.getPackId ")
	public void removePackFromAccount(Account account, Pack pack) throws AccountNotFoundException,PackNotFoundException;


}
