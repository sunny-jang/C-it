<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
    <!-- 스마트에디터 -->    
    <script type="text/javascript" src="/Cit/sm/js/HuskyEZCreator.js" charset="utf-8"></script>
    <section>
      <!-- 제목 -->
      <div id="section_title"><h1 id="section-title-text">Notice</h1></div>
        <!-- 컨텐츠내용 -->
	        <div id="section-contents-wrap">
		            <div id="section_contents">
			            	<form action="/Cit/NoticeWrite.do" method="get" id="frm" name="noticeWriteForm">
			                    <div class="title-set">
			                    <c:choose>
			                    <c:when test="${update}">
			                    	<div class="title-text"><p class="ed-title">제목<p></div>
			                        <div class="title-input"><input class="editer-title-input" type="text" value="${bdto.title}"/></div>
			                    </c:when>
			                    <c:otherwise>
			                        <div class="title-text"><p class="ed-title">제목<p></div>
			                        <div class="title-input"><input class="editer-title-input" type="text" /></div>
			                    </c:otherwise>
			                    </c:choose>
			                    </div>
			                    <c:choose>
			                    <c:when test="${update}">
			                    <textarea name="contents" id="ir1" rows="10" cols="100" style="width:100%; height:412px; margin-bottom: 2%; ">${bdto.cont}</textarea>
								</c:when>
								<c:otherwise>
								<textarea name="contents" id="ir1" rows="10" cols="100" style="width:100%; height:412px; margin-bottom: 2%; "></textarea>
			                    </c:otherwise>
			                    </c:choose> 
			                        <div class="write-btn-set">
			                        <div class="reset-btn"><input class="resetbutton" type="button" id="resetbutton" value="취소" onclick="location.href='${pageContext.request.contextPath}/NoticeListAdmin.do'"/></div>
			                        <div class="save-btn"><input class="savebutton" type="button" id="savebutton" value="완료" onclick="submitContents(this)" /></div>
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
	    const frm = document.forms['noticeWriteForm']
	    const title = frm.title.value;
	    const contents = frm.ir1.value;
	    
	    frm.ir1.getElementby
	    
	    if(title == '' || contents == '') {
	    	alert("값을 입력하세요.");
	    } else {
	    	try {
		       elClickedObj.form.submit();
		    } catch(e) {}
	    }
	}
</script>
<%@ include file="/include/footer.jsp" %>