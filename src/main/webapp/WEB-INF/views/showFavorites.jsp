<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Favorites</title>
</head>
<body>
<h1>Your Favorite Tracks: </h1>
<table class= table>

 <c:set var = "count" value = "${count}"/>
      <c:if test = "${count < 1}">
         <p>Favorites is empty!<p>
      </c:if>
      <thead>
      <tr><th>Song</th>
      <th>Artist</th></tr>
      </thead>
		<tbody>
		
		<c:forEach var="track" items="${favorites}">
		 
		<tr>	<td>${track.trackName}</td>
					<td>${track.artist}</td>
				<td><a href="/deleteFromFavorites?id=${track.trackid}">Remove from Favorites</a></td>			
	</tr>	

		
		</c:forEach>
		
		</tbody>
		
	</table>

<a href="/" class="button">Find More New Music</a>


</body>
</html>