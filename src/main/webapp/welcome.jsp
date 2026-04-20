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
    <title>Welcome</title>
</head>
<body>

<%
    if (username != null) {
%>
        <h2>Hello <%= username %> !</h2>
        <p>Session expiry time is 1 minute.</p>
<%
    } else {
%>
        <h2>Session Expired!</h2>
        <p>Your session expired after 1 minute.</p>
        <a href="index.jsp">Login Again</a>
<%
    }
%>

</body>
</html>