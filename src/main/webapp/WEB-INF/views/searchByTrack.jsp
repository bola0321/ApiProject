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

<table>
	<thead>
		<tr>
			<th><h1> Results for "${track}"</h1></th>		
		</tr>
	</thead>
	<tbody>
		<c:forEach var= "searchTerm" items="${searchByTrack.data}">
			<tr>
				<td>

				${searchTerm.title} - by ${searchTerm.artistInfo.name}
				<br>
				</td>
			
			</tr>
		
		</c:forEach>
	
	</tbody>


</table>
<a href="/">Back</a>
</body>
</html>