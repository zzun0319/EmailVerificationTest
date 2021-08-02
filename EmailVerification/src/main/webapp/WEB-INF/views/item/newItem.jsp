<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form method="post" enctype="multipart/form-data">
		<ul>
			<li> 상품명 <input type="text" name="itemName"></li>
			<li> 첨부파일 <input type="file" name="attachedFile"></li>
			<li> 이미지 파일들 <input type="file" multiple="multiple" name="imageFiles"></li>
		</ul>
		<input type="submit" value="제출">
	</form>

</body>
</html>