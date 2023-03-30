CREATE DATABASE `ims`;

CREATE TABLE `customer` (
  `customerid` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(80) NOT NULL,
  `surname` varchar(80) NOT NULL,
  PRIMARY KEY (`customerid`),
  UNIQUE KEY `customerid` (`customerid`)
);

CREATE TABLE `item` (
  `itemid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `cost` decimal(6,2) NOT NULL,
  PRIMARY KEY (`itemid`),
  UNIQUE KEY `itemid` (`itemid`)
);

CREATE TABLE `order` (
  `orderid` int NOT NULL AUTO_INCREMENT,
  `customerid` int NOT NULL,
  PRIMARY KEY (`orderid`),
  UNIQUE KEY `orderid_UNIQUE` (`orderid`),
  UNIQUE KEY `customerid_UNIQUE` (`customerid`),
  CONSTRAINT `customerid` FOREIGN KEY (`customerid`) REFERENCES `customer` (`customerid`)
);

CREATE TABLE `itemorder` (
  `itemorderid` int NOT NULL AUTO_INCREMENT,
  `orderid` int NOT NULL,
  `itemid` int NOT NULL,
  `total` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`itemorderid`),
  UNIQUE KEY `iditemorder_UNIQUE` (`itemorderid`),
  KEY `orderid_idx` (`orderid`),
  KEY `itemid_idx` (`itemid`),
  CONSTRAINT `itemid` FOREIGN KEY (`itemid`) REFERENCES `item` (`itemid`),
  CONSTRAINT `orderid` FOREIGN KEY (`orderid`) REFERENCES `order` (`orderid`)
);

