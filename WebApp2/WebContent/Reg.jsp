
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<% String fn = request.getParameter("f1");
		String ln = request.getParameter("f2");
		String em = request.getParameter("f3");
		String g = request.getParameter("f4");
		String[] qu = request.getParameterValues("f5");
		String c = request.getParameter("f6");
		String ad = request.getParameter("f7");
		String p = request.getParameter("f8");
		%>

		FirstName :<%= fn%>
		<br>lastName :<%=ln%>
		<br>email :<%=em%>
		<br>gender :<%=g%>
		<%for(String q:qu) 
		{%>
		<br>Qualification :<%=q%>
		<%}%>
		<br>country :<%=c%>
		<br>address :<%=ad%>
		<br>password :<%=p%>
</body>
</html>