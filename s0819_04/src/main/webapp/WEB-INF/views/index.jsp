<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
	</head>
	<body>
		<h2>메인페이지</h2>
		<ul>
			<li><a href="/member/mList">회원리스트</a></li>
	    	<li><a href="/member/mView">회원정보보기</a></li>
			<li><a href="/member/member">회원가입</a></li>
			<li>-----------------------------------------</li>
			<li><a href="/board/blist/1">PathValiable 게시판</a></li>
			<li><a href="/board/blist">PathValiable 값 없는 게시판</a></li>
			<li><a href="/board/board?page=1">파라미터 값으로 전달하는 게시판</a></li>
			<li><a href="/board/board">파라미터 값 없이 전달하는 게시판</a></li>
		</ul>
	</body>
</html>