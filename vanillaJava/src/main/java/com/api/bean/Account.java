package com.api.bean;

import java.math.BigDecimal;
import java.util.Calendar;

public class Account {

	private int accountId;
	private BigDecimal accountTotalMoney;
	private Calendar accountCreationDate;
	private int userfK;
	private int bankfk;
	
	public Account() {}

	public Account(int accountId, BigDecimal accountTotalMoney, Calendar accountCreationDate, int userfK, int bankfk) {
		super();
		this.accountId = accountId;
		this.accountTotalMoney = accountTotalMoney;
		this.accountCreationDate = accountCreationDate;
		this.userfK = userfK;
		this.bankfk = bankfk;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public BigDecimal getAccountTotalMoney() {
		return accountTotalMoney;
	}

	public void setAccountTotalMoney(BigDecimal accountTotalMoney) {
		this.accountTotalMoney = accountTotalMoney;
	}

	public Calendar getAccountCreationDate() {
		return accountCreationDate;
	}

	public void setAccountCreationDate(Calendar accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}

	public int getUserfK() {
		return userfK;
	}

	public void setUserfK(int userfK) {
		this.userfK = userfK;
	}

	public int getBankfk() {
		return bankfk;
	}

	public void setBankfk(int bankfk) {
		this.bankfk = bankfk;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountTotalMoney=" + accountTotalMoney + ", accountCreationDate="
				+ accountCreationDate + ", userfK=" + userfK + ", bankfk=" + bankfk + "]";
	}
	
}
