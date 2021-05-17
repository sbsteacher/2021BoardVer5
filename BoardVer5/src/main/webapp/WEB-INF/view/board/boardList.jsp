<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<link rel="stylesheet" href="/res/css/boardList.css">
<script defer src="/res/js/boardList.js"></script>
</head>
<body>
	<h1>리스트</h1>
	<h1>${sessionScope.loginUser.unm} 반갑습니다.</h1>
	<div>		
		 <a href="/user/logout">로그아웃</a>
	</div>
	<div>
		<table>
			<tr>
				<th>no</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일시</th>				
			</tr>
			<c:forEach items="${requestScope.list}" 
				var="item">
				<tr class="record" onclick="moveToDetail(${item.iboard})">
					<td>${item.iboard}</td>
					<td>${item.title}</td>
					<td>${item.unm}</td>
					<td>${item.regdt}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>







