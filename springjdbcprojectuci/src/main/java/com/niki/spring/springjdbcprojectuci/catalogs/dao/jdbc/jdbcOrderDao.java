package com.niki.spring.springjdbcprojectuci.catalogs.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.niki.spring.springjdbcprojectuci.catalogs.dao.OrdersDao;
import com.niki.spring.springjdbcprojectuci.catalogs.service.CatalogService;
import com.niki.spring.springjdbcprojectuci.common.Util;
import com.niki.spring.springjdbcprojectuci.products.model.Orders;

public class jdbcOrderDao implements OrdersDao {
	protected static Logger logger = Logger.getLogger(jdbcProductDao.class.getName());
	// SQL statements
	private static final String SQL_INSERT_ORDER = "INSERT INTO orders (order_id,order_created,order_amount,confirm_number,username)"
			+ " VALUES (?, ?,?,?,?)";
	private static final String SQL_FIND_ORDERS = "select * from orders";
	private static final String SQL_FIND_ORDER_BY_ID = "select * from orders where order_id = ?";
	private static final String SQL_DELETE_BY_ID = "DELETE from orders where order_id = ?";
	private static final String SQL_FIND_ORDER_BY_USERNAME = "select * from orders where username = ?";
	private static final String SQL_USERNAME = "select distinct username from orders";

	private DataSource dataSource;
	private CatalogService catalogService;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public static void setLogger(Logger logger) {
		jdbcOrderDao.logger = logger;
	}

	
	public void setCatalogService(CatalogService catalogService) {
		this.catalogService = catalogService;
	}

	@Override
	public void insertOrder(Orders order)   {
		logger.info("In insertOrder order=" + order);
		Connection conn = null;
		try {
			order.setOrder_id(Util.getRandomInt());
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_INSERT_ORDER);
			ps.setInt(1, order.getOrder_id());
			ps.setString(2, order.getOrder_created());
			ps.setDouble(3, order.getOrder_amount());
			ps.setInt(4, order.getConfirm_number());
			ps.setString(5, order.getUsername());
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
	public List<Orders> findOrders() {
		logger.info("In findOrders");
		Connection conn = null;
		List<Orders> orders = new ArrayList<Orders>();
 System.out.println("======================IN LIST ALL ORDERS   =========================");
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_ORDERS);
			ResultSet rs = ps.executeQuery();
			System.out.println("all orders size: " +rs.getFetchSize());
			while (rs.next()) {
				System.out.println(rs.getInt("order_id")+" "+ rs.getString("order_created") +" " +
						rs.getDouble("order_amount")+ " "+ rs.getInt("confirm_number")+ " "+ rs.getString("username"));
				
				orders.add(new Orders(rs.getInt("order_id"), rs.getString("order_created"), 
						rs.getDouble("order_amount"),rs.getInt("confirm_number"),
						 rs.getString("username")));
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
		logger.info("exit findOrders orders.size=" + (orders != null?orders.size():0));
		return orders;
	}

	@Override
	public Orders findOrderById(int order_id) {
		logger.info("In findOrderById order_id=" + order_id);
		Connection conn = null;
		Orders order = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_ORDER_BY_ID);
			ps.setInt(1,  order_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				order  = new Orders(
						rs.getInt("order_id"), rs.getString("order_created"), 
								rs.getDouble("order_amount"),rs.getInt("confirm_number"),
								 rs.getString("username"));
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
		logger.info("exit findByOrderID order = " + order);
		return order;
	}

	@Override
	public void deleteOrder(int order_id) {
		// TODO Auto-generated method stub
		logger.info("In deleteOrder order=" + order_id);
		Connection conn = null;
		Orders order= null;
		try {
			order.setOrder_id(order_id);
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_DELETE_BY_ID);
			ps.setInt(1, order_id);		
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
	public List<Orders> findOrdersByUserName(String username) {
		logger.info("In findOrdersByUserName username=" + username);
		Connection conn = null;
		List<Orders> orders = new ArrayList<Orders>();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_ORDER_BY_USERNAME);
			ps.setString(1,  username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			orders.add(	 new Orders(
						rs.getInt("order_id"), rs.getString("order_created"), 
								rs.getDouble("order_amount"),rs.getInt("confirm_number"),
								 rs.getString("username")));
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
		logger.info("exit findOrders orders.size=" + (orders != null?orders.size():0));
		return orders;
	}

	@Override
	public List<String> getUserName() {
		logger.info("In findOrdersDistinct UserName");
		Connection conn = null;
		List<String> userNameList = new ArrayList<String>();
 System.out.println("======================IN LIST ALL ORDERS   =========================");
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_USERNAME);
			ResultSet rs = ps.executeQuery();
			System.out.println("all userNameList size: " +rs.getFetchSize());
			while (rs.next()) {
				System.out.println(rs.getString("username"));
				
				userNameList.add(rs.getString("username"));
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
		logger.info("exit getUserName userNameList.size=" + (userNameList != null?userNameList.size():0));
		return userNameList;
	}

}
