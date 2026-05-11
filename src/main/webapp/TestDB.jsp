<%@ page import="java.sql.*" %>
<html>
<body>
<h2>Database Connection Test</h2>
<%
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/HospitalDB", 
        "root", 
        "password"  // Your password here
    );
    out.println("<p style='color:green'>✓ Connection successful!</p>");
    conn.close();
} catch (Exception e) {
    out.println("<p style='color:red'>✗ Connection failed: " + e.getMessage() + "</p>");
    e.printStackTrace(response.getWriter());
}
%>
</body>
</html>