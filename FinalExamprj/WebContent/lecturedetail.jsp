<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	// 인증된 세션이 없는경우, 해당페이지를 볼 수 없게 함.
	if (session.getAttribute("Signedid")==null){
		out.println("<script>alert('로그인 후 이용하실 수 있습니다.');</script>");
		out.println("<script>location.href='/login.jsp'</script>");
	}
%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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

<title>강의 계획서 페이지</title>

<style type="text/css">

.navbar-text {
	font-size: 20px;
	font-family: monospace;
	font-weight: bold;
}

	body {
		margin-top: 150px;
		margin-bottom: 50px;
	   padding-bottom: 10px;
	}
body{
	width: 1150px;
	height:900px;
	margin-left: 70px;}
	
.btn-secondary
{
margin-bottom:5px;
margin-left: 550px;
margin-top: 5px;
width: 100px;
border-color: silver;
font-size: 16px;
text-align: center;
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
						<li><a href="/enrollment">수강신청</a></li>
						<li><a href="/mypage">신청 내역</a></li>
						<li><a href="/deleteLecture">수강 정정 </a></li>
						<li><a href="/notice">공지사항 </a></li>
						<li><a href="/book.jsp">도서검색 </a></li>
						<li><a href="#">커뮤니티</a></li>
					</ul>


					<ul class="nav navbar-nav navbar-right">
					     <li><a href="/miridamgi">미리담기</a></li>
                          <li><a href="/mybag">책가방</a></li>
						<li><a href="/myinfo">회원정보</a></li>
						<li><a href="/logout.jsp">로그 아웃</a></li>
					</ul>


				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	</header>
	
	
	
	 <table class="bbsview" border="1">
            <colgroup>
              <col style="width:150px;">
              <col>
              <col style="width:150px;">
              <col style="width:200px;">
            </colgroup>
            <tbody>          
            <tr>
              <th scope="row" >&nbsp;교과목명</th>
              <td>&nbsp;${plan.name }</td>
            </tr>
            <tr>
              <th scope="row">&nbsp;과목코드</th>
              <td>&nbsp;${plan.code}</td>
 
            </tr>
            <tr>
              <th scope="row">&nbsp;교수</th>
              <td>&nbsp;${plan.professor}</td>
              <th scope="row">&nbsp;학점</th>
              <td>&nbsp;${plan.grades}</td>
            </tr>
            <tr>
              <th scope="row">&nbsp;강의시간</th>
              <td>&nbsp;${plan.time}</td>
              <th scope="row">&nbsp;E-mail</th>
              <td>&nbsp;${plan.email}</td>
            </tr>
            <tr>
              <th scope="row">&nbsp;제한인원</th>
              <td>&nbsp;${plan.personnel}</td>
            </tr>           
            <tr>
              <th scope="row">&nbsp;&nbsp;학습 목표</th>
              <td colspan="3">&nbsp;${plan.goal}</td>
            </tr>
            <tr>
              <th scope="row">&nbsp;교재 및 참고문헌</th>
              <td colspan="3">&nbsp;${plan.book}</td>
            </tr>            
 
            <tr>
              <th>&nbsp;학습 평가방법</th>
              <td colspan="3">&nbsp;${plan.gradeevaluation}&nbsp;</td>
            </tr>
            </tbody>
          </table>
 
          <div style="padding-top: 10px; overflow: hidden;border: solid 0px ;"></div>  
          <table border="1" class="bbsview">
            <caption>주차계획서</caption>
            <colgroup>
              <col style="width:110px;">
              <col>
            </colgroup>             
            <tr>
              <th scope="row" >주차</th>
              <th scope="row">강의범위 및 내용</th>
            </tr>
            <tr>
              <th scope="row">제 1주</th>
              <td>${plan.week1}</td>
            </tr>
            <tr>
              <th scope="row">제 2주</th>
              <td>${plan.week2}&nbsp;</td>
            </tr>
            <tr>
              <th scope="row">제 3주</th>
              <td>${plan.week3}&nbsp;</td>
            </tr>
            <tr>
              <th scope="row">제 4주</th>
              <td>${plan.week4}&nbsp;</td>
            </tr>
            <tr>
              <th scope="row">제 5주</th>
              <td>${plan.week5}&nbsp;</td>
            </tr>
            <tr>
              <th scope="row">제 6주</th>
              <td>${plan.week6}&nbsp;</td>
            </tr>
            <tr>
              <th scope="row">제 7주</th>
              <td>${plan.week7}&nbsp;</td>
            </tr>
            <tr>
              <th scope="row">제 8주</th>
              <td>${plan.week8}</td>
            </tr>
            <tr>
              <th scope="row">제 9주</th>
              <td>${plan.week9}&nbsp;</td>
            </tr>
            <tr>
              <th scope="row">제 10주</th>
              <td>${plan.week10}&nbsp;</td>
            </tr>
            <tr>
              <th scope="row">제 11주</th>
              <td>${plan.week11}&nbsp;</td>
            </tr>
            <tr>
              <th scope="row">제 12주</th>
              <td>${plan.week12}&nbsp;</td>
            </tr>
            <tr>
              <th scope="row">제 13주</th>
              <td>${plan.week13}&nbsp;</td>
            </tr>
            <tr>
              <th scope="row">제 14주</th>
              <td>${plan.week14}&nbsp;</td>
            </tr>
            <tr>
              <th scope="row">제 15주</th>
              <td>${plan.week15}&nbsp;</td>
            </tr>
            <tr>
              <th scope="row">제 16주</th>
              <td>${plan.week16}</td>
            </tr>
          </table>

<script type="text/javascript">
function prev() {
	history.go(-1);
}
</script>


		<button style="margin-left:  450px;  margin-top: 50px;"  type="button" class="btn btn-secondary"	onclick="location='/adminenrollment'">목록</button>
		 <button style="margin-left: -220px; margin-top: 50px;"  type="button"  class="btn btn-secondary" onclick=prev()>이전</button>
		 		 <button style="margin-left: 125px; margin-top: 50px;"  type="button"  class="btn btn-secondary" onclick="location='/book.jsp'">도서 검색</button>
	

</body>
</html>