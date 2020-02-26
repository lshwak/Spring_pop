<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script src="../resources/js/button.js"></script>
</head>
<body>
<form id="form1" method="get">
<table border="1">
	<tr>
		<td colspan="2">게시글 수정</td>
	</tr>
	<tr>
		<td>번호</td>
		<td>
		<input type="text" value="${detail.no}" name="no">
		</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>${detail.subject}</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>${detail.content}</td>
	</tr>
	<tr>
		<td>글쓴이</td>
		<td>${detail.writer}</td>
	</tr>
	<tr>
		<td>작성일자</td>
		<td>${detail.write_date}</td>
	</tr>
	<tr>
		<td>조회수</td>
		<td>${detail.cnt}</td>
	</tr>
	<tr>
		<td colspan="2">
			<!-- <input type="submit" value="수정" id="modity">
			<input type="submit" value="삭제" id="delete"> -->
			<a href="modify?no=${detail.no}">수정</a>
			<a href="delete?no=${detail.no}">삭제</a>
		</td>
	</tr>
</table>
</form>
</body>
</html>















