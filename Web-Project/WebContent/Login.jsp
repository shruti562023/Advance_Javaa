<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file ="Header.jsp" %>
<div align="center">

<!-- password-->
<%String pass=(String) request.getAttribute("pass"); %>
<%if( pass!=null){ %>

<h3 style="color:red"><%=pass %></h3>

<%} %>

<%String msg=(String) request.getAttribute("successMsg"); %>

		<h1>Login</h1>
		<%if(msg!=null){
			%>
			<h3 style="color:green"><%=msg%></h3>
			
		<%} %>
		<form action="LoginCtl" method="post">

			<table>
				<tr>
					<th>Login:</th>
					<td><input type="email" name="login" value=""
						placeholder="enter your login"></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="password" name="password" value=""
						placeholder="enter your password"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="signIn">
					<input type="submit" name="operation" value="signUp"></td>
				</tr>

			</table>

		</form>

	</div>           
	
<div style="position: fixed; bottom: 0; left: 0; width: 100%; z-index: 1000;">
    <%@ include file="Footer.jsp" %>
</div>
</body>
</html>