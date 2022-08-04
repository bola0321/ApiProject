<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

<title>Playlist Builder</title>
</head>
<body>
	<h1> Plylst</h1>
	<h3> build something new &#8482</h3>
	<form class="form" action="/searchByTrack" method="post">
		<table>
			<tr>
				<td>Track: <input type="text" name="track"
					placeholder="Song title" required></td>
			</tr>
		</table>
		<input class="button" type="submit" /> <input class="button"
			type="reset" value="Reset" />
	</form>
	<br>
	<br>
	<form class="form" action="/displayGeographicalSearch" method="post">
		<table>
			<tr>
				<td>Location: <input type="text" name="searchTerm"
					placeholder="eg, Detroit" required></td>
			</tr>
		</table>
		<input class="button" type="submit" /> <input class="button"
			type="reset" value="Reset" />
		</form>
	<br>
	<br>	
	<form class="form" action="/search-by-decade" method="post">
		<table>
			<tr>
				<td>Decade: <input type="number" name="year" min="1950" max="2020" step= "10"
					placeholder="1980" required></td>
			</tr>
		</table>
		<input class="button" type="submit" /> <input class="button"
			type="reset" value="Reset" />
	</form>
	<br>
	<br>
	<form class="form" action="/searchSongsLikeThis" method="post">
		<table>
			<tr>
				<td>BPM: <input type="number" name="bpm"
					placeholder="bpm" required></td>
			</tr>
		</table>
		<input class="button" type="submit" /> <input class="button"
			type="reset" value="Reset" />
	</form>
<br>			
<h4><a href="/showFavorites" class="button">Show Favorites List</a></h4>

</body>
</html>