package org.numisoft.oop3.dao;

import java.sql.Connection;
import java.util.List;

import org.numisoft.oop3.dto.Periodical;

public interface PeriodicalDao {

	public Periodical getPeriodicalByid(int id);

	public List<Periodical> getAllPeriodicals(Connection connection);

	public void addPeriodical(Connection connection, String title, int price);

	public void deletePeriodical(Connection connection, int id);

}
