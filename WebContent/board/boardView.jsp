<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.cit.board.model.BoardDao"%>
<%@ page import="com.cit.board.model.BoardDto"%>
<%@ include file="/include/header.jsp"%>
<section>
	<!-- 제목 -->
	<div id="section_title">
		<h1 id="section-title-text">BOARD</h1>
	</div>
	<!-- 컨텐츠내용 -->
	<div id="section-contents-wrap">
		<div id="section_contents">
			<div class="board-view-info-box clearfix">
				<div class="board-view-info viewnum float--right">&nbsp;조회수 : ${BoardDetail.getViews()}</div>
				<div class="board-view-info num"></div>
				<div class="board-view-info wrt float--right">&nbsp;작성자 : ${BoardDetail.getId()}</div>
				<div class="board-view-info date float--right">작성일 : ${BoardDetail.getDate()}</div>
			</div>
			<div class="board-view-title-box clearfix">
				<div class="board-view-category float--left">${BoardDetail.getCate()}</div>
				<div>
					<h2 class="board-view-title float--left"></h2>
				</div>
			</div>
			<div class="board-view-text" style="white-space : pre; height:auto;">${BoardDetail.getCont()}
				<p></p>
			</div>

			<div class="board-btn-set1">

				<a class="listbutton" type="button" id="listbutton"  onclick="location.href='/Cit/BoardList.do'" >목록</a>
				<div class="board-btn-set2">
					<a class="updatebutton" type="button" id="resetbutton" href="/Cit/BoardUpdate.do?num=${BoardDetail.getNum()}">수정</a>
					<a class="deletebutton" type="button" id="deletebutton" onclick = "return confirm('삭제하시겠습니까?')" href="/Cit/BoardDel.do?num=${BoardDetail.getNum()}" >삭제</a>
				</div>
			</div>

		</div>
	</div>
</section>
<%@ include file="/include/footer.jsp"%>
