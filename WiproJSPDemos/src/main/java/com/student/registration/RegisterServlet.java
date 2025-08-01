package com.student.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String profession = request.getParameter("profession");
		String married = request.getParameter("married") != null ? "Yes" : "No";
		String note = request.getParameter("note");
		out.println("<html><body>");
		out.println("<h2>Registration Successful</h2>");
		out.println("<p><strong>Name:</strong> " + fullname + "</p>");
		out.println("<p><strong>Email:</strong> " + email + "</p>");
		out.println("<p><strong>Password:</strong> " + password + "</p>");
		out.println("<p><strong>Birthday:</strong> " + birthday + "</p>");
		out.println("<p><strong>Gender:</strong> " + gender + "</p>");
		out.println("<p><strong>Profession:</strong> " + profession + "</p>");
		out.println("<p><strong>Married:</strong> " + married + "</p>");
		out.println("<p><strong>Note:</strong> " + note + "</p>");
		out.println("</body></html>");

	}

}
