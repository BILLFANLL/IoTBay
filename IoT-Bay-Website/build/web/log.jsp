<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "uts.isd.model.*" %>
<%@page import = "uts.isd.controller.*" %>
<%@page import = "java.util.List" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>access log</title>
        <link href="newcss.css" rel="stylesheet" type="text/css"/>
    </head>
<body>

       <h1> access log</h1>
        <hr>
        <div class="box">
            <div class="box">
			<table id="profile_table">
				<thead>
					<th>login_time</th>
					<th>logout_time</th>
				</thead>
				
				    <%
			    	List<AccessLog> list = (List<AccessLog>) request.getSession().getAttribute("list");
				    for (int i = 0; i < list.size(); i++) {
				    	String d1 = list.get(i).getLogin_time();
				    	String d2 = list.get(i).getLogout_time();
				    	
				    	
				    	%>
				    	<tr>
				    	<td><%=d1 %></td>
				    	<td><%=d2==null?"-":d2 %></td>
				    	</tr>
				    	<%
					}
				    
				    %>
				
					
				
			</table>
		</div>

	</div>
                                    <br><!-- comment -->
        <div class="box">
	<a class="button" href="mainpage.jsp">back</a>
        </div>
				
</body>
</html>
