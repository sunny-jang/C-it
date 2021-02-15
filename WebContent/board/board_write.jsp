<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
    <!-- 스마트에디터 -->    
    <script type="text/javascript" src="../../smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
    <script type="text/javascript" charset="utf-8" src="../../js/s/1/1-1.js"></script>
    <section>
        <!-- 제목 -->
        <div id="section_title"><h1 id="section-title-text">BOARD</h1></div>
        <!-- 컨텐츠내용 -->
        <div id="section-contents-wrap">
            <div id="section_contents">
                <div class="editor-title-set">
                    <select name="boardCategory" id="board_category">
                        <option value="daily">사는얘기</option>
                        <option value="problem">고민</option>
                        <option value="interview">면접후기</option>
                        <option value="academy">국비교육</option>
                        <option value="study">스터디모집</option>
                    </select>
                    <div class="editor-title-text" name="title">제목</div>
                   <input type="text" name="content">
                </div>
                <form action="board.do" method="post" id="frm">
                    <textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:100%; height:412px; margin-bottom: 2%;"></textarea>
                    <div class="write-btn-set">
                        <div class="reset-btn"><input class="resetbutton" type="button" id="resetbutton" value="취소" /></div>
                        <div class="save-btn"><input class="savebutton" type="button" id="savebutton" value="완료" /></div>
                    </div>       
                </form>
            </div>   
        </div>     
    </section>
<%@ include file="/include/footer.jsp" %>     