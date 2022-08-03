<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Songs Like this... playlist</h1>
<ul>
	<c:forEach var= "bpm" items= "${searchBySimilarities.data}">
		<li>${bpm.title} - by ${bpm.artistInfo.name}</li>
		<br>
		</c:forEach>
</ul>
</body>
</html>