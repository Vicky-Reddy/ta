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
	String un = request.getParameter("uname");
	String pw = request.getParameter("password");
	String em = request.getParameter("email");
	if(un.equals("")||em.equals("")||pw.equals(""))
	{
		%>
		Enter Correct Credentials.<br>
		<a href='index.html'>Return Home</a>
		</body>
		</html>
	<%
	return;}
	Connection c=null;
	Statement s=null;
	ResultSet rs=null; 
	try {
		Class.forName("com.mysql.jdbc.Driver");
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/techaspect", "root", "vicky");
		s=c.createStatement();
		String sql="insert into customer_info(name,email,password) values('"+un+"','"+em+"','"+pw+"');";
		
		s.executeUpdate(sql);
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
		<h3>Successfully Registered.</h3><br>
		UseName : <%= un %><br>
		Email : <%= em%><br>
		<a href='index.html' >Proceed</a>
</body>
</html>