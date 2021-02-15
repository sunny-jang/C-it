<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/layout.css">
    <link rel="stylesheet" href="../css/pages.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.2/css/all.css" integrity="sha384-vSIIfh2YWi9wW0r9iZe7RJPrKwp6bG+s9QZMoITbCckVJqGCCRhc+ccxNcdpHuYu" crossorigin="anonymous">
    <script type="text/javascript" src="../../js/jquery.js"></script>
    <script type="text/javascript" src="../js/style2.js"></script>
    <title>Board</title>
</head>

<body>     
    <header>       
        <div class="header-wrap">   
             <!-- LOGO -->            
            <h1 class="logo"><a href="#">C-it</a></h1>   
            <!-- 헤더왼쪽-flex -->            
            <ul id="header_01">            
                <li><a href="#" class="header_01_a">Notice</a></li>
                <li><a href="#" class="header_01_a">News</a></li>
                <li><a href="#" class="header_01_a">Board</a></li>
                <li><a href="#" class="header_01_a">MeetUp</a></li> 
            </ul> 
            <!-- 헤더오른쪽-flex -->
            <ul id="header_02">
                <li><a href="" class="header_02_a">Sign in</a></li>
                <li><a href="" class="header_02_a">Join us</a></li>
            </ul>
        </div>
    </header>    
    <section>
        <!-- 제목 -->
        <div id="section_title"><h1 id="section-title-text">Notice</h1></div>
        <!-- 컨텐츠내용 -->
        <div id="section-contents-wrap">
            <div id="section_contents">
                <!-- 게시판 목록 -->
                <c:forEach var="n" items="${list}">
                  <div class="accordion_container">
                    <div class="accordion_head" width="auto">${n.title}
                    <div class="new-icon float--left"><p>new</p></div>
                      <i id="plus" class="fas fa-plus-square"></i>
                    </div>
                    <div class="accordion_body" style="display: none;">
                      <p>${n.cont}</p>
                      <div class="notice-btn-set clearfix">
                      <a class="btn delete-btn float--right" href="">삭제하기</a>
                      <a class="btn update-btn float--right"href="">수정하기</a>
                      </div>
                    </div>
                  </div>
                 </c:forEach>
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
          </div>   
        </div>     
    </section>
<%@ include file="/include/footer.jsp" %>