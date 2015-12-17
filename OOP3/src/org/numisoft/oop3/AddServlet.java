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

		if (title.equalsIgnoreCase("")) {
			response.sendRedirect("/OOP3/index");
		} else if (priceString.equalsIgnoreCase("")) {
			response.sendRedirect("/OOP3/index");
		} else {

			int price = 0;
			try {
				price = Integer.parseInt(priceString);
			} catch (NumberFormatException e) {

			}
			PeriodicalDaoImpl pdi = new PeriodicalDaoImpl();
			pdi.addPeriodical(DBHelper.getConnection(), title, price);

			response.sendRedirect("/OOP3/index");
		}

	}
}
