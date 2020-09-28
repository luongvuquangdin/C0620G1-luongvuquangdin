CREATE DATABASE khanh;

USE khanh;

-- Tạo bảng có khóa chính là id
CREATE TABLE customers(
   id INT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(40),
   address VARCHAR(255),
   email VARCHAR(255)
);

-- Tạo bảng có khóa ngọa là customer_id liên kết với id của bảng customer
CREATE TABLE orders(
   id INT AUTO_INCREMENT,
   staff VARCHAR(50),
   PRIMARY KEY(id),
   customer_id INT,
   FOREIGN KEY(customer_id) REFERENCES customers(id)
);