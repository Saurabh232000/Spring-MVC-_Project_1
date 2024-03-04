<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="m" items="${fetchsP }">
		<h2>${m.id }</h2>
		<h2>${m.name }</h2>
		<h2>${m.phone }</h2>
		<h2>${m.email }</h2>
		<h2>${m.password }</h2>
		<h2>${m.gst}</h2>
	</c:forEach>
</body>
</html>
