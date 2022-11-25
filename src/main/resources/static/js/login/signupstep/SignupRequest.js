/**
 * SignupRequest.js
 * 회원가입 정보를 서버에 post 요청
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-16, 최종수정 2022-11-25
 */
export default class SignupRequest{

  //회원가입 post 요청
  signup = (email, pw, name, phone) => {

    //post로 보낼 데이터
    const data = {email: email, pw:pw, name:name, phone: phone, role: "member"};

    //서버로 post 요청 (회원가입 입력)
    $.ajax({
      type: "POST",
      dataType : 'json',
      contentType: 'application/json; charset=utf-8',
      url: "",
      data: JSON.stringify(data),
      cache : false,
      //meta태그의 숨겨진 csrf 토큰을 가져옴
      headers: {
        'X-CSRF-TOKEN': $("meta[name='_csrf']").attr("th:content")
      },
      success: function(response){
          console.log("success ", response);
      }
    });
        
  }
}