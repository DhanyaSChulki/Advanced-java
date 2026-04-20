<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String cname = request.getParameter("cname");
    String cvalue = request.getParameter("cvalue");
    String domain = request.getParameter("domain");
    int age = Integer.parseInt(request.getParameter("age"));

    Cookie cookie = new Cookie(cname, cvalue);

    cookie.setDomain(domain);
    cookie.setMaxAge(age);

    response.addCookie(cookie);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Cookie Added</title>
</head>
<body>
    <h2>Cookie Information Set Successfully</h2>

    <p><strong>Cookie Name:</strong> <%= cname %></p>
    <p><strong>Cookie Value:</strong> <%= cvalue %></p>
    <p><strong>Domain:</strong> <%= domain %></p>
    <p><strong>Max Age:</strong> <%= age %> seconds</p>

    <br>
    <a href="showCookies.jsp">Go to Active Cookie List</a>
</body>
</html>