CREATE DATABASE springcloud1 CHARACTER SET UTF8 ;
USE springcloud ;
CREATE TABLE product (
productId BIGINT AUTO_INCREMENT ,
productName VARCHAR(50) ,
 productDesc VARCHAR(50) ,
CONSTRAINT pk_prodcut_id PRIMARY KEY(productId)
) ;

INSERT INTO product(productName,productDesc) VALUES ('java编程1',DATABASE()) ;
INSERT INTO product(productName,productDesc) VALUES ('Springboot1',DATABASE()) ;
INSERT INTO product(productName,productDesc) VALUES ('西游记1',DATABASE()) ;
INSERT INTO product(productName,productDesc) VALUES ('水浒传1',DATABASE()) ;
INSERT INTO product(productName,productDesc) VALUES ('西厢记1',DATABASE()) ;