<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>메일 보내기</h4>
<form action="mail" method="post">
받는 사람 : <input type="text" name="tomail" value="ls_hwak@naver.com" placeholder>
체목  : <input type="text" name="title">
내용 : <textarea rows="12" cols="120" name="content"></textarea>
보내는 사람 : <input type="text" name="from">
		<input type="submit" value="이메일 보내기">
</form>
</body>
</html>