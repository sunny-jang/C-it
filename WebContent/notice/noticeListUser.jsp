<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ include file="/include/header.jsp" %>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.2/css/all.css" integrity="sha384-vSIIfh2YWi9wW0r9iZe7RJPrKwp6bG+s9QZMoITbCckVJqGCCRhc+ccxNcdpHuYu" crossorigin="anonymous">
<script>
$(document).ready(function() {
  $(".accordion_head").click(function() {
      let icon = $(this).children('#plus');
      let body = $(this).next(".accordion_body");
      let minusClass = 'fa-minus-square';
      let plusClass = 'fa-plus-square';
      
      icon.removeClass(minusClass);
      icon.removeClass(plusClass);

    if (body.is(':visible')) {
      body.slideUp(300);
      icon.addClass(plusClass);
    } else {
      body.slideDown(300);
      icon.addClass(minusClass);
    }
  });
});
</script>
    <section>
        <!-- 제목 -->
        <div id="section_title"><h1 id="section-title-text">Notice</h1></div>
        <!-- 컨텐츠내용 -->
        <div id="section-contents-wrap">
            <div id="section_contents">
                <!-- 게시판 목록 -->
                  <div class="accordion_container">
                    <div class="accordion_head" width="auto">제목
                      <i id="plus" class="fas fa-plus-square"></i>
                      </div>
                    <div class="accordion_body" style="display: none;">
                      <p>공지사항</p>
                    </div>     
                  </div>
                  

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
                  </div>
          </div>   
        </div>     
    </section>
<%@ include file="/include/footer.jsp" %>