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

<title>수강내역 페이지</title>

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
	body {
		margin-top: 110px;
		margin-bottom: 50px
	}
	th{text-align: center;}
	tr{text-align: center;}
	.table {
		width: 1150px;
		margin-left: 50px;
		margin-bottom: 20px;
	}
	h3{
		margin-left: 70px;
		margin-bottom: 30px;
		margin-top: 70px; <!--
		font-family: monospace; -->
		font-weight: bolder;
	}
	h4{
	margin-left: 70px;}
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
		<h3>수강신청 내역</h3>
         <h4 >총 수강신청한 학점 수 : ${totalGrades}</h4>
		<div id="table">
			<table class="table table-hover">
				<thead>
					<tr>

						<th scope="col">과목 코드</th>
						<th scope="col" >교과목명</th>
						<th scope="col">강의실</th>
						<th scope="col">정원</th>
						<th scope="col">학점</th>
						<th scope="col">교수명</th>
						<th scope="col">강의시간</th>
						<th scope="col">캠퍼스</th>

					</tr>
				</thead>
				<tbody>

					<c:forEach items="${list}" var="n">
						<tr>
							<td>${n.code}</td>
							<td >${n.name}</td>
							<td >${n.location}</td>
							<td>${n.personnel}</td>
							<td>${n.grades }</td>
							<td>${n.professor}</td>
							<td>${n.time}</td>
							<td>${n.campus}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>




	</main>

</body>
</html>