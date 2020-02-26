<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../resources/plugins/jQuery/jquery-3.4.1.js">
</script>
<script src="../resources/js/uploadwrite.js"></script>
<link rel="stylesheet" href="../resources/css/upload.css"></link>
</head>
<body>
<h3>글쓰기를 하기 위한 폼입니다.</h3>
<form action="register" method="post" enctype="multipart/form-data">
	제목 : <input type="text" name="subject">
	내용 : <textarea name="content"></textarea>
	글쓴이 : <input type="text" name="writer">
	조회수 : <input type="text" name="cnt">
	파일 : <input type="file" name="filename">
	<input type="submit" value="글쓰기">
</form> 
<div class="fileDrop"></div>
<div class="uploadedList"></div>
</body>
</html>

