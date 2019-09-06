
CREATE TABLE sys.`product_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) ,
  `criteria_id` int(11) ,
  `range_id` int(11) ,
    `weight` double(10,2),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE sys.`product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,  
  `name` varchar(100) ,
  `grade` double(10,2),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
ALTER TABLE sys.product  ADD COLUMN price double(10,2) DEFAULT 0
ALTER TABLE sys.product  ADD COLUMN selected INT DEFAULT 0


CREATE TABLE sys.`range` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `criteria_id` int(11) ,
  `range_name` varchar(100) ,
  `range_value` double(10,2),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE sys.`criteria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `issue_id` int(11) ,
  `name` varchar(45) ,
   `weight` double(10,2),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE sys.`Issue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) ,
  `issue_name` varchar(100) ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE sys.Issue  ADD COLUMN status INT DEFAULT 0




SELECT  * FROM sys.Issue;
truncate table sys.Issue;

SELECT  * FROM sys.criteria;
truncate table sys.criteria;

SELECT  * FROM sys.range;
truncate table sys.range;

SELECT  * FROM sys.product;
truncate table sys.product;

SELECT  * FROM sys.product_details;
truncate table sys.product_details;

