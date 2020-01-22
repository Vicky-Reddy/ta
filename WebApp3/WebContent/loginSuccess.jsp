<%@page import="com.tadigital.wa3.customer.entity.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Customer c = (Customer)request.getAttribute("cust"); %>
<font color="green">
	welcome <%= c.getFname() %> <%= c.getLname() %>
	<a href="customers">List Customers</a>
</font>
</body>
</html>