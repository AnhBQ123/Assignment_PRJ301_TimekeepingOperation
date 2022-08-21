<%-- 
    Document   : board
    Created on : Aug 15, 2022, 10:43:53 AM
    Author     : QUANGANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <link rel="stylesheet" href="/Assignment/styles/boardstyle.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <a href="addStaff.jsp">Add new staff</a>
        <form action="add-staff" method="post">
            <label>Staff name</label>
            <input type="text" id="name"/>
            <label>Staff Date Of Birth</lable>
            <input type="date" id="dob"/>
            <label>Username</label>
            <input type="text" id="username"/>
            <label>Password</label>
            <input type="password" id="password"/>
            <lable>Confirm password</lable>
            <input type="password" id="cfpassword"/>
            <input type="submit" value="create"/>
        </form>
        <a href="#">Absence requests</a>
    </body>
</html>
