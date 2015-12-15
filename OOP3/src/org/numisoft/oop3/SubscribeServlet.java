package org.numisoft.oop3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.numisoft.oop3.dao.SubscriptionDaoImpl;

public class SubscribeServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		HttpSession session = request.getSession(false);
		int user_id = (int) session.getAttribute("user_id");

		SubscriptionDaoImpl sdi = new SubscriptionDaoImpl();
		sdi.addSubscription(DBHelper.getConnection(), user_id, id);

		response.sendRedirect("/OOP3/index");

	}

}
