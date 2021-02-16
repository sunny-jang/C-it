<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<!-- 스마트에디터 -->
<script type="text/javascript"
	src="/Cit/sm/js/HuskyEZCreator.js" charset="utf-8"></script>

<section>
        <!-- 제목 -->
        <div id="section_title"><h1 id="section-title-text">NEWS</h1></div>
        <!-- 컨텐츠내용 -->
        <div id="section-contents-wrap">
            <div id="section_contents">
             <form action="/Cit/NewsWriteController.do" method="post" id="frm" name="newsWriteForm">
                <div class="editor-title-set">
                    <select name="category" id="board_category">
                        <option value="채용">채용</option>
                        <option value="기업">기업</option>
                        <option value="인터뷰">인터뷰</option>                     
                    </select>
                    <div class="editor-title-text">제목</div>
                    <div class="editor-title"><input class="editer-title-input" type="text" name="title" id="title"></div>                    
                </div>
                <div class="editor-writer-set">
                    <div class="editor-writer-1">작성자</div>
                    <div class="editor-writer"><input class="editor-writer-input" type="text" name="author" id="author"></div>
                    <div class="editor-writer-1">원문링크</div>
                    <div class="editor-writer"><input class="editor-writer-input originallink" type="url" name="newsLink" id="newsLink"></div>
                </div>
               
                    <textarea name="contents" id="ir1" rows="10" cols="100" style="width:100%; height:412px; margin-bottom: 2%; "></textarea>
                    <div class="write-btn-set">
                        <div class="reset-btn"><input class="resetbutton" type="button" id="resetbutton" value="취소" /></div>
                        <div class="save-btn"><input class="savebutton" type="button" id="savebutton" value="완료" onclick="submitContents(this)"/></div>
                    </div>       
                </form>
            </div>   
        </div>     
    </section>

<script type="text/javascript">

	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
	 oAppRef: oEditors,
	 elPlaceHolder: "ir1",
	 sSkinURI: "/Cit/sm/SmartEditor2Skin.html",
	 fCreator: "createSEditor2"
	});

	function submitContents(elClickedObj) {
	    // 에디터의 내용이 textarea에 적용됩니다.
	    oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
	    const frm = document.forms['newsWriteForm']
	    const category = frm.category.value;
	    const title = frm.title.value;
	    const contents = frm.ir1.value;
	    const author = frm.author.value;
	    const newsLink = frm.newsLink.value;
	    
	    if(category == '' || title == '' || contents == '<br>' ||author == '' || newsLink == '') {
	    	alert("값을 입력하세요.");
	    } else {
	    	try {
		       elClickedObj.form.submit();
		    } catch(e) {}
	    }
	    
	}
</script>
<%@ include file="/include/footer.jsp"%>