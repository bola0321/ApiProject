<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search By Track</title>
</head>
<body>
<h2>Search by track plz.</h2>
<ul>
	<c:forEach var= "searchTerm" items= "${searchByTrack.data}">
		<li>${searchTerm.title} - by ${searchTerm.artistInfo.name}</li>
		<br>
		</c:forEach>
		
</ul>
<a href="/">Back</a>
</body>
</html>