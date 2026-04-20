<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Student Result Form</title>

    <script>
        function validateForm() {
            let fields = document.forms["resultForm"];

            if (fields["rollno"].value == "" ||
                fields["studentname"].value == "" ||
                fields["sub1"].value == "" ||
                fields["sub2"].value == "" ||
                fields["sub3"].value == "" ||
                fields["sub4"].value == "" ||
                fields["sub5"].value == "") {

                alert("All fields are required");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
    <h2>Student Result Form</h2>

    <form name="resultForm" action="ResultServlet" method="post" onsubmit="return validateForm()">
        Roll No:
        <input type="text" name="rollno"><br><br>

        Student Name:
        <input type="text" name="studentname"><br><br>

        Subject 1:
        <input type="number" name="sub1"><br><br>

        Subject 2:
        <input type="number" name="sub2"><br><br>

        Subject 3:
        <input type="number" name="sub3"><br><br>

        Subject 4:
        <input type="number" name="sub4"><br><br>

        Subject 5:
        <input type="number" name="sub5"><br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>