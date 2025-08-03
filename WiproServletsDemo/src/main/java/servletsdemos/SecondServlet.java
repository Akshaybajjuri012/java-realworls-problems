package servletsdemos;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class SecondServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {

		    response.setContentType("text/html");
		    PrintWriter out = response.getWriter();

		    String name = (String) request.getAttribute("studentName");
		    int marks = (int) request.getAttribute("studentMarks");

		    String grade;
		    if (marks >= 90) grade = "A";
		    else if (marks >= 75) grade = "B";
		    else if (marks >= 50) grade = "C";
		    else grade = "F";
		    out.println("<html><body>");
		    out.println("<h2>Result</h2>");
		    out.println("Name: " + name + "<br>");
		    out.println("Marks: " + marks + "<br>");
		    out.println("Grade: <strong>" + grade + "</strong>");
		    out.println("</body></html>");
		  }

}
