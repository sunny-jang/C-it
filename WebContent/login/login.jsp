<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/log.css">
<script>
$.ajax({
	type : 'post',
	async : 'true',
	url : '/Cit/loginController',
	data : {id: id}, {pw : pw},
	dataType : 'json',
	success : function(data){
				if(data.)
	}
})
</script>
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
                <form method="post" name="log" action="<%=request.getContextPath()%>/loginController">
                    <div class="box-div input" id="fist" ><input type="text" placeholder="아이디" name="id"></div>
                    <div class="box-div input"><input type="password" placeholder="비밀번호" name="pw"></div>
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
 <%@ include file="/include/footer.jsp" %>