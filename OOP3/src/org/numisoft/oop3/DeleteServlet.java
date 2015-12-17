package org.numisoft.oop3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.numisoft.oop3.dao.PeriodicalDaoImpl;

public class DeleteServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		PeriodicalDaoImpl pdi = new PeriodicalDaoImpl();
		pdi.deletePeriodical(DBHelper.getConnection(), id);

		response.sendRedirect("/OOP3/index");

	}

}
