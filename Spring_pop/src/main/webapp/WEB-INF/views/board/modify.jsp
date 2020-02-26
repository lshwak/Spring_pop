<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="modify" method="post">
<table border="1">
	<tr>
		<td colspan="2">게시글 상세내용</td>
	</tr>
	<tr>
		<td>번호</td>
		<td>
			<input type="text" name="no" value="${modify.no}" readonly>
		</td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input type="text" name="subject" value="${modify.subject}"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea name="content">${modify.content}</textarea>
	</tr>
	<tr>
		<td>글쓴이</td>
		<td>${modify.writer}</td>
	</tr>
	<tr>
		<td>작성일자</td>
		<td>${modify.write_date}</td>
	</tr>
	<tr>
		<td>조회수</td>
		<td>${modify.cnt}</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="수정">
		</td>
	</tr>
</table>
</form>
</body>
</html>