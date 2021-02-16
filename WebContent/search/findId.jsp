<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/findId.css">
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
        <div id="section_title"><h1>Find ID</h1></div>
        <!-- 컨텐츠내용 -->
        <div id="section-contents-wrap">
            <div id="section_contents">
            	<form action="<%=request.getContextPath()%>/searchId.do" method="post" id="search_form">
                <div id="box-name">아이디찾기</div>
	                <div id="box">
	                    <div class="box-div" id="box-div-text">아이디는 가입시 입력하신 이메일을 통해 찾을 수 있습니다.</div>
	                    <div class="box-div"><input type="text" name="name" id="name" placeholder="이름"><br></div>
	                    <div class="box-div"><input type="email" name="email" id="email" placeholder="이메일"><br></div>
	                    <div class="box-div"><input type="submit" id="searchCheck" value="찾기"></input></div>
	                </div>
                </form>
            </div>   
        </div>     
    </section>
<%@ include file="/include/footer.jsp" %>