<%-- 
    Document   : login.jsp
    Created on : Aug 17, 2022, 10:00:40 AM
    Author     : QUANGANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="/Assignment/styles/loginstyle.css">
        <title>Login Page</title>
    </head>
    <body>
        <div class="formlogin">
        <form action="login" method="post">
        Username: <input class="username" id="username" name="username"/><br/><br/>
        Password: <input class="password" id="password" name="password"/><br/><br/>
        <input class="submit" type="submit" value="Login"/><br/><br/>
        <a href="">forgot password?</a>
        </form>
        
        </div>
    </body>
</html>
