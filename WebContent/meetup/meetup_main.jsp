<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/header.jsp"%>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<section>
	<!-- 제목 -->
	<div id="section_title">
		<h1 id="section-title-text">MeetUp</h1>
	</div>
	<div id="section_title">
		<div class="meetup-line"></div>
		<ul class="month">
			<li><a href="#">Jan</a></li>
			<li><a href="#">Feb</a></li>
			<li><a href="#">Mar</a></li>
			<li><a href="#">Apr</a></li>
			<li><a href="#">May</a></li>
			<li><a href="#">Jun</a></li>
			<li><a href="#">Jul</a></li>
			<li><a href="#">Aug</a></li>
			<li><a href="#">Sep</a></li>
			<li><a href="#">Oct</a></li>
			<li><a href="#">Nov</a></li>
			<li><a href="#">Dec</a></li>
		</ul>
	</div>
	<!-- 컨텐츠내용 -->
	<div id="section-contents-wrap">
		<div id="section_contents">
			<div class="category">
				<div class="all">All</div>
				<div class="recruit">
					<span class="material-icons">person_add</span>Job Fair
				</div>
				<div class="company">
					<span class="material-icons">school</span>Education
				</div>
				<div class="interview">
					<span class="material-icons">group_add</span> MeetUp
				</div>
			</div>
			<div class="news_set">
				<div class="null_msg">현재 진행중인 밋업이 없습니다.</div>
			</div>
			<div class="more-btn">
				<input class="more-btn-input" type="submit" value="+더보기"></input>
			</div>
		</div>
	</div>
</section>

<%@ include file="/include/footer.jsp"%>