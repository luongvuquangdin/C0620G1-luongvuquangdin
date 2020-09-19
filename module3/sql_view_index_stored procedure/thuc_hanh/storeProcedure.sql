use classicmodels;
drop procedure if exists findAllCustomers;
DELIMITER //
CREATE PROCEDURE findAllCustomers()
BEGIN
  SELECT * FROM customers;
END //
DELIMITER ;

call findAllCustomers();