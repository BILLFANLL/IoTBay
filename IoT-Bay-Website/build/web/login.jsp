
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.controller.*"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="newcss.css" rel="stylesheet" type="text/css"/>
    </head>

<%
	String existErr = (String) session.getAttribute("existErr");
	String emailErr = (String) session.getAttribute("emailErr");
%>


<body>
        <h1> Login</h1>
        <hr>

	<div class="box">



		<form action="LoginServlet" method="post">

			<div class="box">
				<table>
					<tr>
						<td>Email:</td>
						<td><input type="text"
							placeholder="<%=emailErr != null ? emailErr : "Enter Email"%>"
							name="email" required></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="password" required></td>
					</tr>
				</table>
			</div>

            <div class="box"> 
                <p align="center"><a class= "submit" href="index.jsp" > Cancel</a></p>
                <p align="center"><input class="submit" type="submit" value="login"></p>

            </div>

		</form>

		<div class="container">
			<p><%=existErr != null ? existErr : ""%></p>
		</div>

</body>
</html>
