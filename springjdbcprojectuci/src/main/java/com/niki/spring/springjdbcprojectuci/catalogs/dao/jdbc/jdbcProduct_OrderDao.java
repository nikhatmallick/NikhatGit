package com.niki.spring.springjdbcprojectuci.catalogs.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.niki.spring.springjdbcprojectuci.catalogs.dao.Product_OrderDao;
import com.niki.spring.springjdbcprojectuci.catalogs.service.CatalogService;
import com.niki.spring.springjdbcprojectuci.common.Util;
import com.niki.spring.springjdbcprojectuci.products.model.Orders;
import com.niki.spring.springjdbcprojectuci.products.model.Product_Order;

public class jdbcProduct_OrderDao implements Product_OrderDao {
	protected static Logger logger = Logger.getLogger(jdbcProductDao.class.getName());
	// SQL statements
	private static final String SQL_INSERT_PORDER = "INSERT INTO Product_Order (product_order_id, order_id, product_id, order_amount)"
			+ " VALUES (?, ?,?,?)";
	private static final String SQL_FIND_PORDERS = "select * from Product_Order";
	private static final String SQL_FIND_PORDER_BY_ID = "select * from Product_Order where product_order_id = ?";
	private static final String SQL_DELETE_BY_ID = "DELETE from Product_Order where product_order_id = ?";
	private static final String SQL_FIND_PORDER_BY_ProdID = "select * from Product_Order where product_id = ?";

	private DataSource dataSource;
	private CatalogService catalogService;

	public static void setLogger(Logger logger) {
		jdbcProduct_OrderDao.logger = logger;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setCatalogService(CatalogService catalogService) {
		this.catalogService = catalogService;
	}

	@Override
	public void insertProduct_Order(Product_Order product_order) {
		// TODO Auto-generated method stub
		logger.info("In insertProduct_Order product_order=" + product_order);
		Connection conn = null;
		try {
			product_order.setProduct_order_id(Util.getRandomInt());
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_INSERT_PORDER);
			ps.setInt(1, product_order.getProduct_order_id());
			ps.setInt(2, product_order.getOrder_id());
			ps.setInt(3, product_order.getProduct_id());
			ps.setInt(4, product_order.getOrder_amount());
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
	public List<Product_Order> findProduct_Orders() {
		logger.info("In findProduct_Order");
		Connection conn = null;
		List<Product_Order> prodords = new ArrayList<Product_Order>();
 System.out.println("======================IN LIST ALL findProduct_Order   =========================");
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_PORDERS);
			ResultSet rs = ps.executeQuery();
			System.out.println("all product_order size: " +rs.getFetchSize());
			while (rs.next()) {
				System.out.println(rs.getInt("product_order_id")+" "+ rs.getInt("order_id") +" " +
						rs.getInt("product_id")+ " "+ rs.getDouble("order_amount"));
				
				prodords.add(new Product_Order(rs.getInt("product_order_id"), rs.getInt("order_id"), 
						rs.getInt("product_id"),rs.getInt("order_amount")));
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
		logger.info("exit findProduct_Order prodords.size=" + (prodords != null?prodords.size():0));
		return prodords;

	}

	@Override
	public Product_Order findProduct_OrderById(int product_order_id) {
		logger.info("In findProduct_OrderById product_order_id=" + product_order_id);
		Connection conn = null;
		Product_Order porder = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_PORDER_BY_ID);
			ps.setInt(1,  product_order_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				porder  = new Product_Order(
						rs.getInt("product_order_id"), rs.getInt("order_id"), 
								rs.getInt("product_id"),rs.getInt("order_amount"));
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
		logger.info("exit findProduct_OrderById porder = " + porder);
		return porder;
	}



}
