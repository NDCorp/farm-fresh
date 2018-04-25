-- ***************** TO CREATE THE DATABASE THE FIRST TIME **********************

SELECT 'DROP/ CREATE DB';

USE sys;
DROP DATABASE IF EXISTS farmfreshshopping;
CREATE DATABASE farmfreshshopping;
 
SELECT 'DB farmfreshshopping CREATED';

USE farmfreshshopping;

SELECT 'CREATE TABLES';


CREATE TABLE Addresses (
  ID             int(10) NOT NULL AUTO_INCREMENT, 
  UsersID        int(10), 
  FarmsID        int(10), 
  AddressTypesID int(10) NOT NULL, 
  Address        varchar(100) NOT NULL, 
  City           varchar(50) NOT NULL, 
  PostalCode     varchar(10) NOT NULL, 
  Province       varchar(50) NOT NULL, 
  Country        varchar(100) NOT NULL DEFAULT 'Canada', 
  PRIMARY KEY (ID) 
  /* CONSTRAINT IMPLEMENTED BY TRIGGERS: address_before_insert AND address_before_update */
  /*CONSTRAINT CK_FARM_USER_ADDRESS 
    CHECK (CASE WHEN FarmsID IS NULL THEN 0 ELSE 1 END +   CASE WHEN UsersID IS NULL THEN 0 ELSE 1 END = 1) */
    );
	
CREATE TABLE AddressTypes (
  ID      int(10) NOT NULL AUTO_INCREMENT, 
  Type    varchar(30) NOT NULL, 
  Acronym char(1) NOT NULL, 
  PRIMARY KEY (ID));
  
CREATE TABLE Administrators (
  ID      int(10) NOT NULL UNIQUE,  
  PRIMARY KEY (ID));
  
CREATE TABLE Buyers (
  ID        int(10) NOT NULL UNIQUE, 
  FbBuyerId varchar(20) UNIQUE, 
  PRIMARY KEY (ID));

CREATE TABLE Farmers (
  ID            int(10) NOT NULL UNIQUE, 
  FarmsID       int(10) NOT NULL, 
  FarmerTypesID int(10) NOT NULL, 
  PositionName  varchar(100), 
  WebSite       varchar(100), 
  PRIMARY KEY (ID));
  
CREATE TABLE Categories (
  ID          int(10) NOT NULL AUTO_INCREMENT, 
  Name        varchar(50), 
  Description varchar(1000), 
  Picture     varchar(30) DEFAULT 'default.png',
  IsActive	  bit(1) DEFAULT 1 NOT NULL, 
  PRIMARY KEY (ID));
  
CREATE TABLE Evaluations (
  ID          int(10) NOT NULL AUTO_INCREMENT, 
  BuyersID    int(10) NOT NULL, 
  ItemsID     int(10) NOT NULL, 
  Title       varchar(100) NOT NULL, 
  Feedback    varchar(1000) NOT NULL, 
  Rate        smallint(6) NOT NULL, 
  CanPublish  bit(1) DEFAULT 1 NOT NULL, 
  DateCreated timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
  DateDeleted timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
  IsActive    bit(1) DEFAULT 1 NOT NULL, 
  PRIMARY KEY (ID));

CREATE TABLE FarmerTypes (
  ID          int(10) NOT NULL AUTO_INCREMENT, 
  TypeName    varchar(30) NOT NULL, 
  Acronym     char(1) NOT NULL, 
  Description varchar(1000), 
  PRIMARY KEY (ID));
  
CREATE TABLE Farms (
  ID          int(10) NOT NULL AUTO_INCREMENT, 
  Name        varchar(100) NOT NULL UNIQUE, 
  Description varchar(1000),
  HeadLine    varchar(150) NOT NULL, 
  DateCreated timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
  DateDeleted timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
  IsActive    bit(1) DEFAULT 1 NOT NULL, 
  Picture     varchar(30) DEFAULT 'default.png', 
  PRIMARY KEY (ID));
  
CREATE TABLE Items (
  ID           int(10) NOT NULL AUTO_INCREMENT, 
  FarmersID    int(10) NOT NULL, 
  PromotionsID int(10), 
  ItemTypesID  int(10) NOT NULL, 
  Name         varchar(50), 
  Description  varchar(1000), 
  Quantities   decimal(10, 2) DEFAULT 0 NOT NULL, 
  Price        decimal(8, 2), 
  IsActive     bit(1) DEFAULT 1 NOT NULL, 
  DateCreated  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
  DateDeleted  timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
  PRIMARY KEY (ID));
  
CREATE TABLE ItemTypes (
  ID      int(10) NOT NULL AUTO_INCREMENT, 
  Type    varchar(30) NOT NULL, 
  Acronym char(1) NOT NULL, 
  PRIMARY KEY (ID));
  
CREATE TABLE OrderItems (
  ID       int(10) NOT NULL AUTO_INCREMENT, 
  OrdersID int(10) NOT NULL, 
  ItemsID  int(10) NOT NULL, 
  StatusID int(10) NOT NULL, 
  Quantity decimal(10, 2) DEFAULT 0 NOT NULL, 
  Price    decimal(8, 2), 
  Details  varchar(500), 
  PRIMARY KEY (ID));
  
CREATE TABLE Orders (
  ID         int(10) NOT NULL AUTO_INCREMENT, 
  BuyersID   int(10) NOT NULL, 
  StatusID   int(10) NOT NULL, 
  Details    varchar(500), 
  DatePlaced timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
  PRIMARY KEY (ID));
  
CREATE TABLE OrderShippingPickup (
  ID           int(10) NOT NULL AUTO_INCREMENT, 
  OrderItemsID int(10) NOT NULL, 
  DateCreated  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
  ShippingDate timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
  PickUpDate   timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
  Address      varchar(100), 
  City         varchar(50), 
  PostalCode   varchar(10), 
  Province     varchar(50), 
  Country      varchar(100), 
  PRIMARY KEY (ID));
  
CREATE TABLE Packs (
  ID      int(10) NOT NULL UNIQUE, 
  PRIMARY KEY (ID));
  
CREATE TABLE Pictures (
  ID            int(10) NOT NULL AUTO_INCREMENT, 
  ItemsID       int(10) NOT NULL, 
  AlternateText varchar(50) NOT NULL, 
  Picture       varchar(30)  NOT NULL DEFAULT 'default.png', 
  PRIMARY KEY (ID));
  
CREATE TABLE Produce (
  ID                int(10) NOT NULL UNIQUE, 
  ProductionTypesID int(10) NOT NULL, 
  ProduceTypesID    int(10) NOT NULL, 
  CategoriesID      int(10) NOT NULL, 
  PRIMARY KEY (ID));
  
CREATE TABLE ProducePacks (
  ID         int(10) NOT NULL AUTO_INCREMENT, 
  ProduceID  int(10) NOT NULL, 
  PacksID    int(10) NOT NULL, 
  Quantities int(10) NOT NULL, 
  PRIMARY KEY (ID));
  
CREATE TABLE ProduceTypes (
  ID           int(10) NOT NULL AUTO_INCREMENT, 
  CategoriesID int(10) NOT NULL, 
  Name         varchar(50) NOT NULL, 
  Description  varchar(1000), 
  PRIMARY KEY (ID));
  
CREATE TABLE ProductionSchedule (
  ID                int(10) NOT NULL AUTO_INCREMENT, 
  FarmersID         int(10) NOT NULL, 
  ProductionTypesID int(10) NOT NULL, 
  Title             varchar(100) NOT NULL, 
  Description       varchar(1000) NOT NULL, 
  FromDate          timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
  ToDate            timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
  EstimatedDuration decimal(6, 2), 
  PRIMARY KEY (ID));
  
CREATE TABLE ProductionStep (
  ID                  int(10) NOT NULL AUTO_INCREMENT, 
  Title               varchar(100) NOT NULL, 
  Description         varchar(1000) NOT NULL, 
  Goal                varchar(500) NOT NULL, 
  Result              varchar(500), 
  NotificationDetails varchar(500), 
  ToDate              timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
  FromDate            timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
  Closed              bit(1) NOT NULL DEFAULT 0, 
  ToNotify            bit(1) NOT NULL DEFAULT 0, 
  PRIMARY KEY (ID));
  
CREATE TABLE ProductionTypes (
  ID          int(10) NOT NULL AUTO_INCREMENT, 
  Name        varchar(50) NOT NULL, 
  Description varchar(1000) NOT NULL, 
  PRIMARY KEY (ID));
  
CREATE TABLE Promotions (
  ID             int(10) NOT NULL AUTO_INCREMENT, 
  Title          varchar(100) NOT NULL, 
  Description    varchar(1000) NOT NULL, 
  Price          decimal(8, 2) NOT NULL, 
  DateCreated    timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
  ExpirationDate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
  IsActive       bit(1) DEFAULT 1 NOT NULL, 
  PRIMARY KEY (ID));
  
CREATE TABLE ScheduleStep (
  ID                   int(10) NOT NULL AUTO_INCREMENT, 
  ProductionStepID     int(10) NOT NULL, 
  ProductionScheduleID int(10) NOT NULL, 
  PRIMARY KEY (ID));
  
CREATE TABLE Status (
  ID          int(10) NOT NULL AUTO_INCREMENT, 
  Code        char(1) NOT NULL, 
  Description varchar(1000) NOT NULL, 
  PRIMARY KEY (ID));
  
CREATE TABLE Users (
  ID          int(10) NOT NULL AUTO_INCREMENT, 
  UserTypesID int(10) NOT NULL, 
  FirstName   varchar(50) NOT NULL, 
  LastName    varchar(50) NOT NULL, 
  MiddleName  varchar(50), 
  Email       varchar(80) NOT NULL UNIQUE, 
  Phone       varchar(15), 
  Password    varchar(40) NOT NULL, 
  Picture     varchar(30) DEFAULT 'default.png', 
  DateCreated timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
  DateDeleted timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
  IsActif     bit(1) DEFAULT 1 NOT NULL, 
  PRIMARY KEY (ID));
  
CREATE TABLE UserTypes (
  ID      int(10) NOT NULL AUTO_INCREMENT, 
  Type    varchar(30) NOT NULL, 
  Acronym char(1) NOT NULL, 
  PRIMARY KEY (ID));
  
SELECT 'TABLES CREATED';

SELECT 'CREATE CONSTRAINTS';

ALTER TABLE Users ADD INDEX FKUsers518300 (UserTypesID), ADD CONSTRAINT FKUsers518300 FOREIGN KEY (UserTypesID) REFERENCES UserTypes (ID);
ALTER TABLE Addresses ADD INDEX FKAddresses387144 (FarmsID), ADD CONSTRAINT FKAddresses387144 FOREIGN KEY (FarmsID) REFERENCES Farms (ID) ON DELETE Cascade;
ALTER TABLE Addresses ADD INDEX FKAddresses111743 (UsersID), ADD CONSTRAINT FKAddresses111743 FOREIGN KEY (UsersID) REFERENCES Users (ID) ON DELETE Cascade;
ALTER TABLE OrderShippingPickup ADD INDEX FKOrderShipp714048 (OrderItemsID), ADD CONSTRAINT FKOrderShipp714048 FOREIGN KEY (OrderItemsID) REFERENCES OrderItems (ID) ON DELETE Cascade;
ALTER TABLE Items ADD INDEX FKItems66182 (FarmersID), ADD CONSTRAINT FKItems66182 FOREIGN KEY (FarmersID) REFERENCES Farmers (ID) ON DELETE Cascade;
ALTER TABLE Items ADD INDEX FKItems774000 (PromotionsID), ADD CONSTRAINT FKItems774000 FOREIGN KEY (PromotionsID) REFERENCES Promotions (ID);
ALTER TABLE Items ADD INDEX FKItems661550 (ItemTypesID), ADD CONSTRAINT FKItems661550 FOREIGN KEY (ItemTypesID) REFERENCES ItemTypes (ID);
ALTER TABLE ProductionSchedule ADD INDEX FKProduction560577 (ProductionTypesID), ADD CONSTRAINT FKProduction560577 FOREIGN KEY (ProductionTypesID) REFERENCES ProductionTypes (ID);
ALTER TABLE Orders ADD INDEX FKOrders790135 (StatusID), ADD CONSTRAINT FKOrders790135 FOREIGN KEY (StatusID) REFERENCES Status (ID);
ALTER TABLE OrderItems ADD INDEX FKOrderItems692026 (StatusID), ADD CONSTRAINT FKOrderItems692026 FOREIGN KEY (StatusID) REFERENCES Status (ID);
ALTER TABLE Produce ADD INDEX FKProduce574341 (ProductionTypesID), ADD CONSTRAINT FKProduce574341 FOREIGN KEY (ProductionTypesID) REFERENCES ProductionTypes (ID);
ALTER TABLE Produce ADD INDEX FKProduce605858 (ProduceTypesID), ADD CONSTRAINT FKProduce605858 FOREIGN KEY (ProduceTypesID) REFERENCES ProduceTypes (ID);
ALTER TABLE ProduceTypes ADD INDEX FKProduceTyp752381 (CategoriesID), ADD CONSTRAINT FKProduceTyp752381 FOREIGN KEY (CategoriesID) REFERENCES Categories (ID);
ALTER TABLE Produce ADD INDEX FKProduce490636 (CategoriesID), ADD CONSTRAINT FKProduce490636 FOREIGN KEY (CategoriesID) REFERENCES Categories (ID);
ALTER TABLE Addresses ADD INDEX FKAddresses847999 (AddressTypesID), ADD CONSTRAINT FKAddresses847999 FOREIGN KEY (AddressTypesID) REFERENCES AddressTypes (ID);
ALTER TABLE Pictures ADD INDEX FKPictures591497 (ItemsID), ADD CONSTRAINT FKPictures591497 FOREIGN KEY (ItemsID) REFERENCES Items (ID) ON DELETE Cascade;
ALTER TABLE Orders ADD INDEX FKOrders595018 (BuyersID), ADD CONSTRAINT FKOrders595018 FOREIGN KEY (BuyersID) REFERENCES Buyers (ID) ON DELETE Cascade;
ALTER TABLE ProductionSchedule ADD INDEX FKProduction287967 (FarmersID), ADD CONSTRAINT FKProduction287967 FOREIGN KEY (FarmersID) REFERENCES Farmers (ID) ON DELETE Cascade;
ALTER TABLE Evaluations ADD INDEX FKEvaluation367018 (BuyersID), ADD CONSTRAINT FKEvaluation367018 FOREIGN KEY (BuyersID) REFERENCES Buyers (ID) ON DELETE Cascade;
ALTER TABLE Evaluations ADD INDEX FKEvaluation178914 (ItemsID), ADD CONSTRAINT FKEvaluation178914 FOREIGN KEY (ItemsID) REFERENCES Items (ID) ON DELETE Cascade;
ALTER TABLE Packs ADD INDEX FKPacks245534 (ID), ADD CONSTRAINT FKPacks245534 FOREIGN KEY (ID) REFERENCES Items (ID) ON DELETE Cascade;
ALTER TABLE Produce ADD INDEX FKProduce64966 (ID), ADD CONSTRAINT FKProduce64966 FOREIGN KEY (ID) REFERENCES Items (ID) ON DELETE Cascade;
ALTER TABLE Administrators ADD INDEX FKAdministra284009 (ID), ADD CONSTRAINT FKAdministra284009 FOREIGN KEY (ID) REFERENCES Users (ID) ON DELETE Cascade;
ALTER TABLE Buyers ADD INDEX FKBuyers119792 (ID), ADD CONSTRAINT FKBuyers119792 FOREIGN KEY (ID) REFERENCES Users (ID) ON DELETE Cascade;
ALTER TABLE Farmers ADD INDEX FKFarmers997350 (ID), ADD CONSTRAINT FKFarmers997350 FOREIGN KEY (ID) REFERENCES Users (ID) ON DELETE Cascade;
ALTER TABLE Farmers ADD INDEX FKFarmers308267 (FarmerTypesID), ADD CONSTRAINT FKFarmers308267 FOREIGN KEY (FarmerTypesID) REFERENCES FarmerTypes (ID);
ALTER TABLE Farmers ADD INDEX FarmersFarm (FarmsID), ADD CONSTRAINT FarmersFarm FOREIGN KEY (FarmsID) REFERENCES Farms (ID);
ALTER TABLE OrderItems ADD INDEX OrderItems (ItemsID), ADD CONSTRAINT OrderItems FOREIGN KEY (ItemsID) REFERENCES Items (ID) ON DELETE Cascade;
ALTER TABLE OrderItems ADD INDEX OrderItems2 (OrdersID), ADD CONSTRAINT OrderItems2 FOREIGN KEY (OrdersID) REFERENCES Orders (ID) ON DELETE Cascade;
ALTER TABLE ProducePacks ADD INDEX ProducePacks (PacksID), ADD CONSTRAINT ProducePacks FOREIGN KEY (PacksID) REFERENCES Packs (ID) ON DELETE Cascade;
ALTER TABLE ProducePacks ADD INDEX ProducePacks2 (ProduceID), ADD CONSTRAINT ProducePacks2 FOREIGN KEY (ProduceID) REFERENCES Produce (ID) ON DELETE Cascade;
ALTER TABLE ScheduleStep ADD INDEX ScheduleStep (ProductionStepID), ADD CONSTRAINT ScheduleStep FOREIGN KEY (ProductionStepID) REFERENCES ProductionStep (ID) ON DELETE Cascade;
ALTER TABLE ScheduleStep ADD INDEX ScheduleStep2 (ProductionScheduleID), ADD CONSTRAINT ScheduleStep2 FOREIGN KEY (ProductionScheduleID) REFERENCES ProductionSchedule (ID) ON DELETE Cascade;




-- Trigger
/* ********** Stored proc and Trigger created to implement CHECK constraint in Addresses table
CONSTRAINT CK_FARM_USER_ADDRESS 
    CHECK (CASE WHEN FarmsID IS NULL THEN 0 ELSE 1 END +   CASE WHEN UsersID IS NULL THEN 0 ELSE 1 END = 1) 
************* */
 
/*  create a stored procedure */
USE farmfreshshopping;

DELIMITER $$
	DROP PROCEDURE IF EXISTS check_address_owner$$
    
	CREATE PROCEDURE check_address_owner(IN userId INT(10), IN farmId INT(10))
		BEGIN
			SELECT @uId;
			SELECT @fId;
		
			IF userId = NULL THEN
				SET @uId = 0;
			ELSE
				SET @uId = 1;
			END IF;
			
			IF farmId = NULL THEN
				SET @fId = 0;
			ELSE
				SET @fId = 1;
			END IF;
			
			IF @uId + @fId = 0 OR @uId + @fId = 2 THEN
				SIGNAL SQLSTATE '45000'
					SET MESSAGE_TEXT = 'check constraint check_address_owner on Addresses.UsersID & Addresses.FarmsID failed';
			END IF;
		END$$
 
DELIMITER ;

/*  create triggers before insert and before update */
-- before insert
DELIMITER $$
	DROP TRIGGER IF EXISTS address_before_insert$$

	CREATE TRIGGER address_before_insert BEFORE INSERT ON `Addresses`
	FOR EACH ROW
	BEGIN
		CALL check_address_owner(new.UsersID, new.FarmsID);
	END$$   
DELIMITER ; 

-- before update
DELIMITER $$
	DROP TRIGGER IF EXISTS address_before_update$$
    
	CREATE TRIGGER address_before_update BEFORE UPDATE ON `Addresses`
	FOR EACH ROW
	BEGIN
		CALL check_address_owner(new.UsersID, new.FarmsID);
	END$$   
DELIMITER ;

-- Insert
--*********************** INSERT SOME DATA IN THE DATABASE TABLES ***********************

INSERT INTO Categories (Name, Description, Picture, IsActive) VALUES ('Fruits', 'This is description for Fruits.', 'fruits-cat.png', true);
INSERT INTO Categories (Name, Description, Picture, IsActive) VALUES ('Vegetables', 'This is description for Vegetables.', 'vegetables-cat.png', true);
INSERT INTO Categories (Name, Description, Picture, IsActive) VALUES ('Meat', 'This is description for Meat.', 'meat-cat.png', true);

SELECT * FROM categories;

INSERT INTO UserTypes (Type, Acronym) VALUES ('Farmer', 'F');
INSERT INTO UserTypes (Type, Acronym) VALUES ('Buyer', 'B');
INSERT INTO UserTypes (Type, Acronym) VALUES ('Admin', 'A');

SELECT * FROM UserTypes;

INSERT INTO AddressTypes (Type, Acronym) VALUES ('User', 'U');
INSERT INTO AddressTypes (Type, Acronym) VALUES ('Farm', 'F');

SELECT * FROM AddressTypes;

INSERT INTO FarmerTypes (TypeName, Acronym, Description) VALUES ('Manager', 'M', 'Person who manages all orders and feedbacks');
INSERT INTO FarmerTypes (TypeName, Acronym, Description) VALUES ('Support', 'S', 'Person with less credentials');

SELECT * FROM FarmerTypes;

INSERT INTO ItemTypes (Type, Acronym) VALUES ('Main Produce', 'M');
INSERT INTO ItemTypes (Type, Acronym) VALUES ('Packs', 'P');

SELECT * FROM ItemTypes;

INSERT INTO ProduceTypes (CategoriesID, Name, Description) VALUES ((SELECT ID FROM Categories WHERE Name = 'Fruits'), 'Golden Delicious Green Apple', 'Sweet and mellow, this crisp apple has a tender golden skin, and its flesh stays white after slicing for longer than other apple varieties.');
INSERT INTO ProduceTypes (CategoriesID, Name, Description) VALUES ((SELECT ID FROM Categories WHERE Name = 'Vegetables'), 'Short Cucumber', 'Sometimes this is called the standard or stubby cucumber.');
INSERT INTO ProduceTypes (CategoriesID, Name, Description) VALUES ((SELECT ID FROM Categories WHERE Name = 'Meat'), 'Pork Hocks', 'Smoked Bone In Ham Hocks are perfect for roasting in the oven.');

SELECT * FROM ProduceTypes;

INSERT INTO Status (Code, Description) VALUES ('A', 'Accepted: The order notification is sent to a farmer');
INSERT INTO Status (Code, Description) VALUES ('P', 'Pending: The farmer checks product aviability');
INSERT INTO Status (Code, Description) VALUES ('I', 'In process or Delivering: The product is sent');
INSERT INTO Status (Code, Description) VALUES ('D', 'Delivered: The product is delievered to a buyer');
INSERT INTO Status (Code, Description) VALUES ('C', 'Closed: The product is delievered to a buyer');

SELECT * FROM Status;

INSERT INTO users (UserTypesID,FirstName, LastName,MiddleName, email, Phone,Password,Picture, DateCreated, DateDeleted, IsActif) 
values (2, 'John', 'Doe', null, 'john.doe@test.ca', null, md5('12345'), null, '2018-04-11', null, 1);

INSERT INTO buyers(fbbuyerid) values ('123456789')
