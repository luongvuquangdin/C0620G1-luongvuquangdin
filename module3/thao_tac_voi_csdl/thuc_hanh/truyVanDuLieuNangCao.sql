use classicmodels;

-- Hiển thị mã sản phẩm , tên sản phẩm, giá bán, số lượng trong kho của sản phẩm có giá bán lớn hơn 56.76 và số lượng trong kho lớn hơn 10
select productCode, productName, buyprice, quantityInStock from products
where buyPrice>56.76 and quantityInStock>10;

/* productcode, productname và buyprice từ bảng products, textdescription từ bảng 
productlines với điều kiện giá mua nằm trong khoảng từ 56.76 đến 95.59 */
select productCode, productName,buyprice, textDescription
from products
inner join productlines on products.productLine=productlines.productLine
where buyprice between 56.76 and 95.59;

-- hiển thị ra các sản phẩm có loại sản phẩm là Classic Cars hoặc nhà cung cấp là 'Min Lin Diecast' 
select *
from products
where productLine='Classic Cars' or productVendor='Min Lin Diecast';