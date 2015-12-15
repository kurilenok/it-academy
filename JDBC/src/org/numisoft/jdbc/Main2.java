package org.numisoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2 {

	static String[] array = new String[5];

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try (

		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/periodicals", "root", "root")) {

			String template = "SELECT * FROM users";

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(template);

			System.out.println("Users:");
			System.out.println("===============================");

			int i = 0;
			while (result.next()) {
				array[i] = result.getString(2);
				System.out.println(array[i]);
				i++;
				// System.out.println();
			}

			// System.out.println("--------------------------");
			// Statement statement = (Statement) connection.createStatement();
			// result = statement.executeQuery("SELECT SUM(price) from books");
			// while (result.next()) {
			// System.out.println("Total price of all books: " +
			// result.getInt(1));
			// }
			//
			// /* SELECT 2: pages < 400 */
			// String template2 = "SELECT * FROM books WHERE pages < ?";
			// PreparedStatement pStatement2 =
			// connection.prepareStatement(template2);
			// pStatement2.setInt(1, 400);
			//
			// result = pStatement2.executeQuery();
			//
			// System.out.println("");
			// System.out.println("Books with less than 400 pages:");
			// System.out.println("===============================");
			// while (result.next()) {
			// System.out.print(result.getString(2) + " - ");
			// System.out.print("price: " + result.getString(4));
			// System.out.println(", pages: " + result.getString(5));
			// }

			result.close();
			// statement.close();
			statement.close();
			// pStatement2.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
