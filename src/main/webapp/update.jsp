<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="record" scope="request"
		class="global.coda.hospital.bean.PatientRecord"
		type="global.coda.hospital.bean.PatientRecord" />

	<form action="update" method="post">
		<h1>username & password cannot be changed</h1>
		Age:<br> <input type="number" name="age" value=${record.age} required>
		 <br> Location:<br> <input type="text" name="location" value=${record.location} required> <br>
		Phone:<br> <input type="number" name="phone" value=${record.phone
			}  required> <br> Disease:<br> <input type="text"
			name="disease" value=${record.disease}  required> <br>
		<br> <input type="submit" value="Update">
	</form>

	<br />

	<a href="logout"> logout </a>

</body>
</html>