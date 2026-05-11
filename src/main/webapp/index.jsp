<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hospital Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            margin: 0;
            padding: 20px;
            min-height: 100vh;
        }
        .navbar {
            background: #2c3e50;
            overflow: hidden;
            padding: 15px;
            margin-bottom: 20px;
            border-radius: 8px;
        }
        .navbar a {
            color: white;
            padding: 14px 20px;
            text-decoration: none;
            display: inline-block;
        }
        .navbar a:hover {
            background: #3498db;
            border-radius: 5px;
        }
        .container {
            max-width: 1200px;
            margin: 50px auto;
            text-align: center;
        }
        h1 {
            color: white;
            font-size: 48px;
            margin-bottom: 50px;
        }
        .cards {
            display: flex;
            justify-content: center;
            gap: 30px;
            flex-wrap: wrap;
        }
        .card {
            background: white;
            padding: 40px;
            border-radius: 15px;
            width: 250px;
            cursor: pointer;
            transition: transform 0.3s;
            box-shadow: 0 10px 30px rgba(0,0,0,0.2);
        }
        .card:hover {
            transform: translateY(-10px);
        }
        .card h3 {
            color: #2c3e50;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <a href="index.jsp">Home</a>
        <a href="AddPatientServlet">Add Patient</a>
        <a href="DisplayPatientsServlet">View Records</a>
        <a href="reports.jsp">Reports</a>
    </div>
    
    <div class="container">
        <h1>Hospital Management System</h1>
        <div class="cards">
            <div class="card" onclick="location.href='AddPatientServlet'">
                <h2>➕</h2>
                <h3>Add Patient</h3>
                <p>Register new patients</p>
            </div>
            <div class="card" onclick="location.href='DisplayPatientsServlet'">
                <h2>📋</h2>
                <h3>View Records</h3>
                <p>View, update or delete</p>
            </div>
            <div class="card" onclick="location.href='reports.jsp'">
                <h2>📊</h2>
                <h3>Reports</h3>
                <p>Generate reports</p>
            </div>
        </div>
    </div>
</body>
</html>