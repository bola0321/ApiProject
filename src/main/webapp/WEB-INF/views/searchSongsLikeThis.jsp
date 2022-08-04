<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Songs Like This</title>

<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">

</head>
<body>

	<table class=table>
		<thead>
			<tr>
				<th><h1>Songs with Tempo of "${bpm} BPM"</h1></th>
				<th>Add to Favorites</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="bpm" items="${similarTrackList.data}">


				<form class="form" action="/addToFavorites" method="post">
					<input type="hidden" name="id" value="${bpm.id}" />
					<tr>
						<td><img src="${bpm.album.coverSmall}"
							alt="picture of album cover"> ${bpm.title} <br>
							${bpm.artistInfo.name}</td>
						<td><button type="submit">Add ${bpm.title}</button></td>

					</tr>
				</form>


			</c:forEach>

		</tbody>
	</table>
	<h3>
		<a href="/showFavorites" class="button">Show Favorites List</a>
	</h3>
</body>
</html>