package com.student;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CheckResultServlet")
public class CheckResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CheckResultServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int marks = Integer.parseInt(request.getParameter("marks"));

        request.setAttribute("name", name);
        request.setAttribute("marks", marks);

        if (marks >= 40) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("pass.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("fail.jsp");
            dispatcher.forward(request, response);
        }
    }

    // Optional: If someone accesses via GET, redirect them to form.jsp
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("form.jsp");
    }
}
