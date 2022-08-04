<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

<title>Show Artist</title>
</head>
<body>
<h1>Artist selected:</h1>
<ul>
	<c:forEach var= "music" items= "${music}">
		<li>${music.id}</li>
		<li>${music.track}</li>
	
	</c:forEach>
</ul>

	<thead>
		<tr>
			<th><h1> ${artist} Playlist</h1></th>		
		</tr>
	</thead>
	<tbody>
		<c:forEach var= "music" items="${music}">
			<tr>
				<td>
				${music.id}
				<br>
				${music.track}	
				</td>
			
			</tr>
		
		</c:forEach>
	
	</tbody>


</table>
</body>
</html>