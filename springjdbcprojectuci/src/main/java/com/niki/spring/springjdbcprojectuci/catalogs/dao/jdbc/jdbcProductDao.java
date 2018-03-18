package com.niki.spring.springjdbcprojectuci.catalogs.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.niki.spring.springjdbcprojectuci.catalogs.dao.ProductDao;
import com.niki.spring.springjdbcprojectuci.catalogs.service.CatalogService;
import com.niki.spring.springjdbcprojectuci.catalogs.service.impl.CatalogServiceImpl;
import com.niki.spring.springjdbcprojectuci.common.Util;
import com.niki.spring.springjdbcprojectuci.products.model.Product;
import com.niki.spring.springjdbcprojectuci.catalogs.model.Catalog;
import com.niki.spring.springjdbcprojectuci.catalogs.dao.jdbc.JdbcCatalogDao;

public class jdbcProductDao implements ProductDao {
	protected static Logger logger = Logger.getLogger(jdbcProductDao.class.getName());
	// SQL statements
	private static final String SQL_INSERT_PRODUCT = "INSERT INTO product (product_id, catalog_id,sku,product_name,available_quantity,uom) "
			+ " VALUES (?, ?,?,?,?,?)";
	private static final String SQL_FIND_PRODUCTS = "select * from product";
	private static final String SQL_FIND_PRODUCT_BY_ID = "select * from product where product_id = ?";
	private static final String SQL_DELETE_BY_ID = "DELETE from product where product_id = ?";
	private static final String SQL_FIND_PRODUCTS_BY_CATALOG_ID = "select * from product where catalog_id = ?";
	private static final String SQL_UPDATE_PRODUCT = 
			"UPDATE product SET catalog_id = ?, sku=?,product_name=?,available_quantity=?, uom=?  WHERE product_id = ?";

	private DataSource dataSource;
	public static void setLogger(Logger logger) {
		jdbcProductDao.logger = logger;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private CatalogService catalogService;
	public void setCatalogService(CatalogService catalogService) {
		this.catalogService = catalogService;
	}

	
	@Override
	public void insertProduct(Product product)  {
		logger.info("In insertProduct product=" + product);
		Connection conn = null;
		try {
			product.setProduct_id(Util.getRandomInt());
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_INSERT_PRODUCT);
			ps.setInt(1, product.getProduct_id());
			ps.setInt(2, product.getCatalog().getCatalog_id());
			ps.setString(3, product.getSku());
			ps.setString(4, product.getProduct_name());
			ps.setInt(5, product.getAvailable_quantity());
			ps.setString(6, product.getUom());
			ps.executeUpdate();
			ps.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
	}
	}

	@Override
	public List<Product> findProducts() {
		logger.info("In findproducts");
		Connection conn = null;
		List<Product> products = new ArrayList<Product>();
 System.out.println("======================IN LIST ALL PRODUCTS   =========================");
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_PRODUCTS);
			ResultSet rs = ps.executeQuery();
			System.out.println("all products size: " +rs.getFetchSize());
			while (rs.next()) {
				System.out.println(rs.getInt("product_id")+" "+ rs.getString("sku") +" " +
						rs.getString("product_name")+ " "+ rs.getInt("available_quantity")+ " "+ rs.getString("uom")+ " "+
						catalogService.getCatalog(rs.getInt("catalog_id")));
				
				products.add(new Product(rs.getInt("product_id"), rs.getString("sku"), 
						rs.getString("product_name"),rs.getInt("available_quantity"),
						rs.getString("uom"), catalogService.getCatalog(rs.getInt("catalog_id"))));
			}
			rs.close();
			ps.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
		logger.info("exit findProducts products.size=" + (products != null?products.size():0));
		return products;
	}

	@Override
	public Product findProductById(int product_id) {
		logger.info("In findProductById product_id=" + product_id);
		Connection conn = null;
		Product product = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_PRODUCT_BY_ID);
			ps.setInt(1,  product_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				product  = new Product(
						rs.getInt("product_id"),rs.getString("sku"),
						rs.getString("product_name"),rs.getInt("available_quantity"),
						rs.getString("uom"),catalogService.getCatalog(rs.getInt("catalog_id")));
			}
			rs.close();
			ps.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {}
			}
		}
		logger.info("exit findByProductID product = " + product);
		return product;
	}

	

	@Override
	public List<Product> findProductsByCatalog(Catalog catalog) {
		logger.info("In findProducstByCatalog catalog=" + catalog);
		Connection conn = null;
		List<Product> products = new ArrayList<Product>();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_PRODUCTS_BY_CATALOG_ID);
			ps.setInt(1,  catalog.getCatalog_id());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				   products.add(new Product(rs.getInt("product_id"),rs.getString("sku"),
						   rs.getString("product_name"),rs.getInt("available_quantity"),
						rs.getString("uom"),catalogService.getCatalog(rs.getInt("catalog_id"))));
			}
			rs.close();
			ps.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {}
			}
		}
		logger.info("exit findProductsByCatalog products.size = " + (products != null? products.size():0));
		return products;
	}
	@Override
	public void deleteProductbyId(int  product_id) {
		logger.info("In deleteProductbyId product_id=" + product_id);
		Connection conn = null;
		Product product = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_DELETE_BY_ID);
			ps.setInt(1,product_id);
			int flag = ps.executeUpdate();
			ps.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {}
			}
		}
		logger.info("exit deleteProductbyId  product deleted"  );
	}
	@Override
	public void updateProduct(int product_id, Product product) {
		logger.info("In updateProduct: product_id=" + product_id + ", product=" + product);
		Connection conn = null;
 
		System.out.println("jdbc product update info: "+ product);
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_PRODUCT);
			ps.setInt(1,product.getCatalog().getCatalog_id());
			ps.setString(2, product.getSku());
			ps.setString(3, product.getProduct_name());
			ps.setInt(4, product.getAvailable_quantity());
			ps.setString(5, product.getUom());
			ps.setInt(6, product_id);
			ps.executeUpdate();
			ps.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

}
