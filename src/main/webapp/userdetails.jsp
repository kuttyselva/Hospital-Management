<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>

	<jsp:useBean id="record" scope="request" class= "global.coda.hospital.bean.PatientRecord" type= "global.coda.hospital.bean.PatientRecord"/>
	
	<table>
		<tr>
			<th>Name</th>
			<th><jsp:getProperty property="name" name="record"/></th>
		</tr>
		<tr>
			<td>Age</td>
			<td><jsp:getProperty property="age" name="record"/></td>
		</tr>
		<tr>
			<td>Location</td>
			<td><jsp:getProperty property="location" name="record"/></td>
		</tr>
		<tr>
			<td>Phone</td>
			<td><jsp:getProperty property="phone" name="record"/></td>
		</tr>
		<tr>
			<td>Disease</td>
			<td><jsp:getProperty property="disease" name="record"/></td>
		</tr>
	</table>

	<button>
		<a href="update">Update Data</a> 
	</button>
	
	<button>
		<a href="logout">Logout</a> 
	</button>

</body>
</html>
</body>
</html>