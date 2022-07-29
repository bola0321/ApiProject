<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Music Home</title>
</head>
<body>
	<h1>Here. Is. Music.</h1>
	<form class="form" action="/searchByArtist" method="post">
		<table>
			<tr>
				<td>Artist: <input type="text" name="artist"
					placeholder="Rihanna"></td>
			</tr>
		</table>
		<input class="button" type="submit" /> <input class="button"
			type="reset" value="Reset" />
	</form>
</body>
</html>