<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.model.Patient" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient Records</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            margin: 0;
            padding: 20px;
        }
        .navbar {
            background-color: #2c3e50;
            overflow: hidden;
            padding: 15px;
            margin-bottom: 20px;
        }
        .navbar a {
            color: white;
            padding: 14px 20px;
            text-decoration: none;
            display: inline-block;
        }
        .navbar a:hover {
            background-color: #3498db;
        }
        .container {
            max-width: 1200px;
            margin: 0 auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.2);
        }
        h2 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 30px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background: #3498db;
            color: white;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        .btn {
            padding: 5px 10px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            margin: 0 2px;
        }
        .btn-update {
            background-color: #3498db;
            color: white;
        }
        .btn-delete {
            background-color: #e74c3c;
            color: white;
        }
        .message {
            padding: 10px;
            border-radius: 5px;
            margin-bottom: 20px;
            text-align: center;
        }
        .success {
            background-color: #d4edda;
            color: #155724;
        }
        .print-btn {
            background-color: #27ae60;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-bottom: 20px;
        }
        @media print {
            .navbar, .btn, .print-btn {
                display: none;
            }
            .container {
                box-shadow: none;
                padding: 0;
            }
        }
    </style>
</head>
<body>
    <div class="navbar">
        <a href="index.jsp">🏥 Home</a>
        <a href="patientadd.jsp">➕ Add Patient</a>
        <a href="DisplayPatientsServlet">📋 View Records</a>
        <a href="reports.jsp">📊 Reports</a>
    </div>
    
    <div class="container">
        <h2>Patient Records</h2>
        
        <button class="print-btn" onclick="window.print()">🖨️ Print Records</button>
        
        <%
            String message = request.getParameter("message");
            if (message != null) {
        %>
            <div class="message success">
                <% if ("updated".equals(message)) { %>
                    Patient updated successfully!
                <% } else if ("deleted".equals(message)) { %>
                    Patient deleted successfully!
                <% } %>
            </div>
        <%
            }
        %>
        
        <%
            List<Patient> patients = (List<Patient>) request.getAttribute("patients");
            if (patients != null && !patients.isEmpty()) {
        %>
            <table>
                <thead>
                    <tr>
                        <th>Patient ID</th>
                        <th>Patient Name</th>
                        <th>Age</th>
                        <th>Gender</th>
                        <th>Admission Date</th>
                        <th>Ailment</th>
                        <th>Assigned Doctor</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Patient p : patients) {
                    %>
                        <tr>
                            <td><strong>#<%= p.getPatientID() %></strong></td>
                            <td><%= p.getPatientName() %></td>
                            <td><%= p.getAge() %></td>
                            <td><%= p.getGender() %></td>
                            <td><%= p.getAdmissionDate() %></td>
                            <td><%= p.getAilment() %></td>
                            <td><%= p.getAssignedDoctor() %></td>
                            <td>
                                <a href="UpdatePatientServlet?id=<%= p.getPatientID() %>" class="btn btn-update">✏️ Update</a>
                                <a href="#" onclick="confirmDelete(<%= p.getPatientID() %>)" class="btn btn-delete">🗑️ Delete</a>
                            </td>
                        </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            
            <div style="margin-top: 20px; padding: 10px; background: #f0f0f0; border-radius: 5px;">
                <strong>Total Patients: <%= patients.size() %></strong>
            </div>
        <%
            } else {
        %>
            <div style="text-align: center; padding: 50px; color: #999;">
                No patient records found. <a href="patientadd.jsp">Add your first patient</a>
            </div>
        <%
            }
        %>
    </div>
    
    <script>
        function confirmDelete(id) {
            if (confirm('⚠️ Are you sure you want to delete patient #' + id + '? This action cannot be undone!')) {
                window.location.href = 'DeletePatientServlet?id=' + id;
            }
        }
    </script>
</body>
</html>