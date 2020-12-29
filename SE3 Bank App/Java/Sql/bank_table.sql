CREATE TABLE `customer` (
  `USERID` varchar(20) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  `CUSTOMER_NAME` varchar(50) NOT NULL,
  `PHONE_NUMBER` varchar(20) NOT NULL,
  `LINKEDBANKCARD` varchar(20) NOT NULL,
  `EMAIL` varchar(20) NOT NULL,
  PRIMARY KEY  (`USERID`)
  );

CREATE TABLE `bankaccount` (
  `ACCOUNT_ID` varchar(20) NOT NULL,
  `BALANCE` double NOT NULL,
  `ACCOUNT_HOLDER` varchar(50) NOT NULL,
  PRIMARY KEY  (`ACCOUNT_ID`),
  FOREIGN KEY (`ACCOUNT_ID`) REFERENCES CUSTOMER(USERID)
  );
  
  INSERT INTO customer VALUES ("jsmith888", "password", "John Smith", "+353833908585", "4138629828414329", "jsmith@mail.com"),
  			      ("maryann123", "password", "Mary Ann", "+353823231231", "5163376044591523", "maryanny@mail.com"),
  			      ("frankc0c0", "password", "Frank Cocozza", "+353839482019", "4556299471254704", "frank@mail.com"),
  	     		      ("patjones353", "password", "Patrick Jones", "+353833547871", "5239721035680241", "patty@gmail.com");

  INSERT INTO bankaccount VALUES ("jsmith888", 848481.40, "John Smith"),
  			      ("maryann123", 1314579.50, "Mary Ann"),
  			      ("frankc0c0", 5000000.00, "Frank Cocozza"),
  	     		      ("patjones353", 978090.13, "Patrick Jones");