<%-- 
    Document   : login
    Created on : 2022年5月21日, 上午1:03:28
    Author     : billfan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
        <link href="newcss.css" rel="stylesheet" type="text/css"/>
    </head>
<body>
        <h1> Login</h1>
        <hr>
	


		<div class="box">
                <table>
                    
				<td><a href="edit.jsp">Account</a></td>
                                <td><p> | </p></td>
				<td><a href="LogoutServlet">Logout</a></td>
                                <td><p> | </p></td>
				<td><a href="LogServlet">Log</a></td>
                                <td><p> | </p></td>
				<td><a href="DelUserServlet">Delete User</a></td>
                                
		</table>
		</div>
        <br>

		<div class="box">
			<table id="profile_table">
				<thead>
					<th>Name:</th>
					<th>Email:</th>
					<th>Password:</th>
					<th>Phone Number:</th>
					<th>date_of_birth:</th>
					<th>address:</th>
				</thead>
				<tr>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.password}</td>
					<td>${user.phone_number}</td>
					<td>${user.date_of_birth}</td>
					<td>${user.address}</td>
				</tr>
			</table>
		</div>

	
</body>
</html>
