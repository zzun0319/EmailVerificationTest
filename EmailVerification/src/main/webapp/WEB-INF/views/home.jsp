<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<c:if test="${user == null}">
	<a href="/user/register">회원가입</a> <br><br>
	<a href="/user/login">로그인</a> <br><br>
</c:if>
<c:if test="${user != null}">
	<a href="/file/upload">파일 업로드</a>
</c:if>


</body>
</html>
