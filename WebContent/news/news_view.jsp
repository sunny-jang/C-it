<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<script>

function delNews(number) {
		location.href = "/Cit/NewsDelController.do?num="+number;
	}
	
function updateNews(number) {
	location.href = "/Cit/NewsUpdateController.do?num="+number;
}
</script>
    <section>
        <!-- 제목 -->
        <div id="section_title"><h1 id="section-title-text">NEWS</h1></div>
        <!-- 컨텐츠내용 -->
        <div id="section-contents-wrap">
            <div id="section_contents">
                <div><h2 class="news-view-title">${news.title}</h2></div>                
                <div class="news-view-info-box">
                    <div class="news-view-info wrt">${news.author}</div>
                    <div class="news-view-info date">2020-12-22  </div>
                    <div class="news-view-info viewnum">조회수</div> 
                    <div class="news-view-info num">${news.views}</div>                   
                </div>
                <div class="news-view-text"><p>${news.getCont()}</p></div>
                <div>
                	<span>원글 보기 :  <a href="${news.newsLink}">${news.newsLink}</a></span>
                </div>
            </div>   
            <div class="tolist-btn"><input class="tolist-btn-input" type="button" value="목록으로" onclick="location.href='/Cit/NewsListController.do'"></input></div>
            
            <c:if test="${isAdmin eq 1}">
            	<div class="tolist-btn"><input class="btn-del btn-input" type="button" value="삭제" onclick="delNews(${news.num})"></input></div>
            </c:if>
            <c:if test="${id eq news.id}">
            	<div class="tolist-btn"><input class="btn-del btn-input" type="button" value="수정" onclick="updateNews(${news.num})"></input></div>
            </c:if>
           
        </div> 
    </section>
<%@ include file="/include/footer.jsp" %>