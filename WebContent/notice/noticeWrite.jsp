<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/pages.css"> 
    <!-- 스마트에디터 -->    
    <script type="text/javascript" src="../../smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
    <script type="text/javascript" charset="utf-8" src="../../js/s/1/1-1.js"></script>
       
    <title>Document</title>
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
                <div class="editor-title-set">
                    <div class="editor-title-text">제목</div>
                    <div class="editor-title"></div>
                </div>
                <form action="send.jsp" method="post" id="frm">
                    <textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:100%; height:412px; margin-bottom: 2%; mar"></textarea>
                    <div class="write-btn-set">
                        <div class="reset-btn"><input class="resetbutton" type="button" id="resetbutton" value="취소" /></div>
                        <div class="save-btn"><input class="savebutton" type="button" id="savebutton" value="완료" /></div>
                    </div>       
                </form>
            </div>   
        </div>     
    </section>
<%@ include file="/include/footer.jsp" %>