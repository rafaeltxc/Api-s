package com.rtxct.simple.schema.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_account")
public class AccountModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_id")
	private Long accountId;
	
	@Column(name = "account_total_money")
	private BigDecimal accountTotalMoney;
	
	@Column(name = "account_creation_date")
	private Date accountCreationDate;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "fk_tbl_user", referencedColumnName = "user_id")
	private UserModel fkUser;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "fk_tbl_bank", referencedColumnName = "bank_id")
	private BankModel fkBank;
	
}
