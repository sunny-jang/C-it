<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <style>
    label {
      width: 150px;
      display: inline-block;
      margin-bottom: 10px;
    }

    form {
      width: 500px;
      margin: 100px auto;
      padding: 50px;
      background-color: aliceblue;
    }

    .small {
      width: 100px;
    }
  </style>
</head>
<body>
  <form action="joinController" method="post">
    <label for="">아이디</label><input type="text" name="id"><input type="button" value="중복확인"><br>
    <label></label><span>${request.msg}</span><br>
    <label for="">비밀번호</label><input type="password" name="pw"><br>
    <label for="">비밀번호 확인</label><input type="password"><br>
    <label for="">이름</label><input type="text" name="name"><br>
    <label for="">이메일</label><input type="email" name="email"><br>
    <label for="">성별 | </label> 
         여 <input type="radio" name="gender" value="f">
         남 <input type="radio" name="gender" value="m"><br>
    <label for="">생년월일</label><input type="text" name="year" class="small"><input type="text" name="month" class="small"><input type="text" name="day" class="small"><br>
    <label for="">직업</label> 취준생<input type="radio" name="job" value="취준생">직장인<input type="radio" name="job" value="직장인"> <input type="text" name="job"><br>
    <label for="">가입경로</label>뉴스<input type="checkbox" name="path" value="뉴스">지인<input type="checkbox" name="path" value="지인"> <input type="checkbox" name="path" value="카페"><br>
    <br><br>
    <div style="text-align: right;">
    <input type="submit" value="가입하기">
    </div>
  </form>
</body>
</html>