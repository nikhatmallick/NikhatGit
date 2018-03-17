CREATE TABLE IF NOT EXISTS catalog ( 
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
        uom CHAR(45) INT NOT NULL DEFAULT '',
        PRIMARY KEY (product_id),
        FOREIGN KEY(catalog_id) REFERENCES catalog(catalog_id) 
        );
        
CREATE TABLE IF NOT EXISTS order ( 
        order_id INT NOT NULL, 
        order_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
        total_amount INT NOT NULL DEFAULT 0, 
        confirm_number INT NOT NULL DEFAULT 0, 
        user CHAR(64) NOT NULL DEFAULT '',
        PRIMARY KEY (order_id) 
        );
        
CREATE TABLE IF NOT EXISTS product_order ( 
        product_order_id INT NOT NULL, 
        order_id INT NOT NULL, 
        product_id INT NOT NULL DEFAULT 0, 
        order_amount INT NOT NULL DEFAULT 0, 
        PRIMARY KEY (product_order_id),
        FOREIGN KEY(order_id) REFERENCES order(order_id),
        FOREIGN KEY(product_id) REFERENCES product(product_id)
        );