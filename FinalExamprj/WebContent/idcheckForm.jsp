<%@page import="web.index.Service.JoinService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">

#checkForm
{
padding-left: 130px;
}
#button
{
margin-top: 10px;
padding-left: 170px;
}

font
{
  text-align: justify;
  padding-left: 140px;
}
#check
{
margin-top: 30px;
}

</style>
<title>아이디 중복 검사</title>
</head>


<script type="text/javascript">


// button의 타입을 submit으로 하고 id의 파라미터값을 컨트롤러를 보내 중복확인을 컨트롤러에서 처리할 수도 있겠지만 
// 중복 확인 구현은  idcheckForm.jsp 한 페이지에서 끝내고 싶어서 뷰와 컨트롤러를 분리하지 않았습니다.

function idCheck(){

    <%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");

    String id= request.getParameter("id"); //id는 부모창에서 넘어 온 중복검사할 아이디

  JoinService service = new JoinService();
    boolean result = service.checkDuplication(id);
    //result == true -> 중복 -> 사용불가
    //result == false-> 중복x ->사용가능
    
    if(result){%>
    alert("사용 중인 아이디 입니다. 다른 아이디를 입력해주세요."); //부모창의 Duplication의 값이 "iduncheck"인 상태 -> 회원가입 불가능
    <% } %>
    
    <% if(!result) {%>
   alert("입력하신 아이디는 사용할 수 있는 아이디입니다.");
	opener.document.joinform.Duplication.value="idcheck";
    <% } %>
	
    }

</script>


<body >

	<div id=child>
		<br> <b><font size="5" color="silver" >아이디 중복 체크</font></b>
		<hr size="1" width="460">
		<!-- 수평선 그리는 태그 -->
		<br>

		<div id=check>

			<form id=checkForm  name="chkform" >
				<input type="text" name="checkid" value= ${ param.id }  disabled /> <!-- 부모창으로부터 get방식으로 중복 검사할 아이디가 넘어옴 -->
				 <input	type="button" value="중복확인" onclick="idCheck()" />
			</form>
			
			
            
		</div>
		<!-- child -->
	</div>
	<!-- check -->
	
	
</body>

</html>