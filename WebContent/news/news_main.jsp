<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ include file="/include/header.jsp" %>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <section>
        <!-- 제목 -->
        <div id="section_title"><h1 id="section-title-text">NEWS</h1></div>
        <!-- 컨텐츠내용 -->
        <div id="section-contents-wrap">
            <div id="section_contents">
                <div class="category">
                    <div class="all">전체</div>
                    <div class="recruit"><span class="material-icons">supervisor_account</span>채용</div>
                    <div class="company"><span class="material-icons">business</span>기업</div>
                    <div class="interview"><span class="material-icons">chat_bubble</span>인터뷰</div>
                </div>
                <div class="news_set">
                <%--<c:forEach var="list" items="${list}">--%>
                    <div class="news_set_box">
                        <div class="news_pic"><a src="" href="#"></a></div>
                        <div class="news_title"><a href="#"></a><%=request.getAttribute("title")%></div>
                        <div class="news_memo"><a href="#"><p></p></a></div>
                    </div>    
                    <div class="news_set_box">
                        <div class="news_pic"><a src="" href="#"></a></div>
                        <div class="news_title"><a href="#"></a></div>
                        <div class="news_memo"><a href="#"><p></p></a></div>
                    </div> 
                    <div class="news_set_box">
                        <div class="news_pic"><a src="" href="#"></a></div>
                        <div class="news_title"><a href="#"></a></div>
                        <div class="news_memo"><a href="#"><p></p></a></div>
                    </div>
                   <%--</c:forEach>--%>
                </div> 
                <div class="more-btn"><input class="more-btn-input" type="submit" value="+더보기" ></input></div>
            </div>  
        </div>     
    </section>
<%@ include file="/include/footer.jsp" %>