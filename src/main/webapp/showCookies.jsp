<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    Cookie[] cookies = request.getCookies();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Active Cookie List</title>
</head>
<body>
    <h2>Active Cookie List</h2>

<%
    if (cookies != null) {
%>
        <table border="1">
            <tr>
                <th>Cookie Name</th>
                <th>Cookie Value</th>
            </tr>

<%
        for (Cookie c : cookies) {
%>
            <tr>
                <td><%= c.getName() %></td>
                <td><%= c.getValue() %></td>
            </tr>
<%
        }
    } else {
%>
        <p>No Active Cookies Found</p>
<%
    }
%>

        </table>
</body>
</html>