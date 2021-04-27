<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
    <section>
        <!-- 제목 -->
        <div id="section_title" class="clearfix"><h1 id="section-title-text" class="float--left">MyPage</h1>
        <a href="${pageContext.request.contextPath}/MemberUpdateController.do" class="member-update-delete float--right">회원정보 수정 / 탈퇴
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
								<c:forEach var="n" items="${myList}" begin="0" end="4">
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
                            </table>
                           </div> 
                        </div>
                   </div>
			<div class="bottom">
				<c:set var="page" value="${(empty param.p)?1:param.p}"></c:set>
				<c:set var="startNum" value="${page-(page-1)%3}"></c:set>
				<c:set var="lastNum" value="18"></c:set>

				<div class="page_wrap">
					<div class="pagination justify-content-center">
						<c:if test="${startNum> 1}">
							<a href="?p=${startNum-1}" class="btn btn-prev"></a>
						</c:if>
						<c:if test="${startNum <= 1}">
							<a class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');">◁</a>
						</c:if>

						<c:forEach var="i" begin="0" end="${maxPage}">
							<c:if test="${(startNum+i) <= lastNum }">
								<a class="text ${(page == (startNum+i))? 'blue' :''}  bold"
									href="?p=${startNum+i}">${startNum+i}</a>
							</c:if>
						</c:forEach>

						<c:if test="${startNum+2 < lastNum}">
							<a href="?p=${startNum+3}" class="btn btn-next"></a>
						</c:if>
						<c:if test="${startNum+2 >= lastNum}">
							<a class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">▷</a>
						</c:if>

					</div>
				</div>
			</div>
		</div>   
        </div>     
    </section>
<%@ include file="/include/footer.jsp" %>     