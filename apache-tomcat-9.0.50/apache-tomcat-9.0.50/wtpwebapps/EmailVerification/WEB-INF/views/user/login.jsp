<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<script type="text/javascript" src="<c:url value="/js/jquery-3.5.1.js" />"></script>
</head>
<body>
	<h2>로그인 페이지</h2>
	
	<form method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input name="userId"></td>
			</tr>		
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="userPw"></td>
			</tr>		
			<tr>
				<td colspan="2"><button type="submit">로그인</button></td>
			</tr>		
		</table>
	</form>
	
</body>
</html>

<script>

	const result = "${msg}"
	if(result.length > 0){
		alert(result);
	}

</script>