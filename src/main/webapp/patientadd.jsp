<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Add Patient</title>

<style>

body{
    font-family:Arial,sans-serif;
    background:linear-gradient(135deg,#667eea 0%,#764ba2 100%);
    margin:0;
    padding:20px;
}

.navbar{
    background:#2c3e50;
    padding:15px;
    margin-bottom:20px;
    border-radius:8px;
}

.navbar a{
    color:white;
    padding:14px 20px;
    text-decoration:none;
}

.navbar a:hover{
    background:#3498db;
    border-radius:5px;
}

.container{
    max-width:500px;
    margin:50px auto;
    background:white;
    padding:30px;
    border-radius:15px;
}

h2{
    text-align:center;
    color:#2c3e50;
}

.form-group{
    margin-bottom:15px;
}

label{
    display:block;
    margin-bottom:5px;
    font-weight:bold;
}

input,select{
    width:100%;
    padding:10px;
    border:1px solid #ddd;
    border-radius:5px;
}

button{
    width:100%;
    padding:12px;
    background:#667eea;
    color:white;
    border:none;
    border-radius:5px;
    cursor:pointer;
    font-size:16px;
}

button:hover{
    background:#5a67d8;
}

.id-box{
    background:#e8f4f8;
    font-weight:bold;
}

</style>

</head>

<body>

<div class="navbar">

    <a href="index.jsp">Home</a>

    <a href="patientadd.jsp">Add Patient</a>

    <a href="DisplayPatientsServlet">View Records</a>

    <a href="reports.jsp">Reports</a>

</div>

<div class="container">

    <h2>Add New Patient</h2>

    <%
        String message = (String)request.getAttribute("message");

        if(message != null){
    %>

    <p style="color:green;text-align:center;">
        <%=message%>
    </p>

    <%
        }

        Integer nextId =
        (Integer)request.getAttribute("nextId");

        if(nextId == null)
            nextId = 1;
    %>

    <form action="AddPatientServlet" method="post">

        <div class="form-group">

            <label>Patient ID</label>

            <input type="text"
                   class="id-box"
                   value="<%=nextId%>"
                   readonly>

            <input type="hidden"
                   name="patientId"
                   value="<%=nextId%>">

        </div>

        <div class="form-group">

            <label>Patient Name</label>

            <input type="text"
                   name="patientName"
                   required
                   pattern="[A-Za-z\s]+">

        </div>

        <div class="form-group">

            <label>Age</label>

            <input type="number"
                   name="age"
                   required
                   min="1"
                   max="120">

        </div>

        <div class="form-group">

            <label>Gender</label>

            <select name="gender" required>

                <option value="">Select</option>

                <option value="Male">Male</option>

                <option value="Female">Female</option>

                <option value="Other">Other</option>

            </select>

        </div>

        <div class="form-group">

            <label>Admission Date</label>

            <input type="date"
                   id="admissionDate"
                   name="admissionDate"
                   required>

        </div>

        <div class="form-group">

            <label>Ailment</label>

            <select id="ailment"
                    name="ailment"
                    required>

                <option value="">Select</option>

                <option value="Fever">Fever</option>

                <option value="Cold">Cold</option>

                <option value="Cough">Cough</option>

                <option value="Headache">Headache</option>

                <option value="Diabetes">Diabetes</option>

                <option value="Hypertension">Hypertension</option>

                <option value="Other">Other</option>

            </select>

            <input type="text"
                   id="otherAilment"
                   name="otherAilment"
                   placeholder="Specify Ailment"
                   style="display:none;margin-top:10px;">

        </div>

        <div class="form-group">

            <label>Doctor</label>

            <select name="assignedDoctor" required>

                <option value="">Select</option>

                <option value="Dr. Smith">Dr. Smith</option>

                <option value="Dr. Johnson">Dr. Johnson</option>

                <option value="Dr. Williams">Dr. Williams</option>

                <option value="Dr. Brown">Dr. Brown</option>

            </select>

        </div>

        <button type="submit">
            Add Patient
        </button>

    </form>

</div>

<script>

document.getElementById("admissionDate")
.valueAsDate = new Date();

document.getElementById("ailment")
.onchange = function(){

    if(this.value === "Other"){

        document.getElementById("otherAilment")
        .style.display = "block";

    }
    else{

        document.getElementById("otherAilment")
        .style.display = "none";
    }
};

</script>

</body>
</html>