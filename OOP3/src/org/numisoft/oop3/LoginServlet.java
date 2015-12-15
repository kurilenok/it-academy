package org.numisoft.oop3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.numisoft.oop3.dao.UserDaoImpl;
import org.numisoft.oop3.dto.User;

public class LoginServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserDaoImpl udi = new UserDaoImpl();

		int id = udi.authenticate(DBHelper.getConnection(), username, password);

		if (id > 0) {

			User user = udi.getUserById(DBHelper.getConnection(), id);
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			response.sendRedirect("/OOP3/index");
		} else {
			response.sendRedirect("/OOP3/error.jsp");
		}

	}
}
