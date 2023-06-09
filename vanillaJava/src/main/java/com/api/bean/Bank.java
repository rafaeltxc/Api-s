package com.api.bean;

public class Bank {

	private int bankId;
	private String bankName;
	
	public Bank() {}
	
	public Bank(int bankId, String bankName) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
	}
	
	public int getBankId() {
		return bankId;
	}
	
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + "]";
	}

}
