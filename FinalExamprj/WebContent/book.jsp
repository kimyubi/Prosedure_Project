<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<!-- 제이쿼리: 자바스크립트 기반의 프레임워크, 웹 개발 속도 향상에 도움을 줌 
      제이쿼리를 사용하기 위한 방법 1: 제이쿼리 홈페이지에서 jquery.js 파일 다운로드 방법 2: jquery CDN 서버로 연결되는 외부링크 사용 (HTML 코드에 jQuery 
      스크립트를 불러오는 태그 사용 -->
      <!-- ( https://api.jquery.com/jquery.ajax/ ) 제이쿼리에서 ajax 사용  -->
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
	
	body{margin-top: 140px}
	h3{margin-left: 450px; font-family: sans-serif; color: black; font-weight: bold; }
	#bookName{
	margin-left: 400px;  margin-top: 35px;
	padding-right: 200px; padding-left: 5px; padding-top: 7px; padding-bottom: 7px; margin-right: 5px; margin-bottom: 50px;
	}
	#search{
	padding-left: 30px; padding-right: 30px; padding-top: 7px; padding-bottom: 7px;  margin-bottom: 50px;}
	p{margin-left: 450px;}

	
</style>
<!------------------------------------------------------------------------------ css ----------------------------------------------------------------->
	<title>도서검색 페이지</title>
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
			<li><a href="#">커뮤니티</a></li>
	      </ul>
	  
	      <ul class="nav navbar-nav navbar-right">
	 		<li><a href="#">책가방</a></li>
			<li><a href="/myinfo">내 정보</a></li>
			<li><a href="/logout.jsp">로그 아웃</a></li>
	      </ul>
	 
	      
	    </div>
	  </div>
	       </nav>
	</header>
	  
	  <main>
	  <h3> 검색하실 책의 제목을 입력하세요. </h3>
	
	<script type="text/javascript">

	function check() {
		$("#booksearch").remove();
	}
	
	</script>
	     
	    <input type="text"  id="bookName"  placeholder="책 제목을 입력하세요" required > 
       <button id="search" onclick="check()" > 검색 </button>
      
		<p id ="booksearch"></p>
		<p id="booksearch"></p>
		<p id="booksearch"></p>
		<p id="booksearch"></p>
		<p id="booksearch"></p>
		<p id="booksearch"></p>
		<p id="booksearch"></p>
	    <p id="booksearch"></p>
	    

		<!-- jquery cdn -->
<script  src="https://code.jquery.com/jquery-3.5.1.js"  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
 <!--  jquery ajax -->
 
 
 <script>
        $(function () {

            $("#search").click(function () {

                $.ajax({
                    method: "GET",
                    url: "https://dapi.kakao.com/v3/search/book?target=title", // 전송 주소
                    data: { query: $("#bookName").val() , sort: "accuracy"}, // 보낼 데이터 x: "y", z: "q" 형식, 사용자로부터 입력받은 책의 제목을 담아보낸다.
                    headers: { Authorization: "KakaoAK 9200b193567e974f0955039d14cc1645" } //카카오에서 부여받은 앱키(REST API)
                })
                    .done(function (msg) { // 요청에 대한 응답이 오면 처리를 하는 코드
                      //  alert("데이터가 저장되었습니다"+ msg); //요청이 성공적으로 실행되어 done을 실행하면 '데이터가 저장되었습니다'라는 알림창과 함께 Object가 넘어왔음을 알 수 있다.
                        console.log(msg); //개발자 도구상에 응답으로 받은 객체를 보여주기 위한 것
                        for(var i =0; i < msg.documents.length;i++){
                     
                    	$( "#booksearch" ).append("<strong>"+msg.documents[i].title+"</strong><br>");
                    	$( "#booksearch" ).append( "<img src = '"+msg.documents[i].thumbnail+"'/><br><br>" );
                    	$( "#booksearch" ).append("저자: "+ msg.documents[i].authors+"<br>");
                    	$( "#booksearch" ).append("출판사: "+ msg.documents[i].publisher+"<br>");
                    	$( "#booksearch" ).append("판매상태: "+ msg.documents[i].status+"<br>");
                    	$( "#booksearch" ).append( "정가: "+msg.documents[i].price +"원 <br>");
                    	$( "#booksearch" ).append( "판매가: "+msg.documents[i].sale_price +"원 <br>");
                    	$( "#booksearch" ).append( "ISBN: "+msg.documents[i].isbn+"<br><br><br>");
                 
                    
                        }
                    });
            })
        });

    </script>
 
 </main>
	 
	</body>
	</html>