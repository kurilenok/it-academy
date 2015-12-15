package org.numisoft.oop3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

	private static final String URL = "jdbc:mysql://localhost:3306/periodicals";
	private static final String LOGIN = "root";
	private static final String PASSWORD = "root";

	public static Connection getConnection() {

		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
		} catch (SQLException e) {
		}
		return connection;
	}
}