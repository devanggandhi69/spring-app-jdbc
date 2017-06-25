package com.springapp.threepage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class DBConnectionImpl implements DBConnection {

	Connection con;

	@Override
	public Connection getconnection() {
		String driverName = "com.mysql.jdbc.Driver";
		String username = "root";
		String password = "root1234";
		String urlstring = "jdbc:mysql://localhost:3306/threepage";

		try {
			Class.forName(driverName);
			try {
				con = DriverManager.getConnection(urlstring, username, password);
			} catch (SQLException ex) {
				// log an exception. fro example:
				System.out.println("Failed to create the database connection.");
			}
		} catch (ClassNotFoundException ex) {
			// log an exception. for example:
			System.out.println("Driver not found.");
		}
		return con;
	}

}
