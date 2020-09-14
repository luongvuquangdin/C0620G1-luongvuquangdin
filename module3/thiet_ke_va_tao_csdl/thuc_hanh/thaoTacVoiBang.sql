create database manipulate_table;
use manipulate_table;

CREATE TABLE contacts
( contact_id INT(11) NOT NULL AUTO_INCREMENT,
  birthday DATE,
  CONSTRAINT contacts_pk PRIMARY KEY (contact_id)
);

CREATE TABLE suppliers
( supplier_id INT(11) NOT NULL AUTO_INCREMENT,
  supplier_name VARCHAR(50) NOT NULL,
  account_rep VARCHAR(30) NOT NULL DEFAULT 'TBD',
  CONSTRAINT suppliers_pk PRIMARY KEY (supplier_id)
);

ALTER TABLE contacts
  ADD last_name varchar(40) NOT NULL
    AFTER contact_id,
  ADD first_name varchar(35) NULL
    AFTER last_name;
ALTER TABLE contacts
ADD manhan varchar(20) NOT NULL
FIRST;

ALTER TABLE contacts
MODIFY manhan varchar(40) NOT NULL;

ALTER TABLE contacts
DROP COLUMN manhan;

ALTER TABLE contacts
RENAME TO people;

ALTER TABLE contacts
CHANGE COLUMN manhan ma_nhan varchar(100);

