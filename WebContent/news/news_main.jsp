<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/include/header.jsp" %>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script>
function addMore(num, category) {
		if(category != "") {
			location.href="/Cit/NewsListController.do?pageEnd="+num +"&category="+category;
		}else {
			location.href ="/Cit/NewsListController.do?pageEnd="+num;
		}
	}
	
function setCategory() {
	console.log(getParam("category"));
}
</script>
<section>
        <!-- 제목 -->
        <div id="section_title"><h1 id="section-title-text">NEWS</h1></div>
        <!-- 컨텐츠내용 -->
        <div id="section-contents-wrap">
            <div id="section_contents">
                <div class="category">
                    <div class="all news_cate on"><a href="/Cit/NewsListController.do">전체</a></div>
                    <div class="recruit news_cate"><a href="/Cit/NewsListController.do?category=채용"><span class="material-icons">supervisor_account</span>채용</a></div>
                    <div class="company news_cate"><a href="/Cit/NewsListController.do?category=기업"><span class="material-icons">business</span>기업</a></div>
                    <div class="interview news_cate"><a href="/Cit/NewsListController.do?category=인터뷰"><span class="material-icons">chat_bubble</span>인터뷰</a></div>
                </div>
                <div class="news_set">
                <c:forEach var="news" items="${list}" begin="${pageStart}" end="${endNum}">
                <div class="news_set_box">
                	<c:forEach var="image" items="${news.imagePathList}" begin="0" end="0">
                	<div class="news_pic" style="background-image: url(${image}); background-size: cover; background-position: center; background-repeat: no-repeat;"><a src="" href="#"></a></div>
                	</c:forEach>
                        <div class="news_title"><a href="#">${news.title}</a></div>
                        <div class="news_memo"><a href="#"><p class="ellipsis-2">${news.cont}</p></a></div>
                        <div style="margin-top:5px">
                        	<%-- <fmt:formatDate value="${news.enrollDate}" pattern="yyyy-MM-dd"/> --%>
                        </div>
                    </div>   
                </c:forEach>
                </div> 
                <div class="more-btn"><input class="more-btn-input" type="button" value="+더보기" id="btnMoreNews" onclick="addMore(${endNum+3}, '${param.category}')"></div>              
            	<c:if test="${isAdmin eq 1}">
            		<a href="/Cit/NewsWriteController.do" style="font-size:20px">글쓰기</a>
            	</c:if>
            	
            </div>  
        </div>     
    </section>
