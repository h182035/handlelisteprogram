<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Slett varer</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
<p><a href="juster">Tilbake</a></p>
<h1>Slett varer ved å huke av</h1>
<form method="POST">
	<table class="pure-table">
		
		
		<c:forEach items="${liste}" var="m">
		<tr>
		<td>
		${m.navn}
		</td>
		<td>
		<input type="checkbox" name="slettvare" value="${m.navn}"/>
		</td>
		</tr>
		</c:forEach>
		<tr><td>
		<button type ="submit">Slett valgte varer</button>
		</td>
		</tr>
	</table>
	</form>

</body>
</html>