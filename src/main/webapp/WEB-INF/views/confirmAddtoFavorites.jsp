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
<h1>${tracks.title} added to Favorites!</h1>
<br>
<br>
<table>
		<thead>
			<tr>
		
				<th>Song</th>
				<th>Artist</th>
					<th>Album Cover</th>
			</tr>
		</thead>
		
		<tbody>

		
		
		 	<tr>
				
				<td>${tracks.title}</td>
				<td>${tracks.artistInfo.name}</td>
				
				<td><img src="${tracks.album.coverBig}" title="Album Cover" alt="Album Art for ${tracks.title}" width="100" height="100">
			</tr>
			
		
	

		
		</tbody>
	</table>

<a href="/">Back</a>
</body>
</html>