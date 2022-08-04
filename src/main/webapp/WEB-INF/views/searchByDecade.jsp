<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Decade Playlist</title>
</head>
<body>

<h1> Decade playlist</h1>
<ul>
	<c:forEach var= "track" items= "${decadeTrackList}">
		<li>${track.title}</li>
	</c:forEach>
</ul>


</body>
</html>