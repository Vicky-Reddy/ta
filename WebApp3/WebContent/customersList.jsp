<%@page import="com.tadigital.wa3.customer.entity.Customer"%>
<%@page import='java.util.ArrayList' %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1 width=100%>
	<tr>
		<th>Customer id</th> 
		<th>Customer name</th> 
		<th>Email </th>
		<th> Password </th> 
		<th> FirstName </th> 
		<th> LastName </th> 
	</tr>
	<%
	ArrayList<Customer> al = (ArrayList<Customer>)request.getAttribute("CustomerList");
	for(Customer c:al){
	%>
	<tr>
		<td><%=c.getId()%></td>
		<td><%=c.getUsername()%></td>
		<td><%=c.getEmail()%></td>
		<td><%=c.getPassword()%></td>
		<td><%=c.getFname()%></td>
		<td><%=c.getLname()%></td>
	</tr>
	<% }%>
	</table>
</body>
</html>