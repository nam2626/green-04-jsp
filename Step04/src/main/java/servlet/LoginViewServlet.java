package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginViewServlet
 */
@WebServlet("/loginView")
public class LoginViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginViewServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/02_login.jsp")
			.forward(request, response);
	}

}











