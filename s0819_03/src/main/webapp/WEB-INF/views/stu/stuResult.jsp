<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>입력결과</title>
		<style>
			table{width:400px; margin:10px auto;}
			table, th, td{border:1px solid black; border-collapse:collapse;}
			th, td{width:200px; height:40px; text-align:center;}
		</style>
	</head>
	<body>
		<h2>입력결과</h2>
		<table>
			<tr>
				<th>번호</th>
				<td>${student.sno}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${student.name}</td>
			</tr>
			<tr>
				<th>국어</th>
				<td>${student.kor}</td>
			</tr>
			<tr>
				<th>영어</th>
				<td>${student.eng}</td>
			</tr>
			<tr>
				<th>수학</th>
				<td>${student.math}</td>
			</tr>
			<tr>
				<th>합계</th>
				<td>${student.total}</td>
			</tr>
			<tr>
				<th>평균</th>
				<td><fmt:formatNumber value="${student.avg}" pattern="00.##" /></td>
			</tr>
			<tr>
				<th colspan="2"><a href="/">메인페이지 이동</a></th>
			</tr>
		</table>
	</body>
</html>