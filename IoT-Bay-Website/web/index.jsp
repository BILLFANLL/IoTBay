<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>
        <link href="newcss.css" rel="stylesheet" type="text/css"/>
    </head>
    
    <body>
        <h1>Welcome!</h1>
        <hr>
        <div class="box">  
            <table>
                <p>You have reached the IoT Bay web application. Please login or register. 
                </p> <br>               
            </table>
        </div>
            <form method="post" action="CustomerRegister.jsp">
                <p align="center"><input class="submit" type="submit" value="Register"></p>
            </form>
            <form method="post" action="login.jsp">
                <p align="center"><input class="submit" type="submit" value="Login"></p>
            </form>
            <form method="post" action="login_staff.jsp">
                <p align="center"><input class="submit" type="submit" value="Admin"></p>
            </form>
        
    </body>
</html>
