<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

<title>${searchTerm} Search</title>
</head>
<body>


<table class= table>
		<thead>
			<tr>
				<th style="width:50%"><h1> "${searchTerm}" Playlist  </h1></th>
				<th>Add to Favorites</th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach var="searchTerm" items="${displayGeographicalSearch.data}">
		
		
		 <form class="form" action="/addToFavorites" method="post">
		 <input type="hidden" name="id" value="${searchTerm.id}"/>
		
		 	 <tr>
				<td>
				<img src= "${searchTerm.album.coverSmall}" alt= "picture of album cover">
				${searchTerm.title}
				<br>
				${searchTerm.artistInfo.name}
				</td>
				<td><button type="submit">Add ${searchTerm.title}</button></td>
				
			</tr>
			</form>
		
	
		</c:forEach>
		
		</tbody>
	</table>

<a href="/" class="button">Generate a New Playlist</a>

</body>
</html>

