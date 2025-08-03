package servletsdemos;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    String accNo = request.getParameter("accNo");
    String password = request.getParameter("password");

   
    if (accNo.equals("12345") && password.equals("pass")) {
      HttpSession session = request.getSession();
      session.setAttribute("name", "John Doe");
      session.setAttribute("balance", 15000.0);

      response.sendRedirect("BalanceServlet");
    } else {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      out.println("<h3>Invalid credentials!</h3>");
    }
  }
}
