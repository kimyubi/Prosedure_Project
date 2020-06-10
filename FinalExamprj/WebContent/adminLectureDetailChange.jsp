<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<title>강의계획서 수정페이지</title>

<style type="text/css">
  body {margin-top: 95px;   margin-left:350px;}
  form{
   margin-left: 50px;}
 .navbar-text{ font-size: 20px; font-family: monospace; font-weight: bold; }
 li{  padding-top:2px; font-size; font-family: sans-serif; font-weight: bold;  }
 	h5{
	margin-left: -270px;
	margin-bottom: 10px;}
@media (min-width: 768px) {
	.footer-bs .footer-nav, .footer-bs .footer-social, .footer-bs .footer-ns { border-left:solid 1px rgba(255,255,255,0.10); }
	
	.col-sm-6{margin-left: -350px;}
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
      <p class="navbar-text"><a href="adminindex.jsp">Myongji University</a> </p>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
       <li><a href="/adminenrollment">강의목록 관리</a></li>
		<li><a href="/adminnotice">공지사항</a></li>
		<li><a href="#">커뮤니티</a></li>
      </ul>
      
  
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/adminprofile">회원정보 </a></li>
        <li><a href="/logout.jsp" >로그 아웃 </a></li>
      </ul>
      
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</header>

 <div class="container">
    <div class="row">
    <div class="col-sm-12 text-center" >
    <div class="col-sm-3"></div>
     
    <div class="col-sm-6">
    <h2 style="margin-left: 55px; margin-bottom: 15px;"> 강의계획서 수정 </h2>
    <form action="/lecturedetailChange" method="post">
        <table class="table table-boardered">
            <tr>
                <th>과목코드</th>
                <td><input type="text" class="form-control" name="code" disabled required value="${plan.code }" ></td>        
            </tr>
            <tr>
                <th>E-mail</th>
                <td><input type="text" class="form-control" name="email" placeholder="이메일을 입력하세요." required  value="${plan.email }"></td>      
            </tr>
             
            <tr>
                <th>학습목표</th>
                <td><textarea class="form-control" name="goal" placeholder="학습목표를 입력하세요." required  >${plan.goal }</textarea></td>        
            </tr>
            
               <tr>
                <th>교재 및 참고문헌</th>
                <td><input type="text" class="form-control" name="book"   placeholder="교재 및 참고문헌을 입력하세요."  required  value = "${plan.book }"></td>        
             </tr>
             
              <tr>
                <th>학습 평가방법</th>
                <td><input type="text" class="form-control" name="gradeevaluation"  placeholder="학습 평가방법을 입력하세요." required value="${plan.gradeevaluation}"></td>        
             </tr>
             
             <tr>
                 <th colspan="2" style="text-align: center;"> 주차 계획서</th>  
             </tr>
             
               <tr>
                <th>Week1</th>
                <td><input type="text" class="form-control" name="week1"  required value = "${plan.week1 }"></td>        
             </tr>
             
               <tr>
                <th>Week2</th>
                <td><input type="text" class="form-control" name="week2" required value = "${plan.week2 }"></td>        
             </tr>
             
               <tr>
                <th>Week3</th>
                <td><input type="text" class="form-control" name="week3" required value = "${plan.week3 }"></td>        
             </tr>
               <tr>
                <th>Week4</th>
                <td><input type="text" class="form-control" name="week4" required value = "${plan.week4 }"></td>        
             </tr>
               <tr>
                <th>Week5</th>
                <td><input type="text" class="form-control" name="week5" required value = "${plan.week5 }"></td>        
             </tr>
               <tr>
                <th>Week6</th>
                <td><input type="text" class="form-control" name="week6" required value = "${plan.week6 }"></td>        
             </tr>
               <tr>
                <th>Week7</th>
                <td><input type="text" class="form-control" name="week7" required value = "${plan.week7 }" ></td>        
             </tr>
               <tr>
                <th>Week8</th>
                <td><input type="text" class="form-control" name="week8"  required value = "${plan.week8 }"></td>        
             </tr>
             
               <tr>
                <th>Week9</th>
                <td><input type="text" class="form-control" name="week9"  required value = "${plan.week9 }"></td>        
             </tr>
             
               <tr>
                <th>Week10</th>
                <td><input type="text" class="form-control" name="week10" required value = "${plan.week10 }"></td>        
             </tr>
               <tr>
                <th>Week11</th>
                <td><input type="text" class="form-control" name="week11"  required value = "${plan.week11 }"></td>        
             </tr>
               <tr>
                <th>Week12</th>
                <td><input type="text" class="form-control" name="week12"  required value = "${plan.week12}"></td>        
             </tr>
               <tr>
                <th>Week13</th>
                <td><input type="text" class="form-control" name="week13" required value = "${plan.week13 }"></td>        
             </tr>
               <tr>
                <th>Week14</th>
                <td><input type="text" class="form-control" name="week14"  required value = "${plan.week14 }"></td>        
             </tr>
               <tr>
                <th>Week15</th>
                <td><input type="text" class="form-control" name="week15" required  value = "${plan.week15 }"></td>        
             </tr>
               <tr>
                <th>Week16</th>
                <td><input type="text" class="form-control" name="week16"  required value = "${plan.week16 }"></td>        
             </tr>
             
               <tr>
                <td colspan="2">
                 <input  style="padding-left: 200px; padding-right: 200px; margin-top: 10px;"   class="btn btn-search"	type="submit"  name="button"  value="수정" />
                </td>
            </tr>

		</table>
    </form>
    </div>
     
    </div>
    </div>
</div>

						


</body>
</html>