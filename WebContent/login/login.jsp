<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/log.css" type="text/css">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js" type="text/javascript"></script>
    <title>signin</title>
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
        <div id="section_title">   
            <h1 id="section-title-text">Sign in</h1>  
        </div>       
        <!-- 컨텐츠내용 --> 
        <div id="section-contents-wrap"></div>
            <div id="section_contents">
                <div id="box-name">Welcome to C-it</div>
                <div id="box">
                <form method="post" name="log" action="loginController">
                    <div class="box-div input" id="fist"><input type="text" placeholder="아이디"></div>
                    <div class="box-div input"><input type="password" placeholder="비밀번호"></div>
                    <div class="box-div input" id="signin"><input type="submit" value="Sign in"></input></div>
                </form>    
                    <div class="box-text-out">
                    <div class="box-text" id="id-text"><a href="#">아이디찾기</a></div>
                    <div class="box-text" id="pw-text"><a href="#">/비밀번호찾기</a></div>
                    <div class="box-text" id="join-text"><a href="#">회원가입</a></div>
                    </div>
                </div>  
            </div>
        </div>        
    </section>
    <footer>
        <!-- 하단 -->
        <div class="footer">
            <a id="logo">C-it</a>
            <a>상호명:C-it| 대표명:김효신| 문의:Aaa@gmail.com</a>
            <a>copyright 2021 ⓒHYOSHIN Corp. All Rights Reserve.</a>
        </div>
    </footer>
</body>
</html>