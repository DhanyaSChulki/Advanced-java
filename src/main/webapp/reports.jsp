<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Generate Reports - Hospital Management</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
        }
        
        .navbar {
            background-color: #2c3e50;
            overflow: hidden;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            position: sticky;
            top: 0;
            z-index: 100;
        }
        
        .navbar a {
            float: left;
            display: block;
            color: white;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
            font-size: 16px;
            transition: all 0.3s;
        }
        
        .navbar a:hover {
            background-color: #3498db;
        }
        
        .dropdown {
            float: left;
            overflow: hidden;
        }
        
        .dropdown .dropbtn {
            font-size: 16px;
            border: none;
            outline: none;
            color: white;
            padding: 14px 20px;
            background-color: inherit;
            font-family: inherit;
            margin: 0;
            cursor: pointer;
        }
        
        .dropdown:hover .dropbtn {
            background-color: #3498db;
        }
        
        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }
        
        .dropdown-content a {
            float: none;
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            text-align: left;
        }
        
        .dropdown-content a:hover {
            background-color: #ddd;
        }
        
        .dropdown:hover .dropdown-content {
            display: block;
        }
        
        .container {
            max-width: 800px;
            margin: 50px auto;
        }
        
        .card {
            background: white;
            border-radius: 10px;
            padding: 30px;
            margin-bottom: 30px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.2);
            animation: slideUp 0.5s ease;
        }
        
        @keyframes slideUp {
            from {
                transform: translateY(50px);
                opacity: 0;
            }
            to {
                transform: translateY(0);
                opacity: 1;
            }
        }
        
        h2 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 30px;
        }
        
        .form-group {
            margin-bottom: 20px;
        }
        
        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
            font-weight: bold;
        }
        
        input, select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
        }
        
        button {
            width: 48%;
            padding: 12px;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: transform 0.3s;
            margin: 5px 1%;
        }
        
        button:hover {
            transform: translateY(-2px);
        }
        
        .button-group {
            text-align: center;
        }
        
        h3 {
            color: #667eea;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <a href="index.jsp">🏥 Home</a>
        <div class="dropdown">
            <button class="dropbtn">Patient Management ▼</button>
            <div class="dropdown-content">
                <a href="patientadd.jsp">➕ Add Patient</a>
                <a href="DisplayPatientsServlet">📋 View Records</a>
            </div>
        </div>
        <div class="dropdown">
            <button class="dropbtn">Reports ▼</button>
            <div class="dropdown-content">
                <a href="reports.jsp?type=date">📅 Date Range Report</a>
                <a href="reports.jsp?type=ailment">🩺 Ailment Report</a>
                <a href="reports.jsp?type=doctor">👨‍⚕️ Doctor Report</a>
            </div>
        </div>
        <a href="reports.jsp" class="active">📊 All Reports</a>
    </div>
    
    <div class="container">
        <h2>Generate Reports</h2>
        
        <%
            String type = request.getParameter("type");
            if (type == null) type = "";
        %>
        
        <!-- Date Range Report -->
        <div class="card">
            <h3>📅 Report by Date Range</h3>
            <form action="ReportServlet" method="post" target="_blank">
                <input type="hidden" name="reportType" value="dateRange">
                <div class="form-group">
                    <label>Start Date</label>
                    <input type="date" name="startDate" required>
                </div>
                <div class="form-group">
                    <label>End Date</label>
                    <input type="date" name="endDate" required>
                </div>
                <div class="button-group">
                    <button type="submit">Generate Report</button>
                    <button type="button" onclick="window.location.href='index.jsp'">Exit</button>
                </div>
            </form>
        </div>
        
        <!-- Ailment Report -->
        <div class="card">
            <h3>🩺 Report by Ailment</h3>
            <form action="ReportServlet" method="post" target="_blank">
                <input type="hidden" name="reportType" value="ailment">
                <div class="form-group">
                    <label>Select Ailment</label>
                    <select name="ailment" id="ailmentSelect" required onchange="toggleAilmentOther()">
                        <option value="">Select Ailment</option>
                        <option value="Fever">Fever</option>
                        <option value="Cold">Cold</option>
                        <option value="Hypertension">Hypertension</option>
                        <option value="Diabetes">Diabetes</option>
                        <option value="Asthma">Asthma</option>
                        <option value="Migraine">Migraine</option>
                        <option value="Other">Other</option>
                    </select>
                    <input type="text" name="otherAilment" id="otherAilment" placeholder="Specify ailment" style="display:none; margin-top:10px;">
                </div>
                <div class="button-group">
                    <button type="submit">Generate Report</button>
                    <button type="button" onclick="window.location.href='index.jsp'">Exit</button>
                </div>
            </form>
        </div>
        
        <!-- Doctor Report -->
        <div class="card">
            <h3>👨‍⚕️ Report by Doctor</h3>
            <form action="ReportServlet" method="post" target="_blank">
                <input type="hidden" name="reportType" value="doctor">
                <div class="form-group">
                    <label>Select Doctor</label>
                    <select name="doctor" id="doctorSelect" required onchange="toggleDoctorOther()">
                        <option value="">Select Doctor</option>
                        <option value="Dr. Smith">Dr. Smith</option>
                        <option value="Dr. Johnson">Dr. Johnson</option>
                        <option value="Dr. Williams">Dr. Williams</option>
                        <option value="Dr. Brown">Dr. Brown</option>
                        <option value="Dr. Davis">Dr. Davis</option>
                        <option value="Other">Other</option>
                    </select>
                    <input type="text" name="otherDoctor" id="otherDoctor" placeholder="Specify doctor name" style="display:none; margin-top:10px;">
                </div>
                <div class="button-group">
                    <button type="submit">Generate Report</button>
                    <button type="button" onclick="window.location.href='index.jsp'">Exit</button>
                </div>
            </form>
        </div>
    </div>
    
    <script>
        function toggleAilmentOther() {
            var select = document.getElementById('ailmentSelect');
            var otherInput = document.getElementById('otherAilment');
            if (select.value === 'Other') {
                otherInput.style.display = 'block';
                otherInput.required = true;
            } else {
                otherInput.style.display = 'none';
                otherInput.required = false;
            }
        }
        
        function toggleDoctorOther() {
            var select = document.getElementById('doctorSelect');
            var otherInput = document.getElementById('otherDoctor');
            if (select.value === 'Other') {
                otherInput.style.display = 'block';
                otherInput.required = true;
            } else {
                otherInput.style.display = 'none';
                otherInput.required = false;
            }
        }
        
        // Set default dates for date range
        var today = new Date();
        var firstDay = new Date(today.getFullYear(), today.getMonth(), 1);
        document.querySelector('input[name="startDate"]').valueAsDate = firstDay;
        document.querySelector('input[name="endDate"]').valueAsDate = today;
    </script>
</body>
</html>