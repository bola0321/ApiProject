<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Road Trip Music</title>
</head>
<body>
	<h1>Build Your Playlists, Select Your Favorites!</h1>
	<form class="form" action="/searchByTrack" method="post">
		<table>
			<tr>
				<td>Track: <input type="text" name="track"
					placeholder="track"></td>
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
					placeholder="eg, Detroit"></td>
			</tr>
		
		<form class="form" action="/search-by-decade" method="post">
		<table>
			<tr>
				<td>Decade: <input type="number" name="year"
					placeholder="1980"></td>
			</tr>
		</table>
		<input class="button" type="submit" /> <input class="button"
			type="reset" value="Reset" />
	</form>
	
</body>
</html>