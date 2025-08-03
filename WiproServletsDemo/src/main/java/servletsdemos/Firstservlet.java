package servletsdemos;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class Firstservlet extends HttpServlet{
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		    
		    String name = request.getParameter("name");
		    int marks = Integer.parseInt(request.getParameter("marks"));

		    
		    request.setAttribute("studentName", name);
		    request.setAttribute("studentMarks", marks);

		    
		    RequestDispatcher rd = request.getRequestDispatcher("SecondServlet");
		    rd.forward(request, response);
		  }

}
