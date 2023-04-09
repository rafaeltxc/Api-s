package com.api.bean;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "user_first_name", nullable = false, length = 15)
	private String userFirstName;
	
	@Column(name = "user_last_name", nullable = false, length = 15)
	private String userlastName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "user_birth", nullable = false)
	private Calendar userBirth;
	
	@Column(name = "user_country", nullable = false, length = 30)
	private String userCountry;
	
}
