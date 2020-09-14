create database bank;
use bank;
-- Tạo bảng customer
create table customers(
customer_number varchar(8),
fullname varchar(50),
address varchar(100),
email varchar(200),
numberphone varchar(10),
primary key(customer_number)
);

-- Tạo bảng Accounts
create table accounts(
account_number varchar(15),
account_type varchar(150),
`date` date,
balance int,
customer_number varchar(8) NOT NULL UNIQUE,
primary key(account_number),
constraint fk_account foreign key(customer_number) references customers(customer_number)
);

-- Tạo bảng Transactions 
create table transactions(
tran_number varchar(20),
account_number varchar(15) NOT NULL,
date_tran date,
amounts int,
descriptions text,
primary key(tran_number),
constraint fk_transactions foreign key(account_number) references accounts(account_number)
);

