<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/log.css">
    <section>
        <!-- 제목 -->
        <div id="section_title"><h1 id="section-title-text">Find Id</h1></div>
        <!-- 컨텐츠내용 -->
        <div id="section-contents-wrap">
            <div id="section_contents">
                <div id="box-name">아이디찾기</div>
                <div class="show-id">
                    <div id="nofoundid"><%=request.getAttribute("msg")%></div>
                </div> 
                <div class="btn-set">                    
                    <input type="button" class="join-btn" name="join-btn" value="Sign In" onClick="location.href='${pageContext.request.contextPath}/member/join.jsp'">
                </div> 
            </div>   
        </div>     
    </section>
<%@ include file="/include/footer.jsp" %>