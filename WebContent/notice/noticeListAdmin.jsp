<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.cit.notice.model.NoticeDao" %>
<%@page import="java.util.List"%>
<%@page import="java.util.Date" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/include/header.jsp" %>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.2/css/all.css" integrity="sha384-vSIIfh2YWi9wW0r9iZe7RJPrKwp6bG+s9QZMoITbCckVJqGCCRhc+ccxNcdpHuYu" crossorigin="anonymous">
<script src="${pageContext.request.contextPath}/js/style.js"></script>

<script>
function moreList(num) {
   location.href ="NoticeListAdmin.do?pageEnd="+num;
}
</script>    
<section>
        <!-- 제목 -->
        <div id="section_title"><h1 id="section-title-text">Notice</h1></div>
        <!-- 컨텐츠내용 -->
        <div id="section-contents-wrap">
            <div id="section_contents">
                <!-- 게시판 목록 -->
                  <div class="accordion_container">
                  <c:choose>
                    <c:when test="${empty list}"><div class="unwritten">등록된 게시물이 없습니다.</div></c:when>
                    <c:otherwise>
                    <c:forEach var="n" items="${list}" begin="0" end="${endNum}" >
                    <div class="accordion_head" width="auto">
                      <div class="new-icon float--left">
                        <jsp:useBean id="now" class="java.util.Date" />
                        <fmt:formatDate value="${now}" pattern="yyyyMMdd" var="today" />
                        <fmt:parseNumber value="${today}" integerOnly="true" var="today" />
                        <fmt:formatDate value="${n.date}" pattern="yyyyMMdd" var="write_dt"/>
                        <fmt:parseNumber value="${write_dt}" integerOnly="true" var="wd" />
                        <c:if test="${today-wd le 5}">
                           <c:out value = "new" />
                        </c:if>
                      </div>
                      <div class="title-wrap1">
                      <!-- 제목 -->
                      <p class="notice-title">${n.title}</p>
                      <div class="title-wrap2">
                      <!-- 카테고리 -->
                      <p class="notice-category">${n.cate}</p>
                      <!-- 날짜 -->
                      <p class="notice-date">${n.date}</p>
                      </div>
                      </div>
                      <i id="plus" class="fas fa-plus-square"></i> 
                    </div>
                    <div class="accordion_body" style="display: none;">
                    <!-- 내용 -->
                      <p>${n.cont}</p>
                    <c:if test="${isAdmin eq 1}"> 
			            <div class="clearfix">
				            <a class="btncustom delete-btn float--right" onclick="return confirm('삭제 하시겠습니까?')" href="NoticeDelAdmin.do?num=${n.num}">삭제하기</a>
				            <a class="btncustom update-btn float--right" href="">수정하기</a>
			            </div>
			        </c:if>
                    </div>
                    </c:forEach>
                  </c:otherwise>
                  </c:choose>
                   <div class="bottom">
                   <div class="more-btn"><input class="more-btn-input" type="submit" value="+더보기" onclick="moreList('${endNum+5}')" /></div>
                    <!-- 작성하기 버튼 -->
                    <p class="btn-write">
                    <a href="">작성하기</a>
                    </p>
                  </div>
         </div>
          </div>   
        </div>     
    </section>
<%@ include file="/include/footer.jsp" %>