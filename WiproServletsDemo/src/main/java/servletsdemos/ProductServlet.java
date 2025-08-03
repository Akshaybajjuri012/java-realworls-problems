package servletsdemos;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class ProductServlet extends HttpServlet{
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {

		    String selected = request.getParameter("product");
		    String[] parts = selected.split("-");
		    String name = parts[0];
		    int price = Integer.parseInt(parts[1]);

		    response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    out.println("<html><body>");
		    out.println("<h2>Enter Quantity</h2>");
		    out.println("<form action='OrderServlet' method='post'>");
		    out.println("Quantity: <input type='number' name='quantity' required><br><br>");
		    out.println("<input type='hidden' name='name' value='" + name + "'>");
		    out.println("<input type='hidden' name='price' value='" + price + "'>");
		    out.println("<input type='submit' value='Get Bill'>");
		    out.println("</form>");
		    out.println("</body></html>");
		  }

}
