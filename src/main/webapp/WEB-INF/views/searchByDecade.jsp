<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

<title>${year} Decade Playlist</title>
</head>
<body>


<table class= table>
	<thead>
		<tr>
			<th><h1> ${year} Decade Playlist</h1></th>	
			<th> Add to Favorites</th>	
		</tr>
	</thead>
	<tbody>
		<c:forEach var= "track" items="${decadeTrackList}">
		
		<form class= "form" action= "/addToFavorites" method= "post">
		 <input type="hidden" name="id" value="${track.id}"/>
		 
		
			<tr>
				<td>
				<img src="${track.album.coverSmall}" alt="picture of a ${track.album.title} album cover" >
				${track.title}
				<br>
				${track.artistInfo.name}
				</td>
				<td><button type="submit">Add ${track.title}</button></td>
			
			</tr>
			</form>
		
		</c:forEach>
	
	</tbody>


</table>

<a href="/" class="button">Find More New Music</a>

</body>
</html>