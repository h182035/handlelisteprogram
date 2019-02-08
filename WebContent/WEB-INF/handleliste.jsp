<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">

<title>Varer</title>

</head>
<body>
<div id="header">Inventar</div>
<div id="meny">
<a href="liste">Handleliste</a>
<a href="leggtil">Legg til vare</a>
<a href="slett">Slett varer</a>
<a href="logout">Logg ut</a>
</div>
<div id="content">
	
		
		<c:forEach items="${liste}" var="m">
		<div  style="background-color:${m.farge};">
		<form method="POST">
		${m.navn} <br>

		
		<button type="submit" name="vare" value="${m.navn}"><img src="${pageContext.request.contextPath}/bilder/${m.bilde}" height="100"/> </button>
		<br>
		</form>
		</div>
		</c:forEach>
		
	
	<p>
		
	</p>
	</div>
</body>
</html>