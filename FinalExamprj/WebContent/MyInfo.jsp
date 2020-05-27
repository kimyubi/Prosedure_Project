<%@page import="web.index.entity.Notice"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<title>내 정보 페이지</title>

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
	
}
form{margin-left: 150px; margin-top:200px;}

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
						<li><a href="/mypage">신청 내역</a></li>
						<li><a href="#">강의 평가</a></li>
						<li><a href="/notice">공지사항</a></li>
						<li><a href="#">커뮤니티</a></li>
					</ul>


					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">책가방</a></li>
						<li><a href="/myinfo">내 정보</a></li>
						<li><a href="/logout.jsp">로그 아웃</a></li>
					</ul>


				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	</header>
	
	<main>
	
	
	<form action="/myinfo" method="get">
	<div >
	<label style=" margin-left: 200px ; margin-bottom: 20px;"> 이름 :  </label> <input  style="padding-left: 4px;" type="text" name="name"  value="${myinfo.name}"  disabled>
	<label  style=" margin-left: 40px"> 이메일 :  </label> <input style="padding-left: 4px;"  type="text" name="email"  value="${myinfo.email}" disabled> 
	<br>
	<label  style=" margin-left: 173px"> 전화번호 :  </label> <input  style="padding-left: 4px;"   type="text" name="tel"   value="${myinfo.tel}" disabled>
	
	<br><br>
	<label  style=" margin-left: 260px ; margin-top: 20px;"> 단과대를 선택하세요 : </label> 
	
	<select name = "select" style="padding: 8px; padding-right: 100px; padding-bottom: 8px;" >
					<option value='ict' ${(param.select=="ict")?"selected":"" }> ICT융합대학</option>
					<option  value='inmun'  ${(param.select=="inmun")?"selected":"" } >인문대학 </option>
					<option value='sagwa'   ${(param.select=="sagwa")?"selected":"" } >사회과학대학 </option>
					<option  value='beob'  ${(param.select=="beob")?"selected":"" } >법학대학 </option>
					<option  value='gyeong' ${(param.select=="gyeong")?"selected":"" } > 경영대학</option>
					<option  value='gong'  ${(param.select=="gong")?"selected":"" } > 공과대학</option>
					<option  value='jagwa'  ${(param.select=="jagwa")?"selected":"" } >자연과학대학 </option>
					<option  value='yeche' ${(param.select=="title")?"yeche":"" } > 예술체육대학</option>
					<option value='gun'  ${(param.select=="title")?"gun":"" } >건축대학 </option>
		</select><br><br>
		
			<label style=" margin-left: 280px "> 최대 이수가능 학점:  ${maxgrades }</label>  
			</div>
		  <input  style=" margin-left:350px; margin-top: 50px; padding-left:100px; padding-right:100px; text-align: center ;"  class="btn btn-search"	type="submit" value="저장" />
		
			</form>
	
	
	
	
	

	
	
	
	
	
	
	
	</main>
	
	

</body>
</html>