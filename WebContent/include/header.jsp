<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pages.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/hotfix.css" type="text/css">
    <script src="${pageContext.request.contextPath}/js/jquery.js" type="application/javascript"></script>
    <title>C-it</title>
</head>
<body>     
    <header>
        <div class="header-wrap">   
             <!-- LOGO -->            
            <h1 class="logo"><a href="#">C-it</a></h1>   
            <!-- 헤더왼쪽-flex -->            
            <ul id="header_01">            
                <li><a href="${pageContext.request.contextPath}/NoticeListAdmin.do" class="header_01_a">Notice</a></li>
                <li><a href="${pageContext.request.contextPath}/NewsListController.do" class="header_01_a">News</a></li>
                <li><a href="${pageContext.request.contextPath}/BoardList.do" class="header_01_a">Board</a></li>
                <li><a href="#" class="header_01_a">MeetUp</a></li> 
            </ul> 
            <!-- 헤더오른쪽-flex -->
            <ul id="header_02">
            	<c:choose>
            	<c:when test="${id eq null}">
            		<li><a href="${pageContext.request.contextPath}/login/login.jsp" class="header_02_a">Sign in</a></li>
            	</c:when>
            	<c:otherwise>
            		<li><a href="${pageContext.request.contextPath}/logout.do" class="header_02_a">Sign out</a></li>
            	</c:otherwise>
               </c:choose>
               
               <c:choose>
            	<c:when test="${id eq null}">
            		<li><a href="${pageContext.request.contextPath}/JoinController.do" class="header_02_a">Join us</a></li>
            	</c:when>
            	<c:otherwise>
            		<li><a href="${pageContext.request.contextPath}/MemberUpdateController.do" class="header_02_a">My page</a></li>
            	</c:otherwise>
               </c:choose>
            </ul>
        </div>
    </header>

