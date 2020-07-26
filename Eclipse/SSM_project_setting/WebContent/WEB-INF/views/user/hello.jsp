<%@page import="com.mytext.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
	List<User> lists=(List<User>)request.getAttribute("list");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
		<tr>
			<td>id</td>
			<td>name</td>
		</tr>
		<%for(int i=0;i<lists.size();i++){ %>
		<tr>
			<td><%=lists.get(i).getId()%></td>
			<td><%=lists.get(i).getUsername()%></td>
		</tr>
		<%} %>
	</table> <br/>111${msg}
</body>
</html>