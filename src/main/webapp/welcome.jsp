<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String name = request.getParameter("username");

    if (name != null) {
        session.setAttribute("username", name);
        session.setMaxInactiveInterval(60);
    }

    String username = (String) session.getAttribute("username");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>

<%
    if (username != null) {
%>
        <h2>Hello <%= username %> !</h2>
        <p>Your session will expire after 1 minute of inactivity.</p>
<%
    } else {
%>
        <h2>Session Expired!</h2>
        <p>Your session has expired after 1 minute.</p>
        <a href="index.jsp">Login Again</a>
<%
    }
%>

</body>
</html>