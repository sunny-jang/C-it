<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
    <section>
        <!-- 제목 -->
        <div id="section_title" class="clearfix"><h1 id="section-title-text" class="float--left">MyPage</h1>
        <a href="" class="member-update-delete float--right">회원정보 수정 / 탈퇴
        <i class="fas fa-chevron-circle-right"></i></a></div>
        <!-- 컨텐츠내용 -->
        <div id="section-contents-wrap">
            <div id="section_contents">
                
                   <div class="board-wrap">
                        <div class="board-title">
                            <p class="mypage-title float--left">내가 쓴 글</p>
                        </div>
                        <div class="board-contents">
                           <div class="myboard">
                            <table class="table-list">
                                <thead>
                                <tr>
                                    <th class="board-category"></th>
                                    <th class="subject">제목</th>
                                    <th class="time">작성일</th>
                                    <th class="writer">글쓴이</th>
                                    <th class="view-count">조회수</th>
                                </tr>
                                </thead>
							<c:choose>
							<c:when test="${empty myList}">
								<tr>
									<td colspan="4">등록된 게시물이 없습니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="n" items="${myList}" begin="0" end="2">
									<tr>
										<td><c:if test="${today-wd le 5}">
										<div class="new-icon"><jsp:useBean id="now" class="java.util.Date" />
												<fmt:formatDate value="${now}" pattern="yyyyMMdd" var="today" />
												<fmt:parseNumber value="${today}" integerOnly="true" var="today" />
												<fmt:formatDate value="${n.date}" pattern="yyyyMMdd" var="write_dt" />
												<fmt:parseNumber value="${write_dt}" integerOnly="true" var="wd" />
													<c:out value="new" />	
											</div></c:if></td>
										<td><a href="Mypage.do?id=${n.id }">${n.title}</a></td>
										<td>${n.date }</td>
										<td>${n.id }</td>
										<td>${n.views }</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
                            </table>
                           </div> 
                        </div>
                   </div>

                <div class="bottom">
                <ul class="pagination justify-content-center">
                <span class="p-btn" onclick="alert('이전 페이지가 없습니다.');">◁</span>
                <li><a class="page-item" href="">1</a></li>
                <li><a class="page-item" href="">2</a></li>
                <li><a class="page-item" href="">3</a></li>
                <li><a class="page-item" href="">4</a></li>
                <li><a class="page-item" href="">5</a></li>       
                <span class="p-btn" onclick="alert('다음 페이지가 없습니다.');">▷</span>
                </ul>
                </div>
            </div>   
        </div>     
    </section>
<%@ include file="/include/footer.jsp" %>     