<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import = "uts.isd.model.*" %>
<%@page import = "uts.isd.controller.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>update personal detile</title>
        <link href="newcss.css" rel="stylesheet" type="text/css"/>
    </head>
    
    <body>
        <h1> Update personal information</h1>
        <hr>
        
            <%
                User user = (User)session.getAttribute("user");
                String updated = (String)session.getAttribute("updated");
            %> 
        

          <div class = "box">
            <div class="box">
                
            <form action="UpdateServlet" method="post">
                <input type="hidden" name="user_id" value="${user.user_id}">
                <table>
                    <tr><td>Full name:</td><td><input type="text" name="name"  value="${user.name}" maxlength="20"></td></tr>
                    <tr><td>date_of_birth:</td><td><input type="text" name="date_of_birth" value="${user.date_of_birth}" maxlength="10"></td></tr>
                    <tr><td>Password:</td><td><input type="password" name="password" value="${user.password}" maxlength="30"></td></tr>
                    <tr><td>Phone Number:</td><td><input type="text" name="phone_number" value="${user.phone_number}" maxlength="10"></td></tr>
                    <tr><td>address:</td><td><input type="text" name="address" value="${user.address}" maxlength="64"></td></tr>
                </table>
            
            
                        
            <div class="box"> 
                <p align="center"><a class= "submit" href="mainpage.jsp" > Cancel</a></p>
                <p align="center"><input class="submit" type="submit" value="update"></p>

            </div>
            </form>
            </div>
            <div class="box">
                
                <p><%= updated != null ? updated : ""%></p> 
                
            </div>
            
        </div>  
    </body>
</html>
