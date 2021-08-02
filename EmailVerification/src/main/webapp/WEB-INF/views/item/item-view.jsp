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

	<div class="container">
		<div class="py-5 text-center">
			<h2>상품 조회</h2>
		</div>
		상품명: <span text="${item.itemName}">상품명</span><br>
		<c:if test="${item.attachFile != null}">
		첨부파일: <a href="/item/attach?itemId="${item.id}"><input type="text" value="${item.attachFile.uploadFileName}"></a><br>
		<c:forEach items="${item.imageFiles}" var="itemImg">
			<img src="${itemImg}"><input value="${itemImg.storeFileName}">
		</c:forEach>
		</c:if>
	</div>
	
</body>
</html>