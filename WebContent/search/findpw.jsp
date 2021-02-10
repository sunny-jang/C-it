<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/log.css">
    <section>
        <!-- 제목 -->
        <div id="section_title"><h1>Find Password</h1></div>
        <!-- 컨텐츠내용 -->
        <div id="section-contents-wrap">
            <div id="section_contents">
	            <form action="<%=request.getContextPath()%>/searchPw" method="post">
	            <div id="box-name">비밀번호 찾기</div>
		        	<div id="box">
			            <div class="box-div" id="box-div-text">비밀번호는 가입시 입력하신 아이디,이메일을 통해 찾을 수 있습니다.</div>
			            <div class="box-div input"><input type="text" name="name" placeholder="이름" ><br></div>
			            <div class="box-div input"><input type="text" name="id" placeholder="아이디" ><br></div>
			            <div class="box-div input"><input type="email" name="email" placeholder="이메일"><br></div>
			            <div class="box-div input"><input type="submit" value="찾기"></input></div>
		         	</div>
	             </form>
            </div> 
         </div>    
    </section>
<%@ include file="/include/footer.jsp" %>