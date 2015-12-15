package org.numisoft.oop3;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.numisoft.oop3.dao.PeriodicalDaoImpl;
import org.numisoft.oop3.dao.SubscriptionDaoImpl;
import org.numisoft.oop3.dto.Periodical;
import org.numisoft.oop3.dto.Subscription;
import org.numisoft.oop3.dto.User;

public class IndexServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PeriodicalDaoImpl pdi = new PeriodicalDaoImpl();
		List<Periodical> ps = pdi.getAllPeriodicals(DBHelper.getConnection());
		request.setAttribute("periodicals", ps);

		User user = new User();
		// user.setFirst_name("Darth");
		// user.setLast_name("Vader");
		// HttpSession session = request.getSession(true);
		// session.setAttribute("user", user);
		// session.setAttribute("user_id", 1);

		HttpSession session = request.getSession();
		user = (User) session.getAttribute("user");
		session.setAttribute("user_id", user.getId());

		SubscriptionDaoImpl sdi = new SubscriptionDaoImpl();
		List<Subscription> subscriptions = sdi
				.getSubscriptionByUser(DBHelper.getConnection(), user);
		request.setAttribute("subscriptions", subscriptions);

		RequestDispatcher dispatcher = request.getRequestDispatcher("subscriptions.jsp");
		dispatcher.forward(request, response);

	}
}
