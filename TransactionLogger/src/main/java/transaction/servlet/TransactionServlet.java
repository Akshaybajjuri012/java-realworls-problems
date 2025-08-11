package transaction.servlet;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
public class TransactionServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String amount = request.getParameter("amount");
        response.setContentType("text/html");
        response.getWriter().println("<h2>Transaction of Rs." + amount + " processed successfully.</h2>");
    }

}
