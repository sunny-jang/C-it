<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
    <section>
        <!-- 제목 -->
        <div id="section_title"><h1 id="section-title-text">What'S Up</h1></div>
        <!-- 컨텐츠내용 -->
        <div id="section-contents-wrap">
            <div id="section_contents">                
                <div class="main_news_set">
                    <c:forEach var="news" items="${nList}" begin="${pageStart}"
					end="3">
					<div class="main_news_set_box">
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
            	<div id="section_title" class="main-section-title">
					<h1 id="section-title-text">Board</h1>
				</div>
            	<div class="board-wrap">
                    <table class="table-list">
					<thead>
						<tr>
							<th width="10%" class="board-category"></th>
							<th width="auto" class="subject">제목</th>
							<th width="20%" class="time">작성일</th>
							<th width="10%" class="writer">글쓴이</th>
							<th width="10%" class="view-count">조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${empty bList}">
								<tr>
									<td colspan="4">등록된 게시물이 없습니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="n" items="${bList}" begin="0" end="2">
									<tr>
										<td><c:if test="${today-wd le 5}">
										<div class="new-icon"><jsp:useBean id="now" class="java.util.Date" />
												<fmt:formatDate value="${now}" pattern="yyyyMMdd" var="today" />
												<fmt:parseNumber value="${today}" integerOnly="true" var="today" />
												<fmt:formatDate value="${n.date}" pattern="yyyyMMdd" var="write_dt" />
												<fmt:parseNumber value="${write_dt}" integerOnly="true" var="wd" />
													<c:out value="new" />	
											</div></c:if></td>
										<td><a href="BoardDetail.do?num=${n.num }">${n.title}</a></td>
										<td>${n.date }</td>
										<td>${n.id }</td>
										<td>${n.views }</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table> 
				</div>             
            </div>  
        </div>     
    </section>
<%@ include file="/include/footer.jsp" %>     