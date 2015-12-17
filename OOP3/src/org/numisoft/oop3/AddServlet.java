package org.numisoft.oop3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.numisoft.oop3.dao.PeriodicalDaoImpl;

public class AddServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String priceString = request.getParameter("price");

		if (title.equalsIgnoreCase("") || priceString.equalsIgnoreCase("")) {
			response.sendRedirect("/OOP3/index");
		}

		int price = Integer.parseInt(priceString);
		PeriodicalDaoImpl pdi = new PeriodicalDaoImpl();
		pdi.addPeriodical(DBHelper.getConnection(), title, price);

		response.sendRedirect("/OOP3/index");

	}
}
