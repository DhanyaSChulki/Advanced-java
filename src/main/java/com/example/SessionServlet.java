package com.example;



import java.io.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(true);

        session.setMaxInactiveInterval(60);

        Integer visitCount = (Integer) session.getAttribute("visitCount");

        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }

        session.setAttribute("visitCount", visitCount);

        out.println("<html>");
        out.println("<head><title>Session Tracking</title></head>");
        out.println("<body>");
        out.println("<h2>Session Tracking Information</h2>");

        out.println("<p><b>Session ID:</b> " + session.getId() + "</p>");
        out.println("<p><b>Session Creation Time:</b> " + new Date(session.getCreationTime()) + "</p>");
        out.println("<p><b>Last Access Time:</b> " + new Date(session.getLastAccessedTime()) + "</p>");
        out.println("<p><b>Visit Count:</b> " + visitCount + "</p>");
        out.println("<p><b>Session Expiry Time:</b> 60 seconds</p>");

        out.println("<br><a href='index.html'>Refresh Session</a>");
        out.println("</body>");
        out.println("</html>");
    }
}