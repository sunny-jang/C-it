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
                <table class="news-write-table">
                 <colgroup>
                        <col style="width: 20%">
                        <col style="width: 20%">
                        <col style="width: 20%">
                        <col style="width: 40%">                        
                    </colgroup>
                    <tr>
                    <td><div class="editor-title-text">카테고리</div></td>
                        <td class="news_category" >
                        	<c:choose>
                        		<c:when test="${update}">
                        		<select name="category" id="categovvvry" value="${post.cate}">
                        		</c:when>
                        		<c:otherwise>
                        		<select name="category" id="category">
                        		</c:otherwise>
                        	</c:choose>
                                <option value="채용">채용</option>
                                <option value="기업">기업</option>
                                <option value="인터뷰">인터뷰</option>
                            </select>
                        </td>
                        <td><div class="editor-title-text">제목</div></td>
                        <td colspan="2"><div class="editor-title">
                        <c:choose>
                       		<c:when test="${update}">
                       		<input class="editer-title-input" type="text" name="title" value="${post.title}">
                       		</c:when>
                       		<c:otherwise>
                       		<input class="editer-title-input" type="text" name="title">
                       		</c:otherwise>
                       	</c:choose>
                        </div></td>
                    </tr>
                    <tr>
                        <td><div class="editor-writer-1">작성자</div></td>
                        <td><div class="editor-writer">
                         <c:choose>
                       		<c:when test="${update}">
                       		<input class="editor-writer-input" type="text" name="author" value="${post.author}">
                       		</c:when>
                       		<c:otherwise>
                       		<input class="editor-writer-input" type="text" name="author">
                       		</c:otherwise>
                       	</c:choose>
                        </div></td>
                        <td><div class="editor-writer-1">원문링크</div></td>
                        <td><div class="editor-writer">
                        
                        <c:choose>
                       		<c:when test="${update}">
                       		<input class="editor-writer-input originallink" type="url" name="newsLink" value="${post.newsLink}">
                       		</c:when>
                       		<c:otherwise>
                       		<input class="editor-writer-input originallink" type="url" name="newsLink">
                       		</c:otherwise>
                       	</c:choose>
                        </div></td>
                    </tr>
                </table>
                	<c:choose>
                    		<c:when test="${update}">
                    		<textarea name="contents" id="ir1" rows="10" cols="100" style="width:100%; height:412px; margin-bottom: 2%; value="${post.cont}"></textarea>
                    		</c:when>
                    		<c:otherwise>
                    		<textarea name="contents" id="ir1" rows="10" cols="100" style="width:100%; height:412px; margin-bottom: 2%; "></textarea>
                    		</c:otherwise>
                    	</c:choose>
                    	<input type="hidden" name="num" value="${post.num}">
                    <div class="write-btn-set">
                        <div class="reset-btn"><input class="resetbutton" type="button" id="resetbutton" value="취소" /></div>
                        <c:choose>
                    		<c:when test="${update}">
                    		<div class="save-btn"><input class="savebutton" type="button" id="savebutton" value="완료" onclick="submitContents(this, 'update','${post.num}')"/></div>
                    		</c:when>
                    		<c:otherwise>
                    		<div class="save-btn"><input class="savebutton" type="button" id="savebutton" value="완료" onclick="submitContents(this)"/></div>
                    		</c:otherwise>
                    	</c:choose>
                        
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

	function submitContents(elClickedObj, status) {
	    // 에디터의 내용이 textarea에 적용됩니다.
	    oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
	    const frm = document.forms['newsWriteForm'];
	    const category = frm.category.value;
	    const title = frm.title.value;
	    const contents = frm.ir1.value;
	    const author = frm.author.value;
	    const newsLink = frm.newsLink.value;
	    
	    if(category == '' || title == '' || contents == '<br>' ||author == '' || newsLink == '') {
	    	alert("값을 입력하세요.");
	    } else {
	    	try {
	    		if(status == "update") {
	    			frm.action = "/Cit/NewsUpdateController.do";
	    		}
		       elClickedObj.form.submit();
		    } catch(e) {}
	    }
	}
</script>
<%@ include file="/include/footer.jsp"%>