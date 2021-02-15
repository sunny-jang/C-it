<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/include/header.jsp" %>
    <section>
        <!-- 제목 -->
        <div id="section_title"><h1 id="section-title-text">Board</h1></div>
        <!-- 컨텐츠내용 -->
        <div id="section-contents-wrap">
            <div id="section_contents">
              <div class="editor-title-set">
                  <%--   <c:set var="n" value="${boardDetail}"></c:set> --%>
                    <div class="board-view-category">${BoardDetail.cate }</div>
                    <div><h2 class="board-view-title">wpahradss</h2></div>
                </div>               
                <div class="board-view-info-box">
                    <div class="board-view-info wrt">작성자 : ${BoardDetail.id }</div>
                    <div class="board-view-info date">작성일 : ${BoardDetail. date}</div>
                    <div class="board-view-info viewnum">조회수 : ${BoardDetail.views }</div> 
                    <div class="board-view-info num"></div>                   
                </div>
                <div class="board-view-pic"></div>
                <div class="board-view-text">${BoardDetail.cont }
                <p></p></div>

                <form action="send.jsp" method="post" id="frm">
                    <textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:100%; height:412px; margin-bottom: 2%; mar"></textarea>
                    <div class="write-btn-set">
                        <div class="reset-btn"><input class="resetbutton" type="button" id="resetbutton" value="수정" /></div>
                        <div class="save-btn"><input class="savebutton" type="button" id="savebutton" value="목록" /></div>
                    </div>       
                </form>    
            </div>   
        </div>     
    </section>
<%@ include file="/include/footer.jsp" %>  