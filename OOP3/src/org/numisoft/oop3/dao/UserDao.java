package org.numisoft.oop3.dao;

import java.sql.Connection;

import org.numisoft.oop3.dto.User;

public interface UserDao {

	public User getUserById(Connection connection, int id);

	public int authenticate(Connection connection, String username, String password);

}
