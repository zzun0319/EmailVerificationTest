<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.junhee.email.util.SHA256" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<script type="text/javascript" src="<c:url value="/js/jquery-3.5.1.js" />"></script>
</head>
<body>
	

</body>
</html>

<script>

	const result = "${msg}"
	if(result.length > 0){
		alert(result);
	}

</script>