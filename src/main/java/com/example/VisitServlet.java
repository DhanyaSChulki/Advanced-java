package com.example;



import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class VisitServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");

        Cookie[] cookies = request.getCookies();

        int visitCount = 1;
        boolean returningUser = false;

        if (cookies != null) {
            for (Cookie c : cookies) {

                if (c.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(c.getValue());
                    visitCount++;
                }

                if (c.getName().equals("username")) {
                    username = c.getValue();
                    returningUser = true;
                }
            }
        }

        Cookie nameCookie = new Cookie("username", username);
        Cookie countCookie = new Cookie("visitCount", String.valueOf(visitCount));

        // Cookie expiry after 60 seconds
        nameCookie.setMaxAge(60);
        countCookie.setMaxAge(60);

        response.addCookie(nameCookie);
        response.addCookie(countCookie);

        out.println("<html>");
        out.println("<head><title>Cookie Visit Counter</title></head>");
        out.println("<body>");

        if (returningUser) {
            out.println("<h2>Welcome back " + username + "!</h2>");
            out.println("<h3>You have visited this page " + visitCount + " times.</h3>");
        } else {
            out.println("<h2>Welcome " + username + "!</h2>");
            out.println("<h3>This is your first visit.</h3>");
        }

        out.println("<p>Cookie expiry time is 60 seconds.</p>");

        out.println("<h3>List of Cookies</h3>");
        out.println("<table border='1'>");
        out.println("<tr><th>Cookie Name</th><th>Cookie Value</th></tr>");

        Cookie[] updatedCookies = request.getCookies();

        if (updatedCookies != null) {
            for (Cookie c : updatedCookies) {
                out.println("<tr>");
                out.println("<td>" + c.getName() + "</td>");
                out.println("<td>" + c.getValue() + "</td>");
                out.println("</tr>");
            }
        }

        out.println("<tr>");
        out.println("<td>username</td>");
        out.println("<td>" + username + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>visitCount</td>");
        out.println("<td>" + visitCount + "</td>");
        out.println("</tr>");

        out.println("</table>");

        out.println("<br><a href='index.html'>Go Back</a>");
        out.println("</body>");
        out.println("</html>");
    }
}