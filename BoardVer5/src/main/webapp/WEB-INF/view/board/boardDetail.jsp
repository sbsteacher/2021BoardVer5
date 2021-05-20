<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${requestScope.data.title}</title>
<link rel="stylesheet" 
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<style>
	.hidden { display: none; }
	.fa-heart { color: red; }
</style>
<script defer src="/res/js/boardDetail.js"></script>
</head>
<body>
	<div><a href="list">리스트로 돌아가기</a></div>
	<h1>${requestScope.data.title} 
		<c:if test="${data.isFav eq 0}">
			<a href="fav?iboard=${param.iboard}&fav=1"><i class="far fa-heart"></i></a>
		</c:if>
		<c:if test="${data.isFav == 1}">
			<a href="fav?iboard=${param.iboard}&fav=0"><i class="fas fa-heart"></i></a>
		</c:if>
	</h1>
	<div>글번호 : ${requestScope.data.iboard}</div>
	<div>작성자 : ${requestScope.data.unm} | 작성일 : ${requestScope.data.regdt}</div>
	<div>${requestScope.data.ctnt}</div>
	
	<h3>댓글</h3>
	<div>${requestScope.data.iboard}, ${param.iboard}</div>
	<div>
		<form id="insFrm" action="cmt" method="post">
			<input type="hidden" name="icmt" value="0">
			<input type="hidden" name="iboard" value="${requestScope.data.iboard}">
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
				<input type="submit" value="댓글작성">
			</div>
		</form>
		
		<form id="updFrm" action="cmt" method="post" class="hidden">
			<input type="hidden" name="icmt" value="0">
			<input type="hidden" name="iboard" value="${requestScope.data.iboard}">
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
				<input type="submit" value="댓글수정">
				<input type="button" value="댓글취소" onclick="showInsFrm();">
			</div>
		</form>
	</div>
	<div>
		<table>
			<tr>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>비고</th>
			</tr>
			<c:forEach items="${requestScope.cmtList}" var="item">
				<tr>
					<td>${item.cmt}</td>
					<td>${item.unm}</td>
					<td>${item.regdate}</td>
					<td>
						<c:if test="${item.iuser == sessionScope.loginUser.iuser}">
							<input type="button" value="수정" onclick="updCmt(${item.icmt}, '${item.cmt.trim()}');">
							<button onclick="delCmt(${requestScope.data.iboard}, ${item.icmt});">삭제</button>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>






