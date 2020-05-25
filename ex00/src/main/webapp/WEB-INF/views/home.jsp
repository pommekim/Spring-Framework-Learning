<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<form action="/controller/test/param" method="post">
	<input type="text" name="name" value="테스트">
	<input type="text" name="age" value="123">
	<input type="submit" value="POST 방식으로 요청하기">
</form>

<hr>

<form action="/controller/test/param" method="get">
	<input type="text" name="name" value="테스트">
	<input type="text" name="age" value="123">
	<input type="submit" value="GET 방식으로 요청하기">
</form>

</body>
</html>
