<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>상세 내용</h1>

	<table border="1">
		
		<tr>
			<th>글번호</th>
			<td>${dto.bno }</td>
			<th>작성일</th>
			<td>${dto.date }</td>
			<th>조회수</th>
			<td>${dto.readcnt }</td>
		</tr>
		
		<tr>
			<th colspan="2">제목</th>
			<td colspan="4">${dto.title }</td>
		</tr>

		<tr>
			<th colspan="2">내용</th>
			<td colspan="4">${dto.content }</td>
		</tr>
	
	</table>
	
	<hr>
	
	<input type="button" value="수정" onclick="location.href=''">
	<input type="button" value="삭제" onclick="location.href=''">

	<input type="button" value="목록으로" onclick="location.href='./BoardList.bo?pageNum=${pageNum}'">
	
</body>
</html>