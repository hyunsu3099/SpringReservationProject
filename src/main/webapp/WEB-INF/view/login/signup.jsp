<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<main>
  <div class="signup_container">
    <div>
        <span class="signature_logo"><p></p></span>
        <span><p><h5>예약페이지 회원가입</h5></p></span>
    </div>
    
    <form class="form-floating">

      <div class="form-floating">
        <input type="email" class="form-control is-invalid" id="input_email" placeholder="name@example.com" value="test@example.com" aria-describedby="email_help"/>
        <label for="input_email">이메일주소</label>
        <div id="email_help" class="form-text">이메일주소 입력해주세요</div>
      </div>

      <div class="form-floating">
        <input type="password" class="form-control" id="input_password" aria-describedby="password_help"/>
        <label for="input_password">비밀번호</label>
        <div id="password_help" class="form-text"></div>
      </div>

      <div class="form-floating">
        <input type="password" class="form-control" id="input_password_chk" aria-describedby="password_chk_help"/>
        <label for="input_password_chk">비밀번호 확인</label>
        <div id="password_chk_help" class="form-text"></div>
      </div>

      <div class="form-floating">
        <input type="text" class="form-control" id="input_name" aria-describedby="name_help"/>
        <label for="input_name">이름</label>
        <div id="name_help" class="form-text"></div>
      </div>
      <div class="form-floating">
        <input type="tel" class="form-control" id="input_phone" aria-describedby="phone_help"/>
        <label for="input_phone">전화번호</label>
        <div id="phne_help" class="form-text"></div>
      </div>

      <div class="d-grid gap-2">
        <button class="btn btn-primary" type="button">회원가입</button>
      </div>

    </form>
  </div>
</main>
