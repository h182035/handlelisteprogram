<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">
<meta charset="ISO-8859-1">
<title>Legg til vare</title>
</head>
<body>
<div id="leggtil">
<form method="POST" enctype="multipart/form-data">
<p>Navn på vare: <input type="text" name="navn"/> </p>
<p> Legg ved bilde:<input type="file" name="fil"> </p>
<p><input type="submit" name="vanlig"/></p>
</form>
</div>

<div id="leggtil2">
<form method="POST">
<div id="varer">
<p>Navn på varer: </p>
<input type="text" name="navn" id="forslag"/> <button type="button" id="add">+</button>
<br>
<script>
forslag.addEventListener("keydown", visForslag);
	let liste = [];
function visForslag(){
	liste.push(
	      <c:forEach items="${liste}" var="m">
	        "<c:out value="${m}" />",
	      </c:forEach>
	   );
	   console.log(liste);
}
</script>
</div>
<p><input type="submit" name="uvanlig"/></p>
</form>
</div>
<script type="text/javascript" charset="ISO-8859-1" src="${pageContext.request.contextPath}/addInput.js" defer></script>
</body>
</html>