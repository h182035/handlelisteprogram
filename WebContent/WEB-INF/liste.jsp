<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Legg til vare</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
<p><a href="juster">Tilbake</a></p>
<h1>Tomt</h1>
<form method="POST">
	<table class="pure-table">
		
		
		<c:forEach items="${liste}" var="m">
		<tr>
		<td>
		${m.navn}
		</td>
		<td>
		<input type="checkbox" name="tomvare" value="${m.navn}"/>
		</td>
		</tr>
		</c:forEach>
		<c:forEach items="${liste3}" var="m">
		<tr>
		<td>
		${m.navn}
		</td>
		<td>
		<input type="checkbox" name="tomvare" value="${m.navn}"/>
		</td>
		</tr>
		</c:forEach>
<tr><td><h1>Nesten tomt</h1></td></tr>
		<c:forEach items="${liste2}" var="m">
		<tr>
		<td>
		${m.navn}
		</td>
		<td>
		<input type="checkbox" name="nestentomvare" value="${m.navn}"/>
		</td>
		</tr>
		</c:forEach>
		<tr><td>
		<button type ="submit" class="knapp">Kjøpt inn</button>
		</td>
		</tr>
	</table>
	</form>

</body>
</html>