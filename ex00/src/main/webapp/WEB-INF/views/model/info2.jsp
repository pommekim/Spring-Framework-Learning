<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>${user }</h2>
	<%-- <h2>페이지: ${page }</h2> --%>
	
	<c:forEach var="p" items="${pages }" varStatus="status">
		<h2><c:out value="${p }" /></h2>
	</c:forEach>
	
	<c:forEach var="c" items="${cities }" varStatus="status">
		<h2><c:out value="${c }" /></h2>
	</c:forEach>

</body>
</html>