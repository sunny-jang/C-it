<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/join.css?version=1"
	type="text/css">
<script src="${pageContext.request.contextPath}/js/memberAjax.js"></script>
<script>
function post_delete(url, id, pw) {
	let checkDel = confirm("정말로 탈퇴 하시겠습니까?");
	if(checkDel) {
		let checkPw = prompt("본인 확인을 위해 비밀번호를 다시 한 번 입력해 주세요.");
		
		if(pw == checkPw) {
			let form = document.createElement("form");
			
			form.action= url;
			form.method= "post";
			
			let input = document.createElement("input");
			input.setAttribute("type","hidden");
			input.setAttribute("name", "u_id");
			input.setAttribute("value", id);
			form.appendChild(input);
			
			document.body.appendChild(form);
			form.submit();
		}else {
			alert("비밀번호가 다릅니다. 다시 확인하시고 시도해주세요.")
		}
	}
}
</script>
<!-- SECTION -->
<section>
	<!-- 제목 -->
	<!-- SECTION TITLE -->
	<div id="section_title">
		<h1 id="section-title-text">MyPage</h1>
		<!-- <p class="section-sub-title">회원정보 수정/탈퇴</p> -->
	</div>
	<!-- 컨텐츠내용 -->
	<!-- SECTION CONTENTS -->
	<div id="section-contents-wrap">
		<div id="section_contents">
			<p class="sub float--right">
				<span class="ico"></span> 필수입력사항
			</p>
			<!-- JOIN FORM   -->
			<form id="join_form" method="post"
				action="${pageContext.request.contextPath}/MemberUpdateController.do">
				<table>
					<colgroup>
						<col width="30%" />
						<col width="auto" />
					</colgroup>

					<tbody>
						<tr>
							<th><span class="ico">아이디</span></th>
							<td><input type="text" placeholder="6자 이상의 영문 혹은 영문+숫자 조합"
								required id="id" name="id" value="${id}" readonly></td>
						</tr>
						<tr>
							<th><span class="ico">비밀번호</span></th>
							<td><input type="password"
								placeholder="8자 이상의 영문+숫자+특수문자 조합" required id="pw" name="pw"
								pattern="^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+])(?!.*[^a-zA-z0-9$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$"></td>
						</tr>
						<tr>
							<th><span class="ico">비밀번호 확인</span></th>
							<td><input type="password" placeholder="비밀번호를 한 번 더 입력해주세요."
								required id="pw_check" name="pw_check"> <i
								style="display: none; color: red" id="pwMsg">비밀번호가 일치하지
									않습니다. 다시 확인해주세요.</i></td>
						</tr>
						<tr>
							<th><span class="ico">이름</span></th>
							<td><input type="text" placeholder="이름을 입력해주세요" required
								id="name" name="name" value="${member.getName()}"></td>
						</tr>
						<tr>
							<th><span class="ico">이메일</span></th>
							<td>
							<input class="email-text" type="email"
								placeholder="예:cit@cit.com" required id="email" name="email"
								style="width: 50%; margin-right: 5%"
								value="${member.getEmail()}"> <a class="btn btn-confirm"
								id="checkEmail">이메일 인증</a>
								<div id="emailAuthBox" style="display: none">
									<input type="text" name="auth" id="authNum"
										placeholder="발송된 인증번호를 입력해 주세요." required> <a
										type="button" id="checkAuth" class="btn btn-confirm">인증하기</a>
								</div>
							</td>
						</tr>
						<tr>
							<th><span>생년월일</span></th>
							<td>
								<div class="birth_day">
									<input type="text" name="year" id="birth_year" pattern="[0-9]*"
										label="생년월일" size="4" maxlength="4" placeholder="YYYY" value="${birth[0]}">
									<span class="bar"></span> <input type="text" name="month"
										id="birth_month" pattern="[0-9]*" label="생년월일" size="2"
										maxlength="2" placeholder="MM" value="${birth[1]}"> <span class="bar"></span>
									<input type="text" name="day" id="birth_day" pattern="[0-9]*"
										label="생년월일" size="2" maxlength="2" placeholder="DD" value="${birth[2]}">
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<!-- 제출버튼 -->
				<div class="complete-btn-wrap">
					<input type="submit" class="complete-btn" id="updateSubmit" value="정보수정완료">
				</div>
				<a class="btn widthrawal" id="widthrawal" onclick="post_delete('${pageContext.request.contextPath}/MemberDelController.do', '${sessionScope.id}', '${member.getPw()}')">${member.getPw()}회원 탈퇴</a>
			</form>
		</div>
	</div>
</section>
<%@ include file="/include/footer.jsp"%>