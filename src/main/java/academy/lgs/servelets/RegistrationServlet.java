package academy.lgs.servelets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academy.lgs.domain.User;
import academy.lgs.domain.UserRole;
import academy.lgs.service.UserService;
import academy.lgs.service.impl.UserServiceImpl;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email").toLowerCase();
		String password = request.getParameter("password");

		if (!email.isEmpty() && !userService.toFindUser(email) && !firstName.isEmpty() && !lastName.isEmpty()
				&& !password.isEmpty()) {
			userService.create(new User(firstName, lastName, email, password ,UserRole.USER.toString()));
			request.setAttribute("userEmail", email);
			request.getRequestDispatcher("cabinet.jsp").forward(request, response);
		}

		else {
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}

	}

}