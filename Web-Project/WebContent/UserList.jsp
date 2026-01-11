<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	List list = (List) request.getAttribute("list");
	%>
<%@ include file="Header.jsp" %>
<div align="center">
<h1>User List</h1>
	<form action="UserListCtl"  method="post">
	<table width="100%" border="1px">
	<tr style="background:skyblue">
	   <th>Id</th>
		<th>FirstName</th>
         <th>LastName</th>
         <th>Login</th>
		<th>DOB</th>
	
	</tr>
	
	<%
	Iterator<UserBean> it=list.iterator();
	while(it.hasNext()){
	UserBean bean=it.next();
	
	%>
	<tr align="center" style="background:lightgray">
	
	<td><%=bean.getId()%></td>
		<td><%=bean.getFirstName()%></td>
			<td><%=bean.getLastName()%></td>
				<td><%=bean.getLogin()%></td>
					<td><%=bean.getDob()%></td>
	
	</tr>
	
	<%} %>
	
	</table>
	
	
	
	
	
	</form>
	
</div>
	
<div style="position: fixed; bottom: 0; left: 0; width: 100%; z-index: 1000;">
    <%@ include file="Footer.jsp" %>
</div>
</body>
</html>