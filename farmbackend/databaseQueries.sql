CREATE DATABASE farmfreshshopping;

USE farmfreshshopping;

CREATE TABLE category (
	id int NOT NULL AUTO_INCREMENT,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	PRIMARY KEY (id) 
);

INSERT INTO category (name, description,image_url,is_active) VALUES ('Fruits', 'This is description for Laptop Fruits.', 'CAT_1.png', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('Vegetables', 'This is description for Television Vegetables.', 'CAT_2.png', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('Meat', 'This is description for Mobile Meat.', 'CAT_3.png', true);


CREATE TABLE user_detail (
	id int NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(60),
	email VARCHAR(100),
	contact_number VARCHAR(15),	
	PRIMARY KEY(id)
);

INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Amrinder', 'K', 'ADMIN', true, 'admin', 'ak@gmail.com', '8888888888');

INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Julia', 'M', 'SUPPLIER', true, '12345', 'jm@gmail.com', '9999999999');

INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Joseph', 'K', 'SUPPLIER', true, '12345', 'jk@gmail.com', '7777777777');


CREATE TABLE product (
	id int NOT NULL AUTO_INCREMENT,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	PRIMARY KEY (id),
 	FOREIGN KEY (category_id) REFERENCES category (id),
	FOREIGN KEY (supplier_id) REFERENCES user_detail(id)
);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABC123DEFX', 'Chicken', 'Costco', 'This is one of the best quality chicken available in the market right now!', 180, 5, true, 3, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDDEF123DEFX', 'Pork', 'Walmart', 'The fresh pork by Walmart!', 320, 2, true, 3, 3 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDPQR123WGTX', 'Fish', 'Nofrills', 'This is one of the best Fish available in the market right now!', 570, 5, true, 3, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDMNO123PQRX', 'Apple', 'Costco', 'This is one of the best Apples available in the market right now!', 540, 3, true, 1, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABCXYZDEFX', 'Oranges', 'Walmart', 'This is one of the best Orange from walmart that can be consumed', 480, 5, true, 1, 3 );

CREATE TABLE address (
	id int NOT NULL AUTO_INCREMENT,
	user_id int,
	address_line_one VARCHAR(100),
	address_line_two VARCHAR(100),
	city VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20),
	postal_code VARCHAR(10),
	is_billing BOOLEAN,
	is_shipping BOOLEAN,
	FOREIGN KEY (user_id ) REFERENCES user_detail (id),
	PRIMARY KEY (id)
);

CREATE TABLE cart (
	id int NOT NULL AUTO_INCREMENT,
	user_id int,
	grand_total DECIMAL(10,2),
	cart_lines int,
	FOREIGN KEY (user_id ) REFERENCES user_detail (id),
	PRIMARY KEY (id)
);

CREATE TABLE cart_line (
	id int NOT NULL AUTO_INCREMENT,
	cart_id int,
	total DECIMAL(10,2),
	product_id int,
	product_count int,
	buying_price DECIMAL(10,2),
	is_available boolean,
	FOREIGN KEY (product_id ) REFERENCES product (id),
	PRIMARY KEY (id)
);

CREATE TABLE order_detail (
	id int NOT NULL AUTO_INCREMENT,
	user_id int,
	order_total DECIMAL(10,2),
	order_count int,
	shipping_id int,
	billing_id int,
	order_date date,
	FOREIGN KEY (user_id) REFERENCES user_detail (id),
	FOREIGN KEY (shipping_id) REFERENCES address (id),
	FOREIGN KEY (billing_id) REFERENCES address (id),
	PRIMARY KEY (id)
);

CREATE TABLE order_item (
	id int NOT NULL AUTO_INCREMENT,
	order_id int,
	total DECIMAL(10,2),
	product_id int,
	product_count int,
	buying_price DECIMAL(10,2),
	FOREIGN KEY (product_id) REFERENCES product (id),
	FOREIGN KEY (order_id) REFERENCES order_detail (id),
	PRIMARY KEY (id)
);