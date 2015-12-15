package org.numisoft.oop3.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.numisoft.oop3.dto.Periodical;

public class PeriodicalDaoImpl implements PeriodicalDao {

	@Override
	public Periodical getPeriodicalByid(int id) {
		return null;
	}

	@Override
	public List<Periodical> getAllPeriodicals(Connection connection) {

		List<Periodical> periodicals = new ArrayList<Periodical>();

		try {
			String template = "select * from periodicals;";

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(template);

			while (result.next()) {
				Periodical periodical = new Periodical();
				periodical.setId(result.getInt("id"));
				periodical.setTitle(result.getString("title"));
				periodical.setPrice(result.getInt("price"));
				periodicals.add(periodical);
			}

			result.close();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return periodicals;
	}

}
