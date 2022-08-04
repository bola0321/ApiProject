<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation - Added to Favorites</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

</head>
<body>
<table>
		<thead>
			<tr>
			<th>Album Cover</th>
				<th>Song</th>
				<th>Artist</th>
				
			</tr>
		</thead>
		<tbody>
		
		<c:forEach var="track" items="${track.data}">
		
		 	<tr>
				<td>${track.title}</td>
				<td>${track.artist.name}</td>
				
				
			</tr>
			
		
	
		</c:forEach>
		
		</tbody>
	</table>

<a href="/">Back</a>
</body>
</html>