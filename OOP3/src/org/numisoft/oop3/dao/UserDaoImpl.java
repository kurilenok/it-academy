package org.numisoft.oop3.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.numisoft.oop3.dto.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUserById(Connection connection, int id) {

		User user = new User();

		try {
			String template = "select * from users where id=" + id + ";";

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(template);

			if (result.next() == true) {
				user.setId(result.getInt("id"));
				user.setFirst_name(result.getString("first_name"));
				user.setLast_name(result.getString("last_name"));
				user.setUsername(result.getString("username"));
				user.setRole_id(result.getInt("role_id"));
			}

			result.close();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public int authenticate(Connection connection, String username, String password) {

		String correctPassword = "";
		int id = 0;

		try {
			String template = "select * from users where username='" + username + "';";

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(template);

			if (result.next() == true) {
				correctPassword = result.getString("password");
				if (correctPassword.equals(password)) {
					id = result.getInt("id");
				}
			}

			result.close();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;

	}

}
