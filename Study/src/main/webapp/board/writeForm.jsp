<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> 글쓰기 </h1>

<form action="./BoardWriteAction.bo" method="post">

	제목 : <input type="text" name="title"> <br>
	작성자 : <input type="text" name="name"> <br>
	내용 : <textarea rows="10" cols="50" name="content" placeholder="내용을 입력하세요."></textarea> <br>
	
	<hr>
	
	비밀번호 : <input type="password" name="pw"> 
	
	<hr>
	
	<input type="submit" value="등록">
	<input type="reset" value="취소">	
</form>

</body>
</html>