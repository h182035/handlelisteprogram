<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logg inn!</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/login.css">
</head>
<body>
<div id="content">
<p style="color:red">${feilmelding}</p>
<form method="POST">
<p>Passord: <input type="password" name="password"/></p>
<button type="submit">Logg inn!</button>

</form>
</div>
</body>
</html>