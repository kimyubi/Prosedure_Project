<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
 .navbar-text{ font-size: 20px; font-family: monospace; font-weight: bold; }
 .footer-bs {
    background-color: #3c3d41;
	padding: 60px 40px;
	color: rgba(255,255,255,1.00);
	margin-bottom: 20px;
	border-bottom-right-radius: 6px;
	border-top-left-radius: 0px;
	border-bottom-left-radius: 6px;
}
.footer-bs .footer-brand, .footer-bs .footer-nav, .footer-bs .footer-social, .footer-bs .footer-ns { padding:10px 25px; }
.footer-bs .footer-nav, .footer-bs .footer-social, .footer-bs .footer-ns { border-color: transparent; }
.footer-bs .footer-brand h2 { margin:0px 0px 10px; }
.footer-bs .footer-brand p { font-size:12px; color:rgba(255,255,255,0.70); }
.footer-bs .footer-nav ul.pages { list-style:none; padding:0px; }
.footer-bs .footer-nav ul.pages li { padding:5px 0px;}
.footer-bs .footer-nav ul.pages a { color:rgba(255,255,255,1.00); font-weight:bold; text-transform:uppercase; }
.footer-bs .footer-nav ul.pages a:hover { color:rgba(255,255,255,0.80); text-decoration:none; }
.footer-bs .footer-nav h4 {
	font-size: 11px;
	text-transform: uppercase;
	letter-spacing: 3px;
	margin-bottom:10px;
}
.footer-bs .footer-nav ul.list { list-style:none; padding:0px; }
.footer-bs .footer-nav ul.list li { padding:5px 0px;}
.footer-bs .footer-nav ul.list a { color:rgba(255,255,255,0.80); }
.footer-bs .footer-nav ul.list a:hover { color:rgba(255,255,255,0.60); text-decoration:none; }
.footer-bs .footer-social ul { list-style:none; padding:0px; }
.footer-bs .footer-social h4 {
	font-size: 11px;
	text-transform: uppercase;
	letter-spacing: 3px;
}
.footer-bs .footer-social li { padding:5px 4px;}
.footer-bs .footer-social a { color:rgba(255,255,255,1.00);}
.footer-bs .footer-social a:hover { color:rgba(255,255,255,0.80); text-decoration:none; }
.footer-bs .footer-ns h4 {
	font-size: 11px;
	text-transform: uppercase;
	letter-spacing: 3px;
	margin-bottom:10px;
}
.footer-bs .footer-ns p { font-size:12px; color:rgba(255,255,255,0.70); }
@media (min-width: 768px) {
	.footer-bs .footer-nav, .footer-bs .footer-social, .footer-bs .footer-ns { border-left:solid 1px rgba(255,255,255,0.10); }
	
	
.footer-bs{ margin-top: 130px; margin-left: -40px; margin-right: -62px; padding: -50px ; }
 
  li{  padding-top:2px; font-size; font-family: sans-serif; font-weight: bold;  }
 @media (min-width: 768px) {
	.footer-bs .footer-nav, .footer-bs .footer-social, .footer-bs .footer-ns { border-left:solid 1px rgba(255,255,255,0.10); 
	}
	.form-signin{margin-top: 20px; }
	.main{ background-image: url("https://cdn.pixabay.com/photo/2015/12/27/05/48/turntable-1109588_1280.jpg" );
	background-size: cover; padding-bottom: 900px; margin-top: 100px}
	
	body{margin-top: 80px}
	
.alert-info{
padding: 5px; 
}
</style>
<title>회원가입 페이지</title>
</head>
<body >
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
      <p class="navbar-text"><a href="index.jsp">Myongji University</a></p>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
          <li><a href="#">수강 신청</a></li>
           <li><a href="#">강의 평가</a></li>
          <li><a href="#">공지사항</a></li>
          <li><a href="#">커뮤니티</a></li>
      </ul>
  
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">책가방</a></li>
        <li><a href="#">마이페이지</a></li>
        <li><a href="login.jsp" >로그인</a></li>
         <li><a href="join.jsp">회원 가입</a></li>
      </ul>
 
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
       </nav>
</header>
  
  <script type="text/javascript">
  function check(){
	  
  if (document.joinform.password.value!=document.joinform.confirmpassword.value)//비밀번호와 비밀번호 확인 폼에 입력된 값이 다르다면
	  {
         history.go(0);
		  alert("비밀번호가 서로 다릅니다.");
		  return false;
	  }
  else if(document.joinform.Duplication.value =="iduncheck")
	  {
	  history.go(0);
	  alert("아이디 중복 검사를 하세요");
	  return false;
	  }
  
  else
	  {
	  
	  alert("회원가입에 성공하셨습니다. 환영합니다");
          return true;
          
	  }
  }
  
  
  function openidcheck(){
	 if(!document.joinform.id.value)
		 {
		 alert("중복검사할 아이디가 입력되지 않았습니다.");
		 }
  // 중복 확인 버튼을 눌렀을 때 실행되는 함수
  else{
	  window.name = "parentForm"; //부모 창 이름 지정
	  window.open("idcheckForm.jsp?id="+document.joinform.id.value,"DuplicationcheckForm","width=500, height=300, resizable=no, scrollbars=no");//새 창을 여는 함수, 속성: 생성된 새 창의 url, 생성된 창의 이름, 창 옵션 설정,
       }
  }
  
  function inputidcheck()
  {
	  //아이디 입력 칸에 값을 입력하려고 할 때 실행되는 함수
	  document.joinform.Duplication.value="iduncheck";
	  //중복 확인 한 후에 새로운 아이디를 입력할 때는 중복 검사를 하지 않은 것으로 세팅한다.
	  //중복 검사 x->Sign up 버튼 눌리지 않음
  }
  

  
  </script>
  
  
  
  <main >
  <div class="container">
      <form action="join" method="post" name="joinform" onSubmit="return check()">
        <h1 >Create Account</h1>
        
        <label>이름을 입력하세요 </label><br>
        <input type="text" name="name" class="form-control" placeholder="Name" required autofocus > <br>
        
        <label>사용하실 닉네임을 입력하세요 </label><br>
        <input type="text" name="nickname" class="form-control" placeholder="Nickname" required autofocus > <br>
        
        <label>사용하실 아이디를 입력하세요 </label><br>
        <input type="text" name="id" class="form-control" placeholder="ID" required autofocus  onkeydown="inputidcheck()" >  <br>
        
         <button type="button"  value="중복확인"  onclick="openidcheck()" >중복확인</button>
         <input type="hidden" name="Duplication" value="iduncheck" >
         <br> <br>
         
         <label>사용하실 비밀번호 입력하세요 </label><br>
         <input type="password" name="password" class="form-control" placeholder="Password" required autofocus><br>
         
         <label>비밀번호를 한번 더 입력하세요 </label><br>
           <input type="password" name="confirmpassword" class="form-control" placeholder="ConfirmPassword" required autofocus><br>
         
        <label>이메일을 입력하세요 </label>
       <input type="email" name="email" class="form-control" placeholder="Email address" required autofocus><br>
       
       <label>전화번호를 입력하세요( 입력 형식>010-####-####  )</label>
       <input type="tel" name="tel" class="form-control" placeholder="Phone Number" required autofocus><br>
       
       <button class="btn btn-lg btn-primary btn-block" type="submit"  name="button1"  onload="/login.jsp" >Sign up</button>

      </form>
    </div> <!-- /container -->
  
  </main>
  
      <footer class="footer-bs">
        <div class="row">
        	<div class="col-md-3 footer-brand animated fadeInLeft">
            	<h2>Pages for users</h2>
                <p> this web page is made of an mvc structure and uses html,css,bootstrap,sql,jsp. this web page provides functions such as enrollment, pre-population
                , and bulletin boards for communication between users.</p>
            </div>
        	<div class="col-md-4 footer-nav animated fadeInUp">
            	<h4>Administrator information-</h4>
            	<div class="col-md-6">
                    <ul class="pages">
                        <li><a href="#">Phone number</a></li>
                        <li><a href="#">E-mail</a></li>
                        <li><a href="#">University</a></li>
                        <li><a href="#">Name</a></li>
                        <li><a href="#">Major</a></li>
                    </ul>
                </div>
            	<div class="col-md-6">
                    <ul class="list">
                        <li><a href="#">010-9600-1319</a></li>
                        <li><a href="#">ieieie0419@gmail.com</a></li>
                         <li><a href="#">ieieie0419@gmail.com</a></li>
                        <li><a href="#">Kim Yu-bi</a></li>
                        <li><a href="#">Department of Convergence Software</a></li>
                    </ul>
                </div>
            </div>
        	<div class="col-md-2 footer-social animated fadeInDown">
            	<h4>Follow Us</h4>
            	<ul>
                	<li><a href=" https://www.facebook.com/rladbql1319">Facebook</a></li>
                	<li></li>
                	<li><a href="https://www.instagram.com/yubig/?hl=ko">Instagram</a></li>
                	<li></li>
                </ul>
            </div>
        	<div class="col-md-3 footer-ns animated fadeInRight">
            	<h4>production period</h4>
            	<br>
                <p>2020.05.16~2020.05.14</p>
                 <p>for about a month</p>    
            </div>
        </div>
    </footer>
  
</body>
</html> 