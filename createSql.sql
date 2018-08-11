CREATE TABLE tb1_customer
(
pid INT NOT NULL AUTO_INCREMENT,
customerId VARCHAR(100),
pwd VARCHAR(100),
showname VARCHAR(100),
truename VARCHAR(100),
registertime VARCHAR(100),
PRIMARY KEY(pid)
)CHARSET=utf8 ENGINE=INNODB;


CREATE TABLE tb1_goods
(
pid INT NOT NULL AUTO_INCREMENT,
NAME VARCHAR(200),
imgpath VARCHAR(500),
description VARCHAR(3000),
PRIMARY KEY(pid)
)CHARSET=utf8 ENGINE=INNODB;



CREATE TABLE tb1_cart
(
pid INT NOT NULL AUTO_INCREMENT,
customerpid INT,
goodspid INT,
buynum INT,

PRIMARY KEY(pid)
)CHARSET=utf8 ENGINE=INNODB;


DROP TABLE IF EXISTS tb1_order;
CREATE TABLE tb1_order
(
pid INT NOT NULL AUTO_INCREMENT,
customeruuid INT,
ordertime VARCHAR(100),
totalmoney FLOAT,
savemoney FLOAT,
state SMALLINT,
PRIMARY KEY(pid)
)CHARSET=utf8 ENGINE=INNODB;


CREATE TABLE tb1_orderDetail
(
pid INT NOT NULL AUTO_INCREMENT,
orderpid INT,
goodspid INT,
ordernum INT,
price FLOAT,
money FLOAT,
savemoney FLOAT,
PRIMARY KEY(pid)
)CHARSET=utf8 ENGINE=INNODB;

CREATE TABLE tb1_store
(
pid INT NOT NULL AUTO_INCREMENT,
goodspid INT,
storenum INT,
PRIMARY KEY(pid)
)CHARSET=utf8 ENGINE=INNODB
