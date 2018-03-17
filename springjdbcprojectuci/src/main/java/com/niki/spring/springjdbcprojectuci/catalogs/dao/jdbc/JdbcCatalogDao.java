package com.niki.spring.springjdbcprojectuci.catalogs.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.niki.spring.springjdbcprojectuci.catalogs.dao.CatalogDao;
import com.niki.spring.springjdbcprojectuci.catalogs.model.Catalog;
import com.niki.spring.springjdbcprojectuci.catalogs.service.CatalogService;
import com.niki.spring.springjdbcprojectuci.catalogs.service.impl.CatalogServiceImpl;
import com.niki.spring.springjdbcprojectuci.common.Util;

public class JdbcCatalogDao implements CatalogDao {

	protected static Logger logger = Logger.getLogger(JdbcCatalogDao.class.getName());
	// SQL statements
		private static final String SQL_INSERT_CATALOG = 
				"INSERT INTO catalog (catalog_id, catalog_name) "
						+ " VALUES (?, ?)";
		private static final String SQL_FIND_CATALOGS = "select * from catalog";
		private static final String SQL_FIND_CATALOG_BY_ID = "select * from catalog where catalog_id = ?";
		private static final String SQL_DELETE_BY_ID = "DELETE from catalog where catalog_id = ?";
		private static final String SQL_UPDATE_CATALOG = "UPDATE catalog SET catalog_name=? where catalog_id=?";

	private DataSource dataSource;

	private CatalogService catalogService;


	public void setCatalogService(CatalogService catalogService) {
		this.catalogService = catalogService;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insertCatalog(Catalog catalog) {
		logger.info("In insertCatalog catalog=" + catalog);
		Connection conn = null;
		try {
			catalog.setCatalog_id(Util.getRandomInt());
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_INSERT_CATALOG);
			ps.setInt(1, catalog.getCatalog_id());
			ps.setString(2, catalog.getCatalog_name());
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

	@Override
	public List<Catalog> findCatalogs() {
		logger.info("all the catalogs: ");
		Connection conn = null;
		List<Catalog> catalogs = new ArrayList<Catalog>();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_CATALOGS);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				catalogs.add(new Catalog(
				rs.getInt("catalog_id"),
				rs.getString("catalog_name")));
			}
			ps.close();
		}catch(SQLException e) {
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
		
		return catalogs;
	}

	@Override
	public Catalog findCatalogById(int catalog_id) {
		logger.info("jdbc list catalog by id "+catalog_id);
		Connection conn = null;
		Catalog catalog=null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_CATALOG_BY_ID);
			ps.setInt(1, catalog_id);
			ResultSet rs = ps.executeQuery();
			boolean flag = rs.isBeforeFirst();
			while(rs.next()) {
			 catalog = new Catalog(rs.getInt("catalog_id"),rs.getString("catalog_name"));
			}
			ps.close();
			rs.close();
		}
		catch(SQLException e) {
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
		logger.info("jdbc listing a catalog by id: " + catalog);
		return catalog;
	}

	@Override
	public void deleteCatalog(int catalog_id) {
		logger.info("jdbc delete catalog by id: "+ catalog_id);
		Connection conn = null;
		Catalog catalog;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_DELETE_BY_ID);
			ps.setInt(1, catalog_id);
			int res = ps.executeUpdate();
		}
		catch(SQLException e) {
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
	
	public void updateCatalog(int catalog_id, String catalog_name) {
		logger.info("jdbc update catalog by id: "+ catalog_id);
		Connection conn = null;
		Catalog catalog;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_CATALOG);
			ps.setString(1, catalog_name);
			ps.setInt(2, catalog_id);
			int res = ps.executeUpdate();
		}
		catch(SQLException e) {
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
