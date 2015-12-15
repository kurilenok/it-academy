package org.numisoft.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Main {

	public static void main(String[] args) {

		try (Connection connection = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test", "root", "root")) {

			/* SELECT 1: price > 300 */
			String template1 = "SELECT * FROM books WHERE price > ?";

			PreparedStatement pStatement1 = (PreparedStatement) connection
					.prepareStatement(template1);
			pStatement1.setInt(1, 300);
			ResultSet result = pStatement1.executeQuery();

			System.out.println("Books that cost more than 300 usd:");
			System.out.println("===============================");

			while (result.next()) {
				System.out.print(result.getString(2) + " - ");
				System.out.print("price: " + result.getString(4));
				System.out.println(", pages: " + result.getString(5));
			}

			System.out.println("--------------------------");
			Statement statement = (Statement) connection.createStatement();
			result = statement.executeQuery("SELECT SUM(price) from books");
			while (result.next()) {
				System.out.println("Total price of all books: " + result.getInt(1));
			}

			/* SELECT 2: pages < 400 */
			String template2 = "SELECT * FROM books WHERE pages < ?";
			PreparedStatement pStatement2 = (PreparedStatement) connection
					.prepareStatement(template2);
			pStatement2.setInt(1, 400);

			result = pStatement2.executeQuery();

			System.out.println("");
			System.out.println("Books with less than 400 pages:");
			System.out.println("===============================");
			while (result.next()) {
				System.out.print(result.getString(2) + " - ");
				System.out.print("price: " + result.getString(4));
				System.out.println(", pages: " + result.getString(5));
			}

			result.close();
			statement.close();
			pStatement1.close();
			pStatement2.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
