package com.uciext.springfw.class05.courses.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.uciext.springfw.class05.common.Util;
import com.uciext.springfw.class05.courses.dao.DepartmentDao;
import com.uciext.springfw.class05.courses.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {

	protected static Logger logger = Logger.getLogger(JdbcDepartmentDao.class.getName());

	// SQL statements
	private static final String SQL_INSERT_DEPARTMENT = 
			"INSERT INTO departments (department_id, department_name) VALUES (?, ?)";
	private static final String SQL_FIND_DEPARTMENTS = 
			"SELECT * FROM departments";
	private static final String SQL_FIND_DEPARTMENT_BY_ID = 
			"SELECT * FROM departments WHERE department_id = ?";
	
	// Datasource
	private DataSource dataSource;
	 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
 
	//=================================================
	// DB methods

	// Department
	@Override
	public void insertDepartment(Department department) {
		logger.info("In insertDepartment department=" + department);
		Connection conn = null;
 
		try {
			department.setDepartmentId(Util.getRandomInt());

			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_INSERT_DEPARTMENT);
			ps.setInt(1, department.getDepartmentId());
			ps.setString(2, department.getDepartmentName());
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
	public Department findDepartmentById(int departmentId) {
		logger.info("In findByDepartmentId departmentId=" + departmentId);
		Connection conn = null;
		Department department = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_DEPARTMENT_BY_ID);
			ps.setInt(1, departmentId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				department = new Department(
					rs.getInt("department_id"),
					rs.getString("department_name")
				);
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
		logger.info("exit findByDepartmentId department=" + department);
		return department;
	}
	
	@Override
	public List<Department> findDepartments() {
		logger.info("In findDepartments");
		Connection conn = null;
		List<Department> departments = new ArrayList<Department>();
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_DEPARTMENTS);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				departments.add(new Department(
					rs.getInt("department_id"),
					rs.getString("department_name")
				));
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
		logger.info("exit findDepartments departments.size=" + (departments != null ? departments.size() : 0));
		return departments;
	}

}
