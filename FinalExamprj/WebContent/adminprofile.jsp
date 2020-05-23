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
	if (session.getAttribute("adminid") == null) {
		out.println("<script>alert('접근 권한이 없습니다.');</script>");
		out.println("<script>location.href='/index.jsp'</script>");
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

<title>회원정보  페이지</title>

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
						<a href="adminindex.jsp">Myongji University</a>
					</p>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="#">수강 신청</a></li>
						<li><a href="#">강의 평가</a></li>
						<li><a href="/adminnotice">공지사항</a></li>
						<li><a href="#">커뮤니티</a></li>
					</ul>


					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">책가방</a></li>
						<li><a href="adminprofile">회원 정보</a></li>
						<li><a href="/logout.jsp">로그 아웃</a></li>
					</ul>


				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	</header>
	<main class="main">
		<h1>회원 정보</h1>

	   <form action="/adminprofile" method="post">
		
				<table class="table table-hover">
					<thead>
						<tr>

							<th style="width: 180px; text-align: left;" scope="col">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;이름</th>
							<th scope="col" >아이디</th>
							<th scope="col">비밀 번호</th>
							<th scope="col">전화 번호</th>
							<th scope="col">닉네임</th>
							<th scope="col">이메일</th>
							<th scope="col">회원 삭제</th>

						</tr>
					</thead>
					
					<tbody>

				 <c:forEach items="${infolist}" var="i">
							<tr>
							
								<td >&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; ${i.name}</td>
								<td>${i.id}</td>
								<td>&nbsp;&nbsp;${i.password}</td>
								<td> ${i.tel} </td>
								<td>&nbsp;&nbsp;${i.nickname}</td>
								<td>${i.email}</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="select" value="${i.id}"/></td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div  style="margin-left: 1090px;">
				<input  class="btn btn-search" type="submit" value="삭제" /> 
				</div>
				
				</form>
							
	</main>

</body>
</html>