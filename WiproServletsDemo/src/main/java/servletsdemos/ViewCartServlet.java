package servletsdemos;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ViewCartServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    Cookie[] cookies = request.getCookies();

    out.println("<html><body>");
    out.println("<h2>Your Cart Items:</h2>");

    boolean hasItems = false;

    if (cookies != null) {
      for (Cookie c : cookies) {
        if (c.getName().startsWith("item")) {
          out.println("<li>" + c.getValue() + "</li>");
          hasItems = true;
        }
      }
    }

    if (!hasItems) {
      out.println("<p>Your cart is empty.</p>");
    }

    out.println("<br><a href='items.html'>Back to Items</a>");
    out.println("</body></html>");
  }
}
