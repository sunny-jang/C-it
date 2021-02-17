<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<%@ page import="com.cit.member.model.MemberDto" %>
<%
	MemberDto mdto = (MemberDto)request.getAttribute("mdto");
%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/findId.css">
    <section>
        <!-- 제목 -->
        <div id="section_title"><h1 id="section-title-text">Find Password</h1></div>
        <!-- 컨텐츠내용 -->
        <div id="section-contents-wrap">
            <div id="section_contents">
                <div id="box-name">비밀번호 찾기</div>
                <div class="show-id">          
                    <div>귀하의 비밀번호는 </div>
                    <div id="foundid"><%=mdto.getPw()%></div>
                    <div>입니다.</div>
                </div> 
                <div class="btn-set">
                    <input type="button" class="sign-btn" name="sign-btn" value="Sign In" onClick="location.href='${pageContext.request.contextPath}/login/login.jsp'">
                </div> 
            </div>   
        </div>     
    </section>
<%@ include file="/include/footer.jsp" %>