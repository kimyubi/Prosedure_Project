<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
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
	
	body{margin-top: 130px}
	
</style>
<!------------------------------------------------------------------------------ css ----------------------------------------------------------------->
	<title>로그인 페이지</title>
	</head>
	
	<body >
	
	<header>
	<nav class="navbar navbar-default  navbar-fixed-top">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <p class="navbar-text"><a href="index.jsp">Myongji University</a></p>
	    </div>
	
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	         <li><a href="/enrollment">수강 신청</a></li>
			<li><a href="/mypage">신청 내역</a></li>
			<li><a href="/deleteLecture">수강 정정</a></li>
			<li><a href="/notice">공지사항</a></li>
			<li><a href="/book.jsp">도서검색</a></li>
			<li><a href="/LectureEvaluation">강의 평가</a></li>
	      </ul>
	  
	      <ul class="nav navbar-nav navbar-right">
	         <li><a href="/miridamgi">미리담기</a></li>
           <li><a href="/mybag">책가방</a></li>
			<li><a href="/myinfo">내 정보</a></li>
			   <li><a href="login.jsp" >로그인</a></li>
	         <li><a href="join.jsp">회원 가입</a></li>
	      </ul>
	 
	      
	    </div>
	  </div>
	       </nav>
	</header>
	  
	  <main>
	  <div class="container">
	      <form name="loginform" action="/login" method = "post">
	        <h1 >Please sign in</h1><br>
	        <input type="text" name="loginid" class="form-control" placeholder="ID" required autofocus><br>
	        <input type="password" name="loginpassword" class="form-control" placeholder="Password" required autofocus>   <br>
	         <button class="btn btn-lg btn-primary btn-block" type="submit" >Sign in</button>
	      </form>
	    </div> 
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
	                      <li>010-9600-1319</li>
	                        <li>ieieie0419@gmail.com</li>
	                        <li>Myongji University</li>
	                        <li>Kim Yu-bi</li>
	                        <li>Department of Convergence Software</li>
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