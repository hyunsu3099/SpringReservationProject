/**
 * LoginRequest.js
 * 로그인 정보를 서버에 post 요청
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-16, 최종수정 2022-11-27
 */
export default class LoginRequest{

  //로그인 post 요청
  login = (email, pw, role) => {

    //서버로 보낼 데이터
    let data = { 'username': email, 'password': pw, 'role': role};
    if(role=="nonmember") 
        data = { 'username': phone, 'password': pw, 'role': role};

    //서버로 post 
    $.ajax({
      type: "POST",
      url: "/login",
      data: data,
      cache : false,
      //meta태그의 숨겨진 csrf 토큰을 가져옴
      headers: {
        'X-CSRF-TOKEN': $("meta[name='_csrf']").attr("th:content")
      },
      success: function(response){
          console.log(response);
      },
      error: function(message){
        console.log("message ", message);
      }
    });
  }
}