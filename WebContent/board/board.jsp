<%@ page import="com.cit.board.model.BoardDao"%>
<%@ page import="com.cit.board.model.BoardDto" %>
<%@ page import=" java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
    <section>
        <!-- 제목 -->
        <div id="section_title"><h1 id="section-title-text">Board</h1></div>
        <!-- 컨텐츠내용 -->
        <div id="section-contents-wrap">
            <div id="section_contents">
                <!-- 게시판 목록 -->
                <form class=board-wrap action="" method="">
				<table class="table-list">
					<thead>
						<tr>
							<th width="auto" class="subject">제목</th>
							<th width="20%" class="time">작성일</th>
							<th width="10%" class="writer">글쓴이</th>
							<th width="10%" class="view-count">조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="n" items="${list}" begin="0" end="3">
							<tr>
								<td><a href="#">${n.title}</a></td>
								<td>${n.date }</td>
								<td>${n.id }</td>
								<td>${n.views }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<div class="bottom">
                    <ul class="pagination justify-content-center">
                    <li class="page-item disabled"><a class="page-link" href="#">◁</a></li>
                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">4</a></li>
                    <li class="page-item"><a class="page-link" href="#">5</a></li>
                    <li class="page-item"><a class="page-link" href="#">▷</a></li>
                    </ul>
                    <!-- 작성하기 버튼 -->
                    <p class="btn-write">
                    <a href="">작성하기</a>
                    </p>
                  </div>
          </form> 
          </div>   
        </div>     
    </section>
<%@ include file="/include/footer.jsp" %>  