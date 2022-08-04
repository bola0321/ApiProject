<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Songs Like This</title>
</head>
<body>
<h1>Songs Like This... Playlist</h1>

<ul>
	<c:forEach var= "bpm" items= "${similarTrackList.data}">
	<input type="hidden" name= "id" value= "${bpm.id}"/>
	<input type="hidden" name="cover" value="${bpm.album.coverSmall}"/>
		<li>${bpm.title}</li>
		<br>
		</c:forEach>
		
</ul>
</body>
</html>