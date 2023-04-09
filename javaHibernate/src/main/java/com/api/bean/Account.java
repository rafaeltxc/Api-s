package com.api.bean;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private int accountId;
	
	@Column(name = "account_total_money", nullable = false, columnDefinition = "int default 0")
	private BigDecimal accountTotalMoney;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "account_creation_date")
	private Calendar accountCreationDate;
	
	@ManyToOne
	@JoinColumn(name = "fk_tbl_user_tbl_account")
	private User fkUserId;
	
	@ManyToOne
	@JoinColumn(name = "fk_tbl_bank_tbl_account")
	private Bank fkBankId;

}
