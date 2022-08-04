<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Favorites</title>
</head>
<body>
<h2>Show favorites</h2>

<c:forEach var="tracks" items="${track.data}">
		
		
		 	 <tr>
		
				<td>${tracks.title}</td>
				<td>${tracks.artistInfo.name}</td>
				
				
			</tr>
			
		
	
		</c:forEach>

</body>
</html>