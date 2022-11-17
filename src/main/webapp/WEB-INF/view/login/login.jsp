<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>

<main>
  <div class="login_container" >
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

    <div id="form_1" class="form">
      <div class="mb-3">
        <label for="input_email" class="form-label">이메일 주소</label>
        <input type="email" class="form-control input_id" id="input_email" aria-describedby="email_help_1"/>
        <div id="email_help_1" class="form-text input_id_help">
        </div>
      </div>
      <div class="mb-3">
        <label for="input_pw_1" class="form-label">비밀번호</label>
        <input type="password" class="form-control input_pw" id="input_pw_1" aria-describedby="pw_help_1"/>
        <div id="pw_help_1" class="form-text input_pw_help">
        </div>
      </div>
      <button class="btn btn-primary">로그인</button>
    </div>

    <div id="form_2" class="hidden form">
        <div class="mb-3">
          <label for="input_phonenumber" class="form-label">전화번호</label>
          <input type="tel" class="form-control input_id" id="input_phonenumber" aria-describedby="phonenumber_help" required pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}"/>
          <div id="phonenumber_help" class="form-text input_id_help">
            예) 010-1234-5678
          </div>
        </div>
        <div class="mb-3">
          <label for="input_password_2" class="form-label">비밀번호</label>
          <input type="password" class="form-control input_pw" id="input_pw_2" aria-describedby="pw_help_2" maxlength="4" />
          <div id="pw_help_2" class="form-text input_pw_help">
            비밀번호 4자리를 입력해주세요
          </div>
        </div>
        <button class="btn btn-primary">로그인</button>
    </div>
    <div id="form_3" class="hidden form">
        <div class="mb-3">
            <label for="input_email_admin" class="form-label" >관리자 이메일</label>
            <input type="email" class="form-control input_id" id="input_email_admin" aria-describedby="email_help_2"/>
            <div id="email_help_2" class="form-text input_id_help">
            </div>
        </div>
        <div class="mb-3">
            <label for="input_password_admin" class="form-label">비밀번호</label>
            <input type="password" class="form-control input_pw" id="input_pw_admin" aria-describedby="pw_help_3"/>
            <div id="pw_help_3" class="form-text input_pw_help">
            </div>
        </div>
        <button class="btn btn-primary">로그인</button>
    </div>

    <p class="login_info">
      <span><a hredivf="#">아이디 찾기</a>|</span>
      <span><a href="#">비밀번호 찾기</a>|</span>
      <span><a href="#">회원가입</a></span>
    </p>
  </div>
  <script>
    //radio 버튼 클릭시 폼 변경
    $("input[name='flexRadioDefault']").change(()=>{
        const thisnum =  $("input[name='flexRadioDefault']:checked").attr('id').slice(-1);
        $('.form').addClass('hidden');
        $('#form_'+thisnum).removeClass('hidden');
    });
  </script>
</main>