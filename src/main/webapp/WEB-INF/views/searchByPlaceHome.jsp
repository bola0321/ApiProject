<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Music Home</title>
</head>
<body>
	<h1>Here. Is. Music.</h1>
	<form class="form" action="/searchMultipleTracks" method="post">
		<table>
			<tr>
				<td>Location: <input type="text" name="searchTerm"
					placeholder="eg, Detroit"></td>
			</tr>
		</table>
		<input class="button" type="submit" /> <input class="button"
			type="reset" value="Reset" />
	</form>
</body>
</html>