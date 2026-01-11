<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ include file="Header.jsp" %>
<div align="center">
	<h1>UserRegistration</h1>
	<% String msg=(String) request.getAttribute("suceessMsg");%>
	
	<h2 style="color:green"><%=msg!=null? msg:""%></h2>
	<form action="UserRegistrationCtl" method="post">
		<table>
			<tr>
			
				<th>First Name:</th>
				<td><input type="text" placeholder="Enter name" value=""
					name="firstName"></td>
			</tr>

			<tr>
				<th>Last Name:</th>
				<td><input type="text" placeholder="Enter last name" value=""
					name="lastName"></td>
			</tr>
			<tr>
				<th>Login:</th>
				<td><input type="email" placeholder="Enter email" value=""
					name="login"></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="password" placeholder="password" value=""
					name="password"></td>
			</tr>
			<tr>
				<th>DOB:</th>
				<td><input type="date" value="" name="dob"></td>
			</tr>


			<tr>

				<th></th>
				<td><input type="submit" name="operation" value="signUp"></td>
			</tr>



		</table>



	</form>
	</div>
	<%@ include file="Footer.jsp" %>
</body>
</html>