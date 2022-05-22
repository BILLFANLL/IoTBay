<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <link href="newcss.css" rel="stylesheet" type="text/css"/>
    </head>
    
    <%
        String emailErr = (String) session.getAttribute("emailErr");
        String otherErr = (String) session.getAttribute("otherErr");
     %>
     
    <body>
        
        
        <h1> Create an account</h1>
        <hr>   
        <div class="box">    
            <form action="RegisterServlet" method="post">
            
            <div class="box"> 
                <table>
                    <tr><td>Full Name:</td><td><input type="text"  name="name" required="true"></td></tr>
                    <tr><td>date_of_birth:</td><td><input type="text"  name="date_of_birth" required></td></tr>
                    <tr><td>Phone Number:</td><td><input type="text"  name="phone_number" required></td></tr>
                    <tr><td>address:</td><td><input type="text"  name="address" required></td></tr>
                    <tr><td>Email:</td><td><input type="text" placeholder="<%= emailErr != null ? emailErr : "Enter Your Email"%>" name="email" required></td></tr>
                    <tr><td>Password:</td><td><input type="password"   name="password" required></td></tr>
                 </table>
            </div> 
                 
            <div align="center">
                    <tr><td><input type="checkbox" name="tos"> I have read and agree to the terms of service</input></td></tr>
            </div>
                    
            <p align="center"><input class="submit" type="submit" value="Register"></p>
        
            </form>
            <br>
            
        
        <div class= "container">
            <p><%= otherErr != null ? otherErr : ""%></p> 
        </div>
         
        </div>
        <p align="center">I already have an account. Please click <a href="login.jsp">here</a> to login.</p>
  
    </body>
</html>
