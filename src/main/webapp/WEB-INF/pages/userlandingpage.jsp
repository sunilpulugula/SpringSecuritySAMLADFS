<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spring Security Social ThumbSignIn User Page.</title>
</head>
<body>
    <h2>${title}</h2><br/><br/>
    Dear <b>${user}</b>, you are successfully logged into this application.
    <br/>
    <br/>
    <b>UsersList :</b><br/>
    ${userslist}
    <br/>
    <br/>
    <br/>
    <a href="<c:url value="/j_spring_security_logout" />">Logout</a>
    <br/>
</body>
</html>