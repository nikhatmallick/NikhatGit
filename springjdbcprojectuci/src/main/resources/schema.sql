CREATE TABLE IF NOT EXISTS CATALOG ( 
		catalog_id INT NOT NULL, 
        catalog_name CHAR(32) NOT NULL,
        PRIMARY KEY (catalog_id)
        );
        
CREATE TABLE IF NOT EXISTS product ( 
        product_id INT NOT NULL, 
        catalog_id INT NOT NULL, 
        sku CHAR(32) NOT NULL, 
        product_name CHAR(128) NOT NULL DEFAULT '', 
        available_quantity INT NOT NULL DEFAULT 1,
        uom CHAR(45)  NOT NULL DEFAULT '',
        PRIMARY KEY (product_id),
        FOREIGN KEY(catalog_id) REFERENCES catalog(catalog_id) 
        );

 CREATE TABLE IF NOT EXISTS orders( 
        order_id INT NOT NULL, 
        order_created Char(15) DEFAULT NULL, 
        order_amount INT  DEFAULT NULL, 
        confirm_number INT DEFAULT NULL, 
        username CHAR(64) NOT NULL DEFAULT 'Niki',
        PRIMARY KEY(order_id) 
        );
        
CREATE TABLE IF NOT EXISTS product_order ( 
        product_order_id INT NOT NULL, 
        order_id INT NOT NULL, 
        product_id INT NOT NULL DEFAULT 0, 
        order_amount INT NOT NULL DEFAULT 0, 
        PRIMARY KEY (product_order_id),
        FOREIGN KEY(order_id) REFERENCES orders(order_id)
        );

        
        
       
