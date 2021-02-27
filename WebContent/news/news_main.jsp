<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/include/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	
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
	<div id="section_title">
		<h1 id="section-title-text">NEWS</h1>
	</div>
	<!-- 컨텐츠내용 -->
	<div id="section-contents-wrap">
		<div id="section_contents">
			<div class="category">
				<div class="all news_cate on">
					<a href="/Cit/NewsListController.do">전체</a>
				</div>
				<div class="recruit news_cate">
					<a href="/Cit/NewsListController.do?category=채용"><span
						class="material-icons">supervisor_account</span>채용</a>
				</div>
				<div class="company news_cate">
					<a href="/Cit/NewsListController.do?category=기업"><span
						class="material-icons">business</span>기업</a>
				</div>
				<div class="interview news_cate">
					<a href="/Cit/NewsListController.do?category=인터뷰"><span
						class="material-icons">chat_bubble</span>인터뷰</a>
				</div>
			</div>
			<div class="news_set">
				<c:forEach var="news" items="${list}" begin="${pageStart}"
					end="${endNum}">
					<div class="news_set_box">
						<div class="news_pic">
							<a href="/Cit/NewsViewController.do?num=${news.num}" href="#"
								style="background-image: url(${news.imagePathList[0]}); background-size: cover; background-position: center; background-repeat: no-repeat;"></a>
						</div>
						<div class="news_title">
							<a href="/Cit/NewsViewController.do?num=${news.num}">${news.title}</a>
						</div>
						<div class="news_memo">
							<a href="/Cit/NewsViewController.do?num=${news.num}"><p
									class="ellipsis-2">${news.cont}</p></a>
						</div>
						<div style="margin-top: 5px">
							<%-- <fmt:formatDate value="${news.enrollDate}" pattern="yyyy-MM-dd"/> --%>
						</div>
					</div>
				</c:forEach>
				<c:if test="${empty list}">
					<div class="null_msg">등록된 뉴스가 없습니다.</div>
				</c:if>
			</div>
			<c:if test="${fn:length(list) > 10}">
				<div class="more-btn">
					<input class="more-btn-input" type="button" value="+더보기"
						id="btnMoreNews"
						onclick="addMore(${endNum+9}, '${param.category}')">
				</div>
			</c:if>
			<c:if test="${isAdmin eq 1}">
				<a href="/Cit/NewsWriteController.do" class="btn-write">글쓰기</a>
			</c:if>

		</div>
	</div>
</section>
<%@ include file="/include/footer.jsp"%>