<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.model.Patient" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Report Results - Hospital Management</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f5f5f5;
            padding: 20px;
        }
        
        .report-container {
            max-width: 1200px;
            margin: 0 auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.1);
        }
        
        .header {
            text-align: center;
            margin-bottom: 30px;
            padding-bottom: 20px;
            border-bottom: 2px solid #667eea;
        }
        
        .header h1 {
            color: #2c3e50;
            margin-bottom: 10px;
        }
        
        .header p {
            color: #666;
        }
        
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        
        th {
            background-color: #667eea;
            color: white;
        }
        
        tr:hover {
            background-color: #f5f5f5;
        }
        
        .button-group {
            text-align: center;
            margin-top: 30px;
            padding-top: 20px;
            border-top: 1px solid #ddd;
        }
        
        button {
            padding: 10px 30px;
            margin: 0 10px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: transform 0.3s;
        }
        
        .btn-print {
            background-color: #27ae60;
            color: white;
        }
        
        .btn-exit {
            background-color: #e74c3c;
            color: white;
        }
        
        button:hover {
            transform: translateY(-2px);
        }
        
        .no-data {
            text-align: center;
            padding: 50px;
            color: #999;
            font-size: 18px;
        }
        
        .summary {
            margin-top: 20px;
            padding: 15px;
            background-color: #f0f0f0;
            border-radius: 5px;
            text-align: center;
        }
        
        @media print {
            .button-group, .no-print {
                display: none;
            }
            .report-container {
                box-shadow: none;
                padding: 0;
            }
            body {
                background: white;
                padding: 0;
            }
        }
        
        .footer {
            margin-top: 30px;
            text-align: center;
            font-size: 12px;
            color: #999;
        }
    </style>
</head>
<body>
    <div class="report-container">
        <div class="header">
            <h1>🏥 Hospital Management System</h1>
            <h2><%= request.getAttribute("reportTitle") %></h2>
            <p>Generated on: <%= new java.util.Date() %></p>
        </div>
        
        <%
            List<Patient> patients = (List<Patient>) request.getAttribute("patients");
            String reportType = (String) request.getAttribute("reportType");
            
            if (patients != null && !patients.isEmpty()) {
        %>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Patient Name</th>
                        <th>Age</th>
                        <th>Gender</th>
                        <th>Admission Date</th>
                        <th>Ailment</th>
                        <th>Assigned Doctor</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Patient p : patients) {
                    %>
                        <tr>
                            <td><%= p.getPatientID() %></td>
                            <td><%= p.getPatientName() %></td>
                            <td><%= p.getAge() %></td>
                            <td><%= p.getGender() %></td>
                            <td><%= p.getAdmissionDate() %></td>
                            <td><%= p.getAilment() %></td>
                            <td><%= p.getAssignedDoctor() %></td>
                        </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            
            <div class="summary">
                <strong>Total Patients: <%= patients.size() %></strong>
            </div>
        <%
            } else {
        %>
            <div class="no-data">
                📊 No records found for the selected criteria.
            </div>
        <%
            }
        %>
        
        <div class="button-group no-print">
            <button class="btn-print" onclick="window.print()">🖨️ Print Report</button>
            <button class="btn-exit" onclick="window.close()">❌ Exit</button>
        </div>
        
        <div class="footer no-print">
            <p>This is a computer-generated report. No signature required.</p>
        </div>
    </div>
    
    <script>
        // Auto focus on print if there are results
        <% if (patients != null && !patients.isEmpty()) { %>
            // Optional: Auto print dialog (commented)
            // window.onload = function() { window.print(); }
        <% } %>
    </script>
</body>
</html>