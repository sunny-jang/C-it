<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/findpw.css">
<script>
$(function() {
	$("#searchCheck").on("click", function() {
		let nameVal = $("#name").val();
		let emailVal = $("#email").val();
		$.ajax({
			type : 'post',
			async : 'true',
			url : "/Cit/searchCheck.do",
			data : {name: nameVal, email : emailVal}, 
			dataType : 'json',
			success : function(data){
						if(data.name == "-1" || data.email == "-1") {
							alert("이름 또는 이메일을 입력해주세요")
						}else {
							$("#search_form").submit();
						}
					},
			error : function(request, status, error) {
				alert("에러코드 : "+  error);			
			}
		})
	})
})
</script>
    <section>
        <!-- 제목 -->
        <div id="section_title"><h1>Find Password</h1></div>
        <!-- 컨텐츠내용 -->
        <div id="section-contents-wrap">
            <div id="section_contents">
	            <form action="<%=request.getContextPath()%>/searchPw.do" method="post">
	            <div id="box-name">비밀번호 찾기</div>
		        	<div id="box">
			            <div class="box-div" id="box-div-text">비밀번호는 가입시 입력하신 아이디,이메일을 통해 찾을 수 있습니다.</div>
			            <div class="box-div input"><input type="text" name="name" placeholder="이름" ><br></div>
			            <div class="box-div input"><input type="text" name="id" placeholder="아이디" ><br></div>
			            <div class="box-div input"><input type="email" name="email" placeholder="이메일"><br></div>
			            <div class="box-div input"><input type="submit" value="찾기"></input></div>
		         	</div>
	             </form>
            </div> 
         </div>    
    </section>
<%@ include file="/include/footer.jsp" %>