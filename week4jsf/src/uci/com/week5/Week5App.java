package uci.com.week5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;

public class Week5App {
	static final String dbUrl ="jdbc:mysql://localhost:3306/mydb";
	static final String username = "root";
	static final String password = "test";
	
	public static void main(String[] args) throws ClassNotFoundException {
		String id, lastname, firstname,mi,address,city,state,telephone,email;
		Scanner sc = new Scanner(System.in);
	//	sc.useDelimiter("[\n\\s,]");
		System.out.print("Enter id: ");
		id = sc.nextLine();
		System.out.print("Enter lastname: ");
		lastname = sc.nextLine();
		System.out.print("Enter firstname: ");
		firstname = sc.nextLine();
		System.out.print("Enter mi: ");
		mi = sc.nextLine();
		System.out.print("Enter address: ");
		address = sc.nextLine();
		System.out.print("Enter city: ");
		city = sc.nextLine();
		System.out.print("Enter state: ");
		state = sc.nextLine();
		System.out.print("Enter telephone: ");
		telephone = sc.nextLine();
		System.out.print("Enter email: ");
		email = sc.nextLine();
		System.out.println("hello niki");
		String sql = "insert into Staff values (?,?,?,?,?,?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dbUrl, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, lastname);
			pstmt.setString(3, firstname);
			pstmt.setString(4, mi);
			pstmt.setString(5,address);
			pstmt.setString(6, city);
			pstmt.setString(7, state);
			pstmt.setString(8, telephone);
			pstmt.setString(9, email);
			int res = pstmt.executeUpdate();
			if(res ==1) {
				System.out.println("record inserted successfullly");
			}
			else
				System.out.println("record not executed");
			sc.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
