<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="form1" action="uploadForm" method="post" enctype="multipart/form-data">
		<input type="file" name="file">
		<input type="submit">
	</form>
	<div>
		<img src="D:\upload\${savedName}">
	</div>
</body>
</html>