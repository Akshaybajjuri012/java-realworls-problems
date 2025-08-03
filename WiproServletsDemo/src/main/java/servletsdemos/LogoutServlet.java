package servletsdemos;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HttpSession session = request.getSession(false);
    if (session != null) {
      session.invalidate();
    }

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<h3>You have been logged out.</h3>");
    out.println("<a href='login.html'>Login Again</a>");
  }
}
