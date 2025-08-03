package servletsdemos;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class BalanceServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    HttpSession session = request.getSession(false);

    if (session != null && session.getAttribute("name") != null) {
      String name = (String) session.getAttribute("name");
      double balance = (double) session.getAttribute("balance");

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      out.println("<h2>Welcome, " + name + "</h2>");
      out.println("Account Balance: ₹" + balance + "<br><br>");
      out.println("<a href='LogoutServlet'>Logout</a>");
    } else {
      response.sendRedirect("login.html");
    }
  }
}
