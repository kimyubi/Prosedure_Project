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

<title>강의추가 페이지</title>

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
    <h2 style="margin-left: 55px; margin-bottom: 15px;"> 강의 신규등록 </h2>
    <form action="/adminLectureAdd" method="post">
        <table class="table table-boardered">
            <tr>
                <th>과목코드</th>
                <td><input type="text" class="form-control" name="code" placeholder="과목코드를 입력하세요." required></td>        
            </tr>
            <tr>
                <th>교과목명</th>
                <td><input type="text" class="form-control" name="name" placeholder="교과목명을 입력하세요." required></td>      
            </tr>
             
            <tr>
                <th>강의실</th>
                <td><input type="text" class="form-control" name="location" placeholder="강의실을 입력하세요." required ></td>        
            </tr>
            
               <tr>
                <th>정원</th>
                <td><input type="text" class="form-control" name="personnel" placeholder="정원을 입력하세요." required ></td>        
             </tr>
             
              <tr>
                <th>학점</th>
                <td><input type="text" class="form-control" name="grades" placeholder="학점을 입력하세요." required ></td>        
             </tr>
             
             <tr>
                <th>교수명</th>
                <td><input type="text" class="form-control" name="professor" placeholder="교수명을 입력하세요." required ></td>        
             </tr>
             
             <tr>
                <th>강의시간</th>
                <td><input type="text" class="form-control" name="time" placeholder="강의시간 입력하세요." required ></td>        
             </tr>
             
            <tr>
                <th>캠퍼스</th>
                <td>
                 <select name="campus" class="form-control">
                    <option value="인문캠퍼스">인문캠퍼스</option>
                    <option value="자연캠퍼스">자연캠퍼스</option>
                 </select>
                </td>     
            </tr>
            
               <tr>
                <th>단과대</th>
                <td><input type="text" class="form-control" name="colleage" placeholder="단과대를 입력하세요." required ></td>        
             </tr>
             
                <tr>
                <th>학부/학과</th>
                <td><input type="text" class="form-control" name="department" placeholder="학부/학과를 입력하세요." required ></td>        
             </tr>
             
               <tr>
                <td colspan="2">
                 <input  style="padding-left: 200px; padding-right: 200px; margin-top: 10px;"   class="btn btn-search"	type="submit"  name="button"  value="등록" />
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