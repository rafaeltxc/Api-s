CREATE SCHEMA IF NOT EXISTS simple_schema;

CREATE  TABLE simple_schema.tbl_bank ( 
	bank_id         INT  NOT NULL PRIMARY KEY SERIAL,
	bank_name       VARCHAR(30)  NOT NULL     
 );

CREATE  TABLE simple_schema.tbl_user ( 
	user_id              INT  NOT NULL PRIMARY KEY SERIAL,
	user_first_name      VARCHAR(15)  NOT NULL,
	user_last_name       VARCHAR(15)  NOT NULL,
	user_birth           DATE  NOT NULL ,
	user_country         VARCHAR(15)  NOT NULL     
 );

CREATE  TABLE simple_schema.tbl_account ( 
	account_id                   INT  NOT NULL PRIMARY KEY SERIAL,
	account_total_money          INT  NOT NULL DEFAULT (0),
	account_creation_date        DATE  NOT NULL,
	fk_tbl_user_tbl_account      INT  NOT NULL,
	fk_tbl_bank_tbl_account      INT  NOT NULL     
 );

ALTER TABLE simple_schema.tbl_account ADD FOREIGN KEY ( fk_tbl_user_tbl_account ) REFERENCES simple_schema.tbl_user( user_id ) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE simple_schema.tbl_account ADD FOREIGN KEY ( fk_tbl_bank_tbl_account ) REFERENCES simple_schema.tbl_bank( bank_id ) ON DELETE CASCADE ON UPDATE CASCADE;