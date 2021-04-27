$(function() {
	let authCheck = false;
	let idCheck = false;
	let originEmail = $("#email").val();
	$("#checkIdDup").on("click", function() {
		let idVal = $("#id").val();
		$.ajax({
			url: "/Cit/IdDupCheck.do",
			dataType: "json",
			data : {id: idVal},
			success: function(data) {
				if(data.id == "0") {
					alert("사용할 수 없는 아이디 입니다.");
				}else if(data.id == "1") {
					alert("사용할 수 있는 아이디 입니다.");
					idCheck = true;
					$("#checkIdDup").css({"background":"#20b8bc", "color": "white", "border": "none"});
				}else if(data.id == "-1"){
					alert("값을 입력해 주세요.");
				}
			},
			error : function(request, status, error) {
				alert("에러코드 : "+  error);
			}
		})
	});
	
	$("#checkEmail").on("click", function() {
		let emailVal = $("#email").val();
		$.ajax({
			url: "/Cit/mailServlet.do",
			dataType: "json",
			data : {email: emailVal},
			success: function(data) {
				console.log(data);
				if(data.isEmpty){
					alert("이메일을 입력해 주세요.")
				}else if(data.isUsed) {
					alert("이미 사용중인 이메일 입니다.");
				}else {
					alert("이메일이 전송되었습니다.");
					$("#emailAuthBox").css("display","block");
				}
			},
			error : function(request, status, error) {
				alert("에러코드 : "+  error);
			}
			
		})
	});
	
	$("#checkAuth").on("click", function() {
		let authNumlVal = $("#authNum").val();
		$.ajax({
			url: "/Cit/checkAuth.do",
			dataType: "json",
			data : {authNum: authNumlVal},
			success: function(data) {
				if(data.check == "값 없음") {
					alert("값을 입력해주세요.");
				}else if(data.check ="일치") {
					alert("이메일이 인증되었습니다!");
					$("#checkAuth").css({"background":"#20b8bc", "color": "white", "border": "none"});
					authCheck = true;
					console.log(authCheck);
				}else {
					alert("인증번호를 확인해주세요.");
				}
			},
			error : function(request, status, error) {
				alert("request : "+  request);
				alert("status : "+  status);
				alert("에러코드 : "+  error);
			}
			
		})
	});
	
	$("#joinSubmit").on("click", function() {
		let emailAuth = authCheck;
		
		let policyCheck = $("#agreeform-chk").is(":checked");
		console.log(policyCheck);
		if(!idCheck){
			alert("아이디 중복 체크를 해주세요.");
		}else if(!emailAuth) {
			console.log(authCheck);
			alert("이메일 인증을 해주세요.");
			$("#join_form").attr("onsubmit","return false");
		}else if(policyCheck == null || policyCheck == "" || policyCheck == false) {
			$("#join_form").attr("onsubmit","return false");
			alert("개인정보 처리 방침을 체크해주세요.");
		} else {
			$("#join_form").attr("onsubmit","return true");
			$("#joinSubmit").submit();
		}
	});
	
	$("#pw_check").change(function() {
		let pw = $("#pw").val();
		let pwChk = $("#pw_check").val();
		$("#pwMsg").css("display","none");
		
		if(pw != pwChk) {
			$("#pwMsg").css("display","block");
		}
	});
	
	$("#updateSubmit").on("click", function() {
		let email = $("#email").val();
		let emailAuth = authCheck;
		console.log(emailAuth)
		if(email != originEmail && !emailAuth) {
			
			alert("이메일 인증을 진행해 주세요.");
			
			$("#join_form").attr("onsubmit","return false");
		}else {
			$("#join_form").attr("onsubmit","return true");
			$("#join_form").submit();
		}
		
	});
	
	
})