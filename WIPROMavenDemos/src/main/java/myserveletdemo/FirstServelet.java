package myserveletdemo;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//default HTTP method is doGet

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//MIME TYPE
		
		PrintWriter outobj=response.getWriter();//Character Stream
		outobj.println("Hello Servlet!");
		outobj.println("<font color=red><h1>Hello Servlet!");//Servlet+HTML 
		outobj.println("<h1 style=color:yellow>Servlet With Inline css</h1>");//CSS=>Cascading Style Sheet

	}
	//doPost will work only with html files!
	

}
