<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
	<div class="container">
	
		<div class="py-5 text-center">
			<h2>상품 등록 폼</h2>
		</div>
		
		<h4 class="mb-3">상품 입력</h4>
		
		<form method="post" enctype="multipart/form-data">
			<ul>
				<li>상품명 <input name="itemName"></li>
				<li>파일 <input type="file" name="file"></li>
			</ul>
			<input type="submit">
		</form>
	
	</div>
</form>
</body>
</html>