<%@page import="com.mytext.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>
	<%
		List<User> list=(List<User>)request.getAttribute("user");
		for(int i=0;i<list.size();i++){
	%>
	 <tr>
	    <td><%=list.get(i).getId() %></td>
        <td><%=list.get(i).getUsername() %></td> 
     </tr>
	<%} %>
</table>