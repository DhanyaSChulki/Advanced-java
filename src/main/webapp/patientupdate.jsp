<%@ page import="com.model.Patient" %>

<%
Patient patient =
(Patient)request.getAttribute("patient");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Update Patient</title>

<style>

body{
font-family:Arial;
background:#f2f2f2;
padding:20px;
}

.container{
width:500px;
margin:auto;
background:white;
padding:20px;
border-radius:10px;
}

input,select{
width:100%;
padding:10px;
margin:10px 0;
}

button{
width:100%;
padding:12px;
background:green;
color:white;
border:none;
}

</style>

</head>

<body>

<div class="container">

<h2 align="center">
Update Patient
</h2>

<form action="UpdatePatientServlet"
method="post">

<input type="hidden"
name="patientId"
value="<%=patient.getPatientID()%>">

<label>Name</label>

<input type="text"
name="patientName"
value="<%=patient.getPatientName()%>"
required>

<label>Age</label>

<input type="number"
name="age"
value="<%=patient.getAge()%>"
required>

<label>Gender</label>

<select name="gender">

<option value="Male"
<%=patient.getGender().equals("Male")?
"selected":""%>>
Male
</option>

<option value="Female"
<%=patient.getGender().equals("Female")?
"selected":""%>>
Female
</option>

<option value="Other"
<%=patient.getGender().equals("Other")?
"selected":""%>>
Other
</option>

</select>

<label>Admission Date</label>

<input type="date"
name="admissionDate"
value="<%=patient.getAdmissionDate()%>"
required>

<label>Ailment</label>

<input type="text"
name="ailment"
value="<%=patient.getAilment()%>"
required>

<label>Doctor</label>

<input type="text"
name="assignedDoctor"
value="<%=patient.getAssignedDoctor()%>"
required>

<button type="submit">
Update Patient
</button>

</form>

</div>

</body>
</html>