import java.sql.*;
public class SQLdriver {
   private static Connection con;

public static Connection getConnection(){
	   try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/project_3_2?user=root&password=ics311");//this will be the common connection for all of our project
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	return con;
   }



}

//this is the code one needs to compile in mysql.
/*

CREATE TABLE Branch
(
  branch_id INT NOT NULL,
  branch_zip INT NOT NULL,
  branch_state varchar(2),
  branch_city varchar(25),
  branch_addr varchar(50),
  branch_open_date DATE,
  branch_last_modified DATE,
  PRIMARY KEY (branch_id)
);

CREATE TABLE Account
(
  accnt_id INT NOT NULL,
  accnt_bal INT NOT NULL,
  accnt_type varchar(25),
  accnt_fees INT NOT NULL,
  accnt_open_date DATE,
  accnt_coown INT,
  accnt_last_modified DATE,
  branch_id INT NOT NULL,
  PRIMARY KEY (accnt_id),
  FOREIGN KEY (branch_id) REFERENCES Branch(branch_id)
);
CREATE TABLE Loan
(
  loan_id INT NOT NULL,
  loan_interest INT NOT NULL,
  loan_type varchar(20),
  loan_principle INT NOT NULL,
  loan_start_date DATE,
  loan_end_date DATE,
  loan_last_modified DATE,
  accnt_id INT NOT NULL,
  FOREIGN KEY (accnt_id) REFERENCES Account(accnt_id)
);


CREATE TABLE Customer
(
  Cus_id INT NOT NULL,
  Cus_zip INT NOT NULL,
  Cus_state varchar(2),
  cus_addr varchar(30),
  Cus_lname varchar(30),
  cus_fname varchar(30),
  accnt_creation_date DATE,
  last_update DATE,
  Credit_rating int,
  PRIMARY KEY (Cus_id)
);

CREATE TABLE deposit
(
  deposit_date DATE NOT NULL,
  deposit_amt INT NOT NULL,
  deposit_last_update DATE NOT NULL,
  accnt_id INT NOT NULL,
  deposit_id int not null,
  PRIMARY KEY (deposit_id),
  FOREIGN KEY (accnt_id) REFERENCES Account(accnt_id)
);

CREATE TABLE customer_account
(
  date_created Date,
  date_last_modified Date,
  Cus_id INT NOT NULL,
  accnt_id INT NOT NULL,
  PRIMARY KEY (Cus_id, accnt_id),
  FOREIGN KEY (Cus_id) REFERENCES Customer(Cus_id),
  FOREIGN KEY (accnt_id) REFERENCES Account(accnt_id)
);

CREATE TABLE withdrawal
(
  withdrawal_date DATE,
  withdrawal_amt INT NOT NULL,
  withdrawal_last_update DATE,
  accnt_id INT NOT NULL,
  withdrawal_id INT NOT NULL,
  PRIMARY KEY (withdrawal_id),
  FOREIGN KEY (accnt_id) REFERENCES Account(accnt_id)
);

insert into branch values (1,55344,'MN','Eden Prairie','954 Border St.','2001-12-01','2001-12-01');
insert into branch values (2,52141,'MN','Minneapolis','126 Border Avenue. ','2005-10-05','2005-10-05');
insert into branch values (3,42144,'IL','Chicago','980 Princeton St.','2004-12-01','2005-12-03');
insert into branch values (4,34146,'IL','Chicago','4241 Wall Street.','2004-12-01','2005-12-03');
insert into branch values (5,11241,'WI','Madison','954 Harvard St.','2015-03-03','2001-12-01');
insert into branch values (6,65221,'MN','Chaska','931 Yale St. ','2008-12-16','2008-12-16');
insert into branch values (7,44213,'MN','Bloomington','110 MIT St. ','2006-12-01','2001-12-01');
insert into branch values (8,45224,'MN','Edina','5001 IIT Tech Ave. ','2009-12-01','2001-12-01');
insert into branch values (9,45221,'MN','Waconia','8415 Anderson lakes parkway. ','2010-12-01','2001-12-01');
insert into branch values (10,42776,'MN','St. Paul','8415 Darnel Road.  ','2012-12-01','2001-12-01');


insert into account values(10000,1000,'Checking', 0, '2008-08-11', null,'2008-11-20',1);
insert into account values(10001,200,'savings', 0, '2008-09-02', null,'2008-11-20',2);
insert into account values(10002,1000,'Checking', 0, '2008-12-11', null,'2008-11-20',3);
insert into account values(10003,2351,'Checking', 0, '2009-11-7', null,'2010-11-20',5);
insert into account values(10004,1000,'Checking', 0, '2008-11-11', null,'2008-11-20',7);
insert into account values(10005,2351,'savings', 0, '2008-05-11', null,'2008-02-20',9);
insert into account values(10006,1000,'Checking', 0, '2008-01-11', 55314,'2012-05-13',1);
insert into account values(10007,1000,'Checking', 0, '2008-03-11', null,'2013-11-20',1);
insert into account values(10008,1000,'savings', 0, '2010-11-11', 644411,'2016-11-10',1);
insert into account values(10009,15,'Checking', 125, '2008-11-11', null,'2008-11-20',6);
insert into account values(10010,550,'Checking', 125, '2008-12-05', null,'2008-11-20',5);
insert into account values(10011,1000,'Checking', 150, '2008-11-11', null,'2008-11-20',4);
insert into account values(10012,500,'Checking', 0, '2008-11-11', null,'2008-11-20',3);
insert into account values(10013,7000,'IRA', 0, '2008-11-11', 644421,'2008-11-20',2);
insert into account values(10014,7020,'IRA', 0, '2008-11-11', 644421,'2008-11-20',1);

insert into customer values(12341,55344,'MN','5422 anderson lakes parkway','Adam','Smith','2008-11-20','2008-11-25',760);
insert into customer values(45301,55344,'MN','5422 anderson lakes parkway','Kennedy','Smith','2008-11-25','2016-11-20',350);
insert into customer values(23461,42341,'WI','Eau Claire parkway','Mary','Anne','2008-11-01','2008-12-20',800);
insert into customer values(45654,54215,'WI','Maidson Street','John','Anderson','2008-11-20','2008-11-20',600);
insert into customer values(23462,31145,'WI','8213 Madison street','Bradford','Armitage','2008-11-20','2008-11-20',713);
insert into customer values(45234,45314,'MN','165 Flying cloud Drive','Joan','Smith','2006-01-07','2008-11-24',502);
insert into customer values(25563,55344,'MN','211 Flying cloud Drive','Jabocsen','Arnold','2008-11-20','2008-11-20',642);
insert into customer values(45632,43251,'IL','4234 West Side','Arnold','Doherty','2008-11-20','2009-12-24',694);
insert into customer values(45683,55344,'MN','5422 anderson lakes parkway','Krishna','Balarama','2005-10-22','2007-11-20',675);
insert into customer values(54732,55214,'MN','8612 Darnel Road','Brianna','Mark','2008-11-20','2008-11-20',379);
insert into customer values(42311,55214,'MN','418 Flying cloud drive','Hannah','Jacobsen','2008-11-20','2008-11-20',802);

insert into loan values(12351,3,'Automobile',10000,'2008-08-15','2008-10-15','2008-08-15',10000);
insert into loan values(12352,3,'Mortgage',100000,'2008-08-15','2025-08-15','2008-08-15',10004);
insert into loan values(12353,5,'Payday',50,'2008-06-15','2008-10-15','2008-07-13',10002);
insert into loan values(12354,3,'Student',50000,'2008-08-15','2015-10-18','2008-08-15',10000);
insert into loan values(12355,3,'Student',25000,'2008-08-15','2016-10-15','2008-08-15',10009);
insert into loan values(12356,3,'Student',10000,'2007-03-15','2010-10-15','2008-08-15',10000);
insert into loan values(12357,5,'Business',10000,'2008-08-15','2008-10-10','2008-08-23',10011);
insert into loan values(12358,4,'Mortgage',10000,'2008-08-15','2008-10-15','2010-07-20',10011);
insert into loan values(12359,3,'Mortgage',10000,'2008-08-15','2008-10-15','2008-08-15',10000);

insert into customer_account values ('2008-08-15','2010-08-20',12341,10000);
insert into customer_account values ('2008-05-15','2008-02-20',42311,10004);
insert into customer_account values ('2010-02-15','2012-08-12',42311,10003);
insert into customer_account values ('2008-08-15','2010-08-20',12341,10002);
insert into customer_account values ('2016-12-17','2016-12-03',45654,10011);
insert into customer_account values ('2012-11-15','2016-01-18',45654,10013);
insert into customer_account values ('2015-08-09','2016-10-07',45654,10008);
insert into customer_account values ('2014-11-10','2015-12-17',23461,10006);
insert into customer_account values ('2012-12-16','2013-11-18',45683,10011);
insert into customer_account values ('2016-12-17','2016-12-28',45683,10002);
insert into customer_account values ('2016-11-17','2016-12-18',45654,10003);

insert into deposit values ('2016-11-17',100,'2016-11-17',10003,12901);
insert into deposit values ('2012-01-12',1500,'2012-01-12',10003,12902);
insert into deposit values ('2013-11-17',1200,'2016-11-17',10010,12903);
insert into deposit values ('2014-05-12',15,'2016-11-17',10010,12904);
insert into deposit values ('2005-01-03',200,'2016-11-17',10009,12905);
insert into deposit values ('2011-10-12',760,'2016-11-17',10009,12906);
insert into deposit values ('2013-09-06',120,'2016-11-17',10003,12907);
insert into deposit values ('2014-05-01',100,'2016-11-17',10001,12909);
insert into deposit values ('2012-02-03',250,'2016-11-17',10003,12910);
insert into deposit values ('2013-04-05',100,'2016-11-17',10006,12911);

insert into withdrawal values ('2012-11-17',100,'2016-11-17',10003,12901);
insert into withdrawal values ('2013-12-13',1000,'2016-11-17',10003,12902);
insert into withdrawal values ('2016-10-12',125,'2016-11-17',10005,12903);
insert into withdrawal values ('2006-11-17',250,'2006-11-17',10008,12904);
insert into withdrawal values ('2005-10-18',15,'2007-11-18',10008,12905);
insert into withdrawal values ('2016-11-17',500,'2016-12-18',10009,12906);
insert into withdrawal values ('2016-11-17',500,'2016-12-18',10012,12907);
insert into withdrawal values ('2016-11-17',500,'2016-12-18',10011,12908);
insert into withdrawal values ('2016-11-17',500,'2016-12-18',10010,12909);
insert into withdrawal values ('2016-11-17',500,'2016-12-18',10013,12910);



*/