<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<script type="text/javascript" src="<c:url value="/js/jquery-3.5.1.js" />"></script>
</head>
<body>
	<form method="post" id="register_form">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input name="userId" id="userId"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="userPw" id="userPw"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input name="userEmail" id="userEmail"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="회원가입" onclick="CheckInput()"></td>
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

	function CheckInput() {
		
		if($("#userId").val() === "" || $("#userPw").val() === "" || $("#userEmail").val() === ""){
			alert("입력 안 된 사항이 있습니다.");
		}else{
			register_form.submit();
		}
		
	}

</script>