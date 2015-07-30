SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";/* */
SET time_zone = "+00:00";

/* Creating a SQL database from scratch*/

CREATE TABLE IF NOT EXISTS `authors`(
	`author_id` int (11) NOT NULL AUTO_INCREMENT,
	`first_name` varchar(20) NOT NULL,
	`last_name` varchar(20) NOT NULL,
	`street` varchar(50) NOT NULL,
	`city` varchar(20) NOT NULL,
	`State` varchar(20) NOT NULL,
	`zip` varchar(20) NOT NULL,
	`phone` varchar(20) NOT NULL,
	PRIMARY KEY (`author_id`)
)ENGINE = InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT = 1;/*InnoDB is the default */


CREATE TABLE IF NOT EXISTS`books`(
	`book_id` int(11) NOT NULL AUTO_INCREMENT,
	`isbn` varchar(20) NOT NULL,
	`title` varchar(50) NOT NULL,
	`publisher_id`int(11) NOT NULL,
	`price` decimal(5,2) NOT NULL, /*5 min number int total, 2 is max after decimal- 5 digets are pushed to the Db
	ex $10 == +010.00  in Db*/
	`publish_date` datetime NOT NULL,
	PRIMARY KEY(`book_id`),
	
	KEY `publisher_id` (`publisher_id`)/* HELPS W/ ATTACHMENT OF FORENi KEY/LINKS Db */
)ENGINE = InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT = 1;/*InnoDB is the default */

/* BRIDGE TABLE W/ MANY-MANY RELATIONSHIP*/
CREATE TABLE IF NOT EXISTS `books_authors`
( 	
	`book_id` int(11) NOT NULL
	`author_id` int(11) NOT NULL,

	KEY `book_id` (`book_id`),
	KEY `author_id` (`author_id`)
) ENGINE=InnoDB DEFAULT CHARSET = latin1;

CREATE TABLE IF NOT EXISTS `publishers`(
 `publisher_id` int(11) NOT NULL AUTO_INCREMENT,
 `name` varchar(20) NOT NULL,
 `street` varchar(50) NOT NULL,
 `city` varchar(20) NOT NULL,
 `zip` varchar(20) NOT NULL,
 `phone` varchar(20) NOT NULL,
 PRIMARY KEY(`publisher_id`)
)ENGINE = InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT = 1;

ALTER TABLE `books`/* `CONSTRAINT `books_idfk_1` == reference name  ot constraint */
	ADD CONSTRAINT `books_idfk_1` FOREIGN KEY (`publisher_id`) REFERENCES
	`publishers` (`publisher_id`) ON DELETE NO ACTION;


ALTER TABLE `books_authors`
	ADD  CONSTRAINT `books_authors_idfk_1` FOREIGN KEY(book_id)REFERENCES
		`books` (`book_id`)  ON DELETE NO ACTION,
	ADD  CONSTRAINT `books_authors_idfk_2` FOREIGN KEY(author_id)REFERENCES
		`authors` (`author_id`)  ON DELETE NO ACTION;