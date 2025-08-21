<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시판</title>
		<style>
			table{width:800px; margin:10px auto;}
			table, th, td{border:1px solid black; border-collapse:collapse;}
			th, td{width:200px; height:40px; text-align:center;}
		</style>
	</head>
	<body>
		<h2>게시판</h2>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="board" items="${list}">
				<tr>
					<td>${board.id}</td>
					<td>${board.btitle}</td>
					<td>${board.id}</td>
					<td>${board.bdate}</td>
					<td>${board.bhit}</td>
				</tr>
			</c:forEach>
			<tr><td colspan="6"><a href="/">메인페이지로 이동</a></td></tr>
		</table>
	</body>
</html>