<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Geography Search</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

</head>
<body>
<h1>Geographical Playlist</h1>

<table>
		<thead>
			<tr>
				<th>Song</th>
				<th>Artist</th>
				<th>Add to Favorites</th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach var="searchTerm" items="${displayGeographicalSearch.data}">
		 <form class="form" action="/addToFavorites" method="post">
		 <input type="hidden" name="id" value="${searchTerm.id}"/>
		

		 
		 	 <tr>
		
				<td>${searchTerm.title}</td>
				<td>${searchTerm.artistInfo.name}</td>
				<td><button type="submit">Add ${searchTerm.title}</button></td>
				
			</tr>
				</form>
		
	
		</c:forEach>
		
		</tbody>
	</table>

<a href="/">Back</a>

</body>
</html>

