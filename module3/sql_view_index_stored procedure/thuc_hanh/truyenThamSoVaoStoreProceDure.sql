use classicmodels;

-- procedure có tham số in
drop procedure if exists getCusById;
DELIMITER //
drop procedure if exists `getCusById`//
CREATE PROCEDURE getCusById(IN cusNum INT(11))
BEGIN
  SELECT * FROM customers WHERE customerNumber = cusNum;
END //
DELIMITER ;

call getCusById(175);

-- procedure có tham số out
DELIMITER //
drop procedure if exists `GetCustomersCountByCity`//
CREATE PROCEDURE GetCustomersCountByCity(IN  in_city VARCHAR(50),OUT total INT)
BEGIN
    SELECT COUNT(customerNumber)
    INTO total
    FROM customers
    WHERE city = in_city;
END//
DELIMITER ;

CALL GetCustomersCountByCity('Lyon',@total);

SELECT @total;	

-- procedure có tham số inout
DELIMITER //
drop procedure if exists `SetCounter`//
CREATE PROCEDURE SetCounter(INOUT counter INT,IN inc INT)
BEGIN
    SET counter = counter + inc;
END//
DELIMITER ;

SET @counter = 1; 
CALL SetCounter(@counter,1); -- 2
CALL SetCounter(@counter,1); -- 3
CALL SetCounter(@counter,5); -- 8
SELECT @counter; -- 8

 