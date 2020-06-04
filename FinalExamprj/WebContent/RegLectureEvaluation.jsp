<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
.form-control { width:30%;}
label{margin-left:10px;}
input{margin-left:10px;}
textarea{margin-left:10px;}
</style>

<title>강의평가 등록페이지</title>
</head>
<body>

<form action="/RegLectureEvaluation" method="post">
        <div style="margin-top:30px;  margin-left:20px;">
           <label > 강의명</label>
            <input type="text" class="form-control" name="name" placeholder="강의명을 입력하세요." required style="display:inline-block; margin-right:20px;" >
             <label> 교수명</label>
            <input type="text" class="form-control" name="professor" placeholder="교수명을 입력하세요." required style="display:inline-block;">
           </div>
           
           <div style="margin-top:20px; margin-left:15px;">
           <label>수강연도</label>
           <select name="studyYear" style="display:inline-block; margin-right:20px;" class="form-control">
           <option value="2020">2020</option>
           <option value ="2019">2019</option>
           <option value ="2018" >2018</option>
            <option value="2017">2017</option>
           </select>
           
                 <label>수강학기</label>
           <select name="studySemester" style="display:inline-block;" style="display:inline-block;" class="form-control">
           <option value="1학기">1학기</option>
           <option value ="하계계절">하계계절</option>
           <option value ="2학기" >2학기</option>
            <option value="동계계절">동계계절</option>
           </select>
           </div>
           
           <div style="margin-top:20px; margin-left:20px;" >
            <label >제목</label><br>
            <input type="text" class="form-control" name="title" placeholder="제목을 입력하세요." required style="width:88%; height:auto" >
           </div>
           
             <div style="margin-top:20px; margin-left:20px;">
            <label >내용</label><br>
            <textarea rows="8" class="form-control name" name="content" style="width:88%"></textarea>
           </div>
           
           <div style="margin-top:20px; margin-left:20px;">   
             <label>과제</label>
             <label style="margin-left:70px;">조모임</label>
             <label style="margin-left:55px;">학점 비율</label>
             <label style="margin-left:55px;">시험 횟수</label>
             <label style="margin-left:58px;">총평</label><br>
           <select name="task" style="display:inline-block; margin-left:8px; width:15%;"class="form-control"  >
           <option value="많음">많음</option>
           <option value ="보통">보통</option>
            <option value ="적음">적음</option>
           <option value ="없음" >없음</option>
           </select>
           
 
           <select name="teample" style="display:inline-block; margin-left:10px; width:15%;"class="form-control"  >
           <option value="많음">많음</option>
           <option value ="보통">보통</option>
            <option value ="적음">적음</option>
           <option value ="없음" >없음</option>
           </select>
           
             <select name="gradescale" style="display:inline-block; margin-left:10px; width:18%;"class="form-control"  >
           <option value="학점느님">학점느님</option>
           <option value ="비율채워줌">비율채워줌</option>
            <option value ="매우깐깐함">매우깐깐함</option>
           <option value ="F폭격기" >F폭격기</option>
           </select>
           
              <select name="exam" style="display:inline-block; margin-left:10px; width:18%;"class="form-control"  >
           <option value="네번이상">네번이상</option>
           <option value ="세번">세번</option>
            <option value ="두번">두번</option>
           <option value ="한번" >한번</option>
              <option value ="없음" >없음</option>
           </select>
           
                  
              <select name="totalScore" style="display:inline-block; margin-left:10px; width:13%;"class="form-control"  >
           <option value="1점">1점</option>
           <option value ="2점">2점</option>
            <option value ="3점">3점</option>
           <option value ="4점" >4점</option>
              <option value ="5점" >5점</option>
           </select>
              </div> 
    
    <script type="text/javascript">function prev() {window.close();}</script>          
	 
	     <div style=" margin-left:160px; margin-top:30px;">
          <input class="btn btn-search"	type="button"  onclick="prev()" value="취소" style="padding-right: 40px; padding-left: 40px;"/>
          <input class="btn btn-search"	type="submit"  name="button"  value="등록" style="padding-right: 40px; padding-left: 40px;" />
          </div>
           
            </form>
            
      
   
</body>
</html>