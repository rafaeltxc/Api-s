CREATE SCHEMA IF NOT EXISTS simple_schema;

CREATE  TABLE simple_schema.tbl_bank ( 
	bank_id         INT  NOT NULL,
	bank_name       VARCHAR(30)  NOT NULL     
 );

CREATE  TABLE simple_schema.tbl_user ( 
	user_id              INT  NOT NULL,
	user_first_name      VARCHAR(15)  NOT NULL,
	user_last_name       VARCHAR(15)  NOT NULL,
	user_birth           DATE  NOT NULL ,
	user_country         VARCHAR(15)  NOT NULL     
 );

CREATE  TABLE simple_schema.tbl_account ( 
	account_id                   INT  NOT NULL,
	account_total_money          INT  NOT NULL DEFAULT (0),
	account_creation_date        DATE  NOT NULL,
	fk_tbl_user_tbl_account      INT  NOT NULL,
	fk_tbl_bank_tbl_account      INT  NOT NULL     
 );

ALTER TABLE simple_schema.tbl_bank ADD PRIMARY KEY ( bank_id );

ALTER TABLE simple_schema.tbl_user ADD PRIMARY KEY ( user_id );

ALTER TABLE simple_schema.tbl_account ADD PRIMARY KEY ( account_id );

ALTER TABLE simple_schema.tbl_account ADD FOREIGN KEY ( fk_tbl_user_tbl_account ) REFERENCES simple_schema.tbl_user( user_id ) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE simple_schema.tbl_account ADD FOREIGN KEY ( fk_tbl_bank_tbl_account ) REFERENCES simple_schema.tbl_bank( bank_id ) ON DELETE CASCADE ON UPDATE CASCADE;

CREATE SEQUENCE tbl_bank_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER tbl_bank_trigger 
BEFORE INSERT ON simple_schema.tbl_bank
FOR EACH ROW 
BEGIN
	SELECT tbl_bank_seq
	INTO :new.bank_id
	FROM dual;
END;
/

CREATE SEQUENCE tbl_user_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER tbl_user_trigger 
BEFORE INSERT ON simple_schema.tbl_user
FOR EACH ROW 
BEGIN
	SELECT tbl_user_seq
	INTO :new.user_id
	FROM dual;
END;
/

CREATE SEQUENCE tbl_account_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER tbl_account_seq 
BEFORE INSERT ON simple_schema.tbl_account
FOR EACH ROW 
BEGIN
	SELECT tbl_account_seq
	INTO :new.account_id
	FROM dual;
END;
/
