<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

<title>Search By Track</title>
</head>
<body>

<table class = table>
	<thead>
		<tr>
			<th><h1> Results for "${track}"</h1></th>
			<th>Add to Favorites</th>		
		</tr>
		
	</thead>
	<tbody>
		<c:forEach var= "searchTerm" items="${searchByTrack.data}">
		
			<form class= "form" action="/addToFavorites" method="post">
			<input type="hidden" name= "id" value= ${searchTerm.id}/>
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
<a href="/" class="button">Find More New Music</a> | <a href="/showFavorites" class="button">Show Favorites List</a>
</body>
</html>