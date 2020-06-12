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

<title>강의평가 관리 페이지</title>

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
		margin-top: 100px;
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
	h3 {
		margin-left: 70px;
		margin-bottom: 20px;
		margin-top: 70px; <!--
		font-family: monospace; -->
		font-weight: bolder;
	}
	.table-form {
		margin-left: 900px;
		margin-bottom: 10px;
		margin-top: 10px;
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
						<li><a href="/adminenrollment">강의목록 관리</a></li>
						<li><a href="/adminnotice">공지사항</a></li>
						<li><a href="/adminLectureEvaluation">강의평가 관리</a></li>
					</ul>


					<ul class="nav navbar-nav navbar-right">
					   <li><a href="/adminprofile">회원정보 </a></li>
						<li><a href="/logout.jsp">로그 아웃 </a></li>
					</ul>


				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	</header>
  <main>
	
		<form class="table-form" action="/adminLectureEvaluation" method="get" style="  margin-left: 120px; width: 1200px;">

			<select name="selection" style=" padding-bottom:6px; margin-left: -20px;  ">
			
				<option value="name"  ${(param.selection=="name")? "selected" : "" }>교과목명</option>
				<option value="professor"  ${(param.selection=="professor")? "selected" : "" }>교수명</option>
				<option value="id"  ${(param.selection=="id")? "selected" : "" }>작성자 아이디</option>
				<option value="title"  ${(param.selection=="title")? "selected" : "" }>제목</option>
				<option value="content"  ${(param.selection=="content")? "selected" : "" }>내용</option>

			</select>
			 <input autocomplete="off" type="text" name="search"  value="${param.search}"/> 
			 <input class="btn btn-search"   style="margin-left:5px; margin-top:5px;" 	type="submit"  name="button"  value="검색" />

		</form>
		
 </main>
 

	
	
<!---------------------------------------------------강의평가 글 목록----------------------------------------------------------------------------------------------------------->



			<c:forEach items="${list}" var="n">
	
	<table class="table table-striped"
		style="width: 80%; margin-left: 90px;">
		<thead>
			<tr>
				<th scope="col" colspan="4"
					style="padding-bottom: 15px; padding-top: 25px; font-size: 30px; font-weight: border; color: gray; text-align: justify;">
					&nbsp;${n.name}<label
					style="font-size: 16px; font-weight: lighter; margin-left: 12px; color: black;">${n.professor}</label>
					
				</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="4" style="padding-bottom: 10px; padding-top: 15px;">
					<label
					style="margin-left: 30px; margin-top: 15px; font-size: 16px; font-weight: bord;">${n.title}</label> <label
					style="font-weight: lighter; margin-left: 2px;">(${n.studyYear}년 ${n. studySemester}
						수강자)</label>  <label style="font-weight: lighter; margin-left: 860px;">작성자: ${n.id }</label> <br>
				</td>
			</tr>
			<tr>
				<td colspan="4" style="padding-bottom: 20px; padding-top: 15px;">
					<label
					style="margin-left: 30px; margin-right: 90px; margin-top: 5px; font-size: 14px; font-weight: lighter;">
						${n.content}</label> <br>
				</td>

			</tr>
			<tr>

				<td colspan="4"><label
					style="margin-left: 30px; margin-top: 10px; margin-bottom: 20px; font-size: 20px; font-weight: border; color: gray;">[
						성적 반영 ]</label><br> <label
					style="margin-left: 40px; font-size: 16px; font-weight: normal;">
						과제: ${n.task} </label> <label
					style="margin-left: 40px; font-size: 16px; font-weight: normal;">
						조모임: ${n.teample}  </label> <label
					style="margin-left: 40px; font-size: 16px; font-weight: normal;">
						학점 비율: ${n.gradescale} </label> <label
					style="margin-left: 40px; font-size: 16px; font-weight: normal; margin-bottom: 20px;">
						시험 횟수: ${n.exam} </label></td>

			</tr>
			
             <form action="/admindeleteLectureEvaluation" method="post">
              <input type="hidden" name="num" value="${n.num }" >
			<tr>
				<td colspan="4"><label
					style="margin-left: 40px; font-size: 16px; font-weight: border;  margin-bottom:-5px; margin-top: 5px;">총점:
						 ${n.totalScore} </label> <input type= "submit" value="삭제" style="margin-left:900px;margin-top:-50px;  font-weight:lighter;"> 
						<hr style="color: gray; padding-right: 200px; height: 20px;"></td>		 
			</tr>
			</form>
		</tbody>
	</table>
	</c:forEach>

</body>
</html>