<%@ page import="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String pw = request.getParameter("password");
	String em = request.getParameter("email");
	int i=0;
	Connection c=null;
	Statement s=null;
	ResultSet rs=null; 
	try {
		Class.forName("com.mysql.jdbc.Driver");
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/techaspect", "root", "vicky");
		s=c.createStatement();
		String sql="select * from customer_info; ";
		rs=s.executeQuery(sql);
		while(rs.next())
		{
			String one=rs.getString(1);
			String two=rs.getString(2);
			String three=rs.getString(3);
			if(two.equals(em) && three.equals(pw))
			{
				%>
				<script>localStorage.setItem('email',em)</script>
				Welcome <%= one %>
					<br><a href="CustomerAccount.html">Update User Info</a>
				<% 
				i=1;
				break;
			}
		}
		if(i==0)
		{%>
			Invalid Credentials<br>
			<a href='index.html'>Return Home</a>
		<%}
	}catch(ClassNotFoundException cnfEx)
	{
		cnfEx.printStackTrace();
	}catch(SQLException sqlEx)
	{
		sqlEx.printStackTrace();
	}finally {
		try {
			if(rs!=null)
				rs.close();
			if(s!=null)
				s.close();
			if(c!=null)
				c.close();
		}catch(SQLException sqlEx)
		{
			sqlEx.printStackTrace();
		}
	}
	%>

</body>
</html>