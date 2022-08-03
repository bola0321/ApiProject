<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Artist</title>
</head>
<body>
<h1>Artist selected:</h1>
<ul>
	<c:forEach var= "music" items= "${music}">
		<li>${music.id}</li>
		<li>${music.track}</li>
	
	</c:forEach>
</ul>
</body>
</html>