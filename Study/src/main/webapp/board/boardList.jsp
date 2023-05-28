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

<h1><a href="./BoardList.bo">글 목록</a></h1>

<table border="1">

	<c:if test="${search != null }">
		검색어 : ${search }
		<hr>
	</c:if>

	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	
	<c:forEach var="dto" items="${boardList }">
	<tr>
		<td>${dto.bno}</td>
		<td><a href="./BoardDetail.bo?pageNum=${pageNum }&bno=${dto.bno }"> ${dto.title} </a></td>
		<td>${dto.name}</td>
		<td>${dto.date}</td>
		<td>${dto.readcnt}</td>
	</tr>	
	</c:forEach>

</table>

	<c:if test="${count > 0 }">
			
		<c:if test="${startPage > pageBlock }">
			<a href="./BoardList.bo?pageNum=${startPage - pageBlock }
			<c:if test="${search != null}" >
				&search=${search }
			</c:if>
			">이전</a>
		</c:if>
		
		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
			<a href="./BoardList.bo?pageNum=${i }
			<c:if test="${search != null}" >
				&search=${search }
			</c:if>
			">${i }</a>
		</c:forEach>
		
		<c:if test="${endPage < pageCount }">
			<a href="./BoardList.bo?pageNum=${startPage + pageBlock }
			<c:if test="${search != null}" >
				&search=${search }
			</c:if>
			"}>다음</a>			
		</c:if>
			
	</c:if>
	
	<hr>
	
	<form action="./BoardList.bo">
		검색 : <input type="text" name="search">
		<input type="submit" value="검색">
	</form>
	
	<br>
	<input type="button" onclick="location.href='./BoardWrite.bo'" value="글쓰기"> 

</body>
</html>