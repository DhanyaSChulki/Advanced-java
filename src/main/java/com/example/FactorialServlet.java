package com.example;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FactorialServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int num = Integer.parseInt(request.getParameter("num"));
        long fact = 1;

        for (int i = 1; i <= num; i++) {
            fact = fact * i;
        }

        out.println("<html>");
        out.println("<head><title>Factorial Result</title></head>");
        out.println("<body>");
        out.println("<h2>Factorial Result</h2>");
        out.println("<p>Entered Number: " + num + "</p>");
        out.println("<p>Factorial of " + num + " is: " + fact + "</p>");
        out.println("<a href='index.html'>Go Back</a>");
        out.println("</body>");
        out.println("</html>");
    }
}