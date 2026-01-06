<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UserFormValues.jsp">
<table>
<tr>

<th>firstName</th>
<td><input type="text" name="firstName" value=" " placeholder="Enter firstName"></td>
</tr>

<tr>

<th>lastName</th>
<td><input type="text" name="lastName" value=" " placeholder="Enter lastName"></td>
</tr>
<tr>

<th>login</th>
<td><input type="email" name="login" value=" " placeholder=" Enter login ID"></td>
</tr>
<tr>

<th>password</th>
<td><input type="password" name="password" value=" " placeholder="Enter password"></td>
</tr>
<tr>

<th>DOB</th>
<td><input type="date" name="dob" value=" " ></td>
</tr>

<tr>

<th></th>
<td><input type="Submit" name="save" value="Save " ></td>
</tr>
<th>
</table>


</form>

</body>
</html>