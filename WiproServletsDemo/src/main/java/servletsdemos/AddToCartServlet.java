package servletsdemos;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class AddToCartServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String item = request.getParameter("item");

    if (item != null && !item.isEmpty()) {
      Cookie cookie = new Cookie("item" + System.currentTimeMillis(), item);
      cookie.setMaxAge(60 * 60); // 1 hour
      response.addCookie(cookie);
    }

    out.println("<html><body>");
    out.println("<h3>" + item + " added to cart!</h3>");
    out.println("<a href='items.html'>Add More</a><br>");
    out.println("<a href='ViewCartServlet'>View Cart</a>");
    out.println("</body></html>");
  }
}
