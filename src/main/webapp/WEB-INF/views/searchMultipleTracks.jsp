<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Geographical Playlist</h1>

<ul>
	<c:forEach var= "searchTermPlace" items= "${searchMultipleTracks.data}">
		<li>${searchTermPlace.title}</li>
	


		
	</c:forEach>
</ul>
</body>
</html>
