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

function idCheck(){

    <%
   
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");

    String id= request.getParameter("id");

  JoinService service = new JoinService();
    boolean result = service.checkDuplication(id);
    if(result){%>
    alert("사용 중인 아이디 입니다. 다른 아이디를 입력해주세요.");
  
  

    <% } %>
    
    <% if(!result) {%>
   alert("입력하신 아이디는 사용할 수 있는 아이디입니다.");
	opener.document.joinform.Duplication.value="idcheck";
    <%}%>
	
    }

</script>


<body >

	<div id=child>
		<br> <b><font size="5" color="silver" >아이디 중복 체크</font></b>
		<hr size="1" width="460">
		<!-- 수평선 그리는 태그 -->
		<br>

		<div id=check>

			<form id=checkForm name="chkform" >
				<input type="text" name="checkid" value= ${param.id}  disabled />
				 <input	type="button" value="중복확인" onclick="idCheck()" />
			</form>
			
			
            
		</div>
		<!-- child -->
	</div>
	<!-- check -->
	
	
</body>

</html>