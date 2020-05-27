<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%  // 인증된 세션이 없는경우, 해당페이지를 볼 수 없게 함.
    if (session.getAttribute("Signedid") == null) {
        response.sendRedirect("/login.jsp");
    }
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<title>수강 신청 페이지</title>

<style type="text/css">
  body {margin-top: 95px;   margin-left:350px;}
  form{
   margin-left: 50px;}
 .navbar-text{ font-size: 20px; font-family: monospace; font-weight: bold; }
 li{  padding-top:2px; font-size; font-family: sans-serif; font-weight: bold;  }
@media (min-width: 768px) {
	.footer-bs .footer-nav, .footer-bs .footer-social, .footer-bs .footer-ns { border-left:solid 1px rgba(255,255,255,0.10); }
</style>

</head>

<body>
<header>
<nav class="navbar navbar-default  navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <p class="navbar-text"><a href="welcomeindex.jsp">Myongji University</a> </p>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
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
        <li><a href="/logout.jsp" >로그 아웃</a></li>
      </ul>
      
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</header>

<input  style=" margin-left: 50px; margin-bottom: 15px; width: 200px; background-color:#F0F0F0;"class="btn btn-search" value="인문 캠퍼스"  onclick = "location.href = '/enrollment' "/> 
<input  style=" margin-left: 5px; margin-bottom : 15px; width: 200px; background-color:  silver;"class="btn btn-search"  value="자연 캠퍼스"  onclick = "location.href = '/enrollmentJa' "/> 


		<form class="table-form" action="/enrollmentJa" method="get" style="margin-left: 100px; width: 1200px;">

			<select name="selection" style=" padding-bottom:6px; margin-left: -20px;  ">
				<option  value="code" ${(param.selection=="code")?"selected":"" }>과목코드</option>
				<option value="name"  ${(param.selection=="name")? "selected" : "" }>교과목명</option>
				<option value="location"  ${(param.selection=="location")? "selected" : "" }>강의실</option>
				<option value="grades"  ${(param.selection=="grades")? "selected" : "" }>학점</option>
				<option value="professor"  ${(param.selection=="professor")? "selected" : "" }>교수명</option>
				<option value="colleage"  ${(param.selection=="colleage")? "selected" : "" }>단과대</option>
				<option value="department"  ${(param.selection=="department")? "selected" : "" }>학부/학과</option>
			</select>
			 <input type="text" name="search"  value="${param.search}"/> 
			 <input class="btn btn-search"	type="submit"  value="검색" />

		</form>

<main class="main">


	   <form action="/enrollmentJa" method="post">
		<table class="table table-hover" style="width: 1200px; margin-left: -350px; margin-top: 40px;" >
					<thead>
						<tr>
							<th scope="col"  style="text-align: center;">과목코드</th>
							<th scope="col" style="text-align: center;">&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; 교과목명</th>
							<th scope="col"style="text-align: center;">&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; 강의실</th>
							<th scope="col"style="text-align: center;">&nbsp;&nbsp;&nbsp;&nbsp; 정원</th>
							<th scope="col"style="text-align: center;">&nbsp;&nbsp;&nbsp;&nbsp; 학점</th>
							<th scope="col"style="text-align: center;">&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; 교수명</th>
							<th scope="col"style="text-align: center;">강의시간</th>
						    <th scope="col" style="text-align: center;">수강신청</th>

						</tr>
					</thead>
				
					<tbody>
				 <c:forEach items="${list}" var="i">
							<tr>
								   
								<td >&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; ${i.code}</td>
								<td style="text-align: center;">&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; ${i.name}</td>
								<td style="text-align: center;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; ${i.location}</td>
								<td style="text-align: center;">&nbsp;&nbsp;&nbsp;&nbsp;  ${i.personnel} </td>
								<td style="text-align: center;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${i.grades}</td>
								<td style="text-align: center;">&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; ${i.professor}</td>
								<td style="text-align: center;">${i.time}</td>
								<td style="text-align:  center;"> 
								<button name="code" value="${i.code }">수강신청</button>
								</td>
								
							</tr>
						</c:forEach>
					</tbody>
						
				</table>
						
	
				<div  style="margin-left: 1090px;">
			
				</div>
				
				</form>
							
	</main>

</body>
</html>