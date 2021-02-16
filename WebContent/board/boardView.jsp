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
			<div class="board-view-category">${BoardDetail.getCate()}</div>
			<div>
				<h2 class="board-view-title"></h2>
			</div>
			<div class="board-view-info-box">
				<div class="board-view-info wrt">
					작성자 : ${BoardDetail.getId()}</div>	
				<div class="board-view-info date">
					작성일 : ${BoardDetail.getDate()}</div>
				<div class="board-view-info viewnum">
					조회수 : ${BoardDetail.getViews()}</div>
				<div class="board-view-info num"></div>
			</div>
			<div class="board-view-text">${BoardDetail.getCont()}
				<p></p>
			</div>

			<div class="write-btn-set">
				<div class="reset-btn">
					<input class="resetbutton" type="button" id="resetbutton" value="수정" />
				</div>
				<div class="save-btn">
					<input class="savebutton" type="button" id="savebutton" value="목록" onclick="location.href='/Cit/BoardList.do'"/>
				</div>
			</div>
		</div>
	</div>
</section>
<%@ include file="/include/footer.jsp"%>
