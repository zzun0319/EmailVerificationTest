<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Session"%>
<%@page import="javax.mail.Authenticator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="javax.mail.Transport" %>
<%@ page import="javax.mail.Message" %>
<%@ page import="javax.mail.Address" %>
<%@ page import="javax.mail.internet.InternetAddress" %>
<%@ page import="java.util.Properties" %>
<%@ page import="com.junhee.email.user.IUserMapper" %>
<%@ page import="com.junhee.email.util.SHA256" %>
<%@ page import="com.junhee.email.util.Gmail" %>
<%@ page import="java.io.PrintWriter" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>마이페이지</h2>
	<c:if test="${user == null}">
		<script>
			alert("로그인이 필요한 서비스입니다.");
			location.href = "/user/login";
		</script>
	</c:if>
	<c:if test="${user != null }">
		<c:if test="${!user.userEmailChecked}"> <!-- 인증을 안 받은 사용자 -->
			<a href="/user/authentication?userId=${user.userId}"> 인증 메일 발송하기 </a>
		</c:if>
		<c:if test="${user.userEmailChecked}"> <!-- 인증 받은 사용자 -->
			<h2><a href="/file/upload">업로드 페이지로 이동</a></h2>
			<h2><a href="/item/newItem">업로드 페이지로 이동</a></h2>
		</c:if>	
	</c:if>

</body>
</html>

<script>

	const result = "${msg}"
	if(result.length > 0){
		alert(result);
	}

</script>