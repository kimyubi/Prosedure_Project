<%@page import="web.index.entity.Notice"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	// 인증된 세션이 없는경우, 해당페이지를 볼 수 없게 함.
	if (session.getAttribute("Signedid") == null) {
		out.println("<script>alert('로그인 후 이용하실 수 있습니다.');</script>");
		out.println("<script>location.href='/login.jsp'</script>");
	}
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<title>공지사항 페이지</title>

<style type="text/css">
body {
	padding-bottom: 10px;
}

.navbar-text {
	font-size: 20px;
	font-family: monospace;
	font-weight: bold;
}

li {
	padding-top: 2px; font-size;
	font-family: sans-serif;
	font-weight: bold;
}

.footer-bs {
	background-color: #3c3d41;
	padding: 60px 40px;
	color: rgba(255, 255, 255, 1.00);
	margin-bottom: 20px;
	border-bottom-right-radius: 6px;
	border-top-left-radius: 0px;
	border-bottom-left-radius: 6px;
}

.footer-bs .footer-brand, .footer-bs .footer-nav, .footer-bs .footer-social,
	.footer-bs .footer-ns {
	padding: 10px 25px;
}

.footer-bs .footer-nav, .footer-bs .footer-social, .footer-bs .footer-ns
	{
	border-color: transparent;
}

.footer-bs .footer-brand h2 {
	margin: 0px 0px 10px;
}

.footer-bs .footer-brand p {
	font-size: 12px;
	color: rgba(255, 255, 255, 0.70);
}

.footer-bs .footer-nav ul.pages {
	list-style: none;
	padding: 0px;
}

.footer-bs .footer-nav ul.pages li {
	padding: 5px 0px;
}

.footer-bs .footer-nav ul.pages a {
	color: rgba(255, 255, 255, 1.00);
	font-weight: bold;
	text-transform: uppercase;
}

.footer-bs .footer-nav ul.pages a:hover {
	color: rgba(255, 255, 255, 0.80);
	text-decoration: none;
}

.footer-bs .footer-nav h4 {
	font-size: 11px;
	text-transform: uppercase;
	letter-spacing: 3px;
	margin-bottom: 10px;
}

.footer-bs .footer-nav ul.list {
	list-style: none;
	padding: 0px;
}

.footer-bs .footer-nav ul.list li {
	padding: 5px 0px;
}

.footer-bs .footer-nav ul.list a {
	color: rgba(255, 255, 255, 0.80);
}

.footer-bs .footer-nav ul.list a:hover {
	color: rgba(255, 255, 255, 0.60);
	text-decoration: none;
}

.footer-bs .footer-social ul {
	list-style: none;
	padding: 0px;
}

.footer-bs .footer-social h4 {
	font-size: 11px;
	text-transform: uppercase;
	letter-spacing: 3px;
}

.footer-bs .footer-social li {
	padding: 5px 4px;
}

.footer-bs .footer-social a {
	color: rgba(255, 255, 255, 1.00);
}

.footer-bs .footer-social a:hover {
	color: rgba(255, 255, 255, 0.80);
	text-decoration: none;
}

.footer-bs .footer-ns h4 {
	font-size: 11px;
	text-transform: uppercase;
	letter-spacing: 3px;
	margin-bottom: 10px;
}

.footer-bs .footer-ns p {
	font-size: 12px;
	color: rgba(255, 255, 255, 0.70);
}

@media ( min-width : 768px) {
	.footer-bs .footer-nav, .footer-bs .footer-social, .footer-bs .footer-ns
		{
		border-left: solid 1px rgba(255, 255, 255, 0.10);
	}
	.footer-bs {
		margin-top: -111px;
		margin-left: -62px;
		margin-right: -62px;
		padding: -50px
	}
	body {
		margin-top: 110px;
		margin-bottom: 50px
	}
	#page {
		margin-top: 120px;
		padding-left: 500px;
	}
	.table {
		width: 1150px;
		margin-left: 50px;
		margin-bottom: 20px;
	}
	h1 {
		margin-left: 70px;
		margin-bottom: 10px;
		margin-top: 70px; <!--
		font-family: monospace; -->
		font-weight: bolder;
	}
	.table-form {
		margin-left: 900px;
		margin-bottom: 30px;
		margin-top: -40px;
	}
	#main {
		width: 1500px;
	}
}
</style>

</head>

<body>
	<header>
		<nav class="navbar navbar-default  navbar-fixed-top">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<p class="navbar-text">
						<a href="welcomeindex.jsp">Myongji University</a>
					</p>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="/enrollment">수강 신청</a></li>
						<li><a href="#">강의 평가</a></li>
						<li><a href="/notice">공지사항</a></li>
						<li><a href="#">커뮤니티</a></li>
					</ul>


					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">책가방</a></li>
						<li><a href="/mypage">마이페이지</a></li>
						<li><a href="/logout.jsp">로그 아웃</a></li>
					</ul>


				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	</header>
	<main class="main">
		<h1>공지사항</h1>

		<form class="table-form" action="/notice" method="get">

			<select name="selection">
				<option value="title" ${(param.selection=="title")?"selected":"" }>제목</option>
				<option value="nickname"  ${(param.selection=="nickname")? "selected" : "" }>작성자</option>
			</select> <input type="text" name="search"  value="${param.search}"/>
			 <input class="btn btn-search"	type="submit" value="검색" />

		</form>

		<div id="table">
			<table class="table table-hover">
				<thead>
					<tr>

						<th scope="col">&nbsp;&nbsp;번호</th>
						<th scope="col" style="text-align: justify ;" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;제목</th>
						<th scope="col">닉네임</th>
						<th scope="col">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;작성일</th>
						<th scope="col">조회수</th>

					</tr>
				</thead>
				<tbody>

					<c:forEach items="${list}" var="n">
						<tr>
							<th scope="row">&nbsp;&nbsp;&nbsp;&nbsp;${n.id}</th>
							<td style="text-align: center;"><a href="/detail?id=${n.id}"
								style="color: black;">${n.title}</a></td>
							<td>&nbsp;&nbsp;${n.nickname}</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;	<fmt:formatDate value="${n.date}" pattern="YY-MM-dd "/></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;${n.hit}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="margin-top align-center pager">

			<div>

				<c:set var="page" value="${param.p ==null?1:param.p}" />
				<c:set var="startNum" value="${page-(page-1)%5 }" />

			</div>

		
			<c:set var="lastNum" value="10" />
	


			<ul class="-list- center">

				<c:forEach var="i" begin="0" end="4">
					<li><a style="color:  ${ (page == (startNum+i ))?'tomato':''} " 
						href="/notice?p=${startNum+i }&selection=${param.selection }&search=${param.search}">${startNum+i}</a></li>
				</c:forEach>

			</ul>
			
			<div>

				<c:if test="${ startNum!=1}">
					<a href="?p=${startNum-1 }&t=&q=" class="btn btn-prev">이전</a>
				</c:if>

				<c:if test="${ startNum==1}">
					<span class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');">이전</span>
				</c:if>

				<c:if test="${startNum+5 <lastNum }">
					<a href="?p=${startNum+5 }&t=&q=" class="btn btn-next">다음</a>
				</c:if>

				<c:if test="${startNum+5 >=lastNum}">
					<span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음</span>
				</c:if>

			</div>
		</div>


	</main>

</body>
</html>