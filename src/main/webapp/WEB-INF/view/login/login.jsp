<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>

<main>
  <div class="login_container">
    <div>
        <span class="signature_logo"><p></p></span>
        <span class="radio_groups">
            <div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" checked/>
                <label class="form-check-label" for="flexRadioDefault1">일반회원 로그인</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2"/>
                <label class="form-check-label" for="flexRadioDefault2">비회원 로그인</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault3"/>
                <label class="form-check-label" for="flexRadioDefault3" style="color:lightgray;">관리자계정 로그인</label>
            </div>
        </span>
    </div>

    <form id="form_1">
      <div class="mb-3">
        <label for="input_email" class="form-label">이메일 주소</label>
        <input type="email" class="form-control" id="input_email" aria-describedby="emailHelp"/>
        <div id="emailHelp" class="form-text">
        </div>
      </div>
      <div class="mb-3">
        <label for="input_password_1" class="form-label">비밀번호</label>
        <input type="password" class="form-control" id="input_password_1" />
      </div>
      <button type="submit" class="btn btn-primary">로그인</button>
    </form>

    <form id="form_2" class="hidden">
        <div class="mb-3">
          <label for="input_phonenumber" class="form-label">전화번호</label>
          <input type="email" class="form-control" id="input_phonenumber" aria-describedby="phoneHelp"/>
          <div id="phoneHelp" class="form-text">
          </div>
        </div>
        <div class="mb-3">
          <label for="input_password_2" class="form-label">비밀번호</label>
          <input type="password" class="form-control" id="input_password_2" aria-describedby="passwordHelp"/>
        </div>
        <div id="passwordHelp" class="form-text">
            비밀번호 4자리를 입력해주세요
        </div>
        <button type="submit" class="btn btn-primary">로그인</button>
    </form>
    <form id="form_3" class="hidden">
        <div class="mb-3">
            <label for="input_email_admin" class="form-label" >관리자 이메일</label>
            <input type="email" class="form-control" id="input_email_admin" aria-describedby="emailHelp"/>
            <div id="emailHelp" class="form-text">
            </div>
        </div>
        <div class="mb-3">
            <label for="input_password_admin" class="form-label">비밀번호</label>
            <input type="password" class="form-control" id="input_password_admin" />
        </div>
        <button type="submit" class="btn btn-primary">로그인</button>
    </form>
  </div>
  <script>
    $("input[name='flexRadioDefault']").change(()=>{
        const thisnum =  $("input[name='flexRadioDefault']:checked").attr('id').slice(-1);
        $('form').addClass('hidden');
        $('#form_'+thisnum).removeClass('hidden');
    });
  </script>
</main>