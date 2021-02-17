<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
    <section>
        <!-- 제목 -->
        <div id="section_title"><h1 id="section-title-text">What'S Up</h1></div>
        <!-- 컨텐츠내용 -->
        <div id="section-contents-wrap">
            <div id="section_contents">                
                <div class="news_set">
                    <c:forEach var="news" items="${nList}" begin="${pageStart}"
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
                </div> 
                <div class="more-btn"><input class="more-btn-input" type="submit" value="+더보기" ></input></div>              
            </div>  
        </div>     
    </section>
<%@ include file="/include/footer.jsp" %>     