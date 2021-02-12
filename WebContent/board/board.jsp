<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/layout.css">
    <link rel="stylesheet" href="./css/pages.css">
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
                      <tr>
                        <td><a href=""></a></td>
                        <td></td>
                        <td></td>
                        <td></td>
                      </tr>
                      <tr>
                        <td><a href=""></a></td>
                        <td></td>
                        <td></td>
                        <td></td>
                      </tr>
                      <tr>
                        <td><a href=""></a></td>
                        <td></td>
                        <td></td>
                        <td></td>
                      </tr>
                      <tr>
                        <td><a href=""></a></td>
                        <td></td>
                        <td></td>
                        <td></td>
                      </tr>
                      <tr>
                        <td><a href=""></a></td>
                        <td></td>
                        <td></td>
                        <td></td>
                      </tr>
                      <tr>
                        <td><a href=""></a></td>
                        <td></td>
                        <td></td>
                        <td></td>
                      </tr>
                      <tr>
                        <td><a href=""></a></td>
                        <td></td>
                        <td></td>
                        <td></td>
                      </tr>
                      <tr>
                        <td><a href=""></a></td>
                        <td></td>
                        <td></td>
                        <td></td>
                      </tr>
                      <tr>
                        <td><a href=""></a></td>
                        <td></td>
                        <td></td>
                        <td></td>
                      </tr>
                      <tr>
                        <td><a href=""></a></td>
                        <td></td>
                        <td></td>
                        <td></td>
                      </tr>   
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