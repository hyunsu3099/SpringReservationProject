/**
 * 
 * 
 */
import LoginValidation from "./LoginValidation.js";
import LoginRequest from "./LoginRequest.js";

export default class LoginAction{

    /**
     * dom id객체 받아오기
     */
    id={};

    //Validation, request클래스 객체 생성
    loginValidation;
    loginRequest;

    //로그인 버튼 누를시 양식 확인
    loginBtnHandler = (form_id) => {
        let emailOrPhone = $('#'+form_id+ ' .'+this.id.class_id).val();
        let pw = $('#'+form_id+ ' .'+this.id.class_pw). val();
        
        //이메일 or 전화번호 양식 검증
        //비회원 로그인시 email이 아닌 전화번호로 로그인
        if(form_id=='form_2') this.loginValidation.isPhoneValid(emailOrPhone);
        else this.loginValidation.isEmailValid(emailOrPhone);

        //pw 양식 검증
        this.loginValidation.isPasswordValid(pw);

        if(! this.loginValidation.status.isEmailValid){
            $('#'+form_id+ ' .'+this.id.class_id_help).addClass('red_text');
            $('#'+form_id+ ' .'+this.id.class_id).addClass('is-invalid');
            $('#'+form_id+ ' .'+this.id.class_id_help).text(this.loginValidation.status.message.email);
        }else{
            $('#'+form_id+ ' .'+this.id.class_id_help).removeClass('red_text');
            $('#'+form_id+ ' .'+this.id.class_id).removeClass('is-invalid');
            $('#'+form_id+ ' .'+this.id.class_id_help).empty();
        }

        if(! this.loginValidation.status.isPwValid){
            $('#'+form_id+ ' .'+this.id.class_pw_help).addClass('red_text');
            $('#'+form_id+ ' .'+this.id.class_pw).addClass('is-invalid');
            $('#'+form_id+ ' .'+this.id.class_pw_help).text(this.loginValidation.status.message.pw);
        }else {
            $('#'+form_id+ ' .'+this.id.class_pw_help).removeClass('red_text');
            $('#'+form_id+ ' .'+this.id.class_pw).removeClass('is-invalid');
            $('#'+form_id+ ' .'+this.id.class_pw_help).empty();
        }

        //email/pw 검증 통과시 서버에 request
        if(this.loginValidation.status.isEmailValid &this.loginValidation.status.isPwValid)
        this.loginRequest.login(emailOrPhone, pw, form_id);
    };

    initialize = (id) =>{
        this.id= id;
        this.loginValidation = new LoginValidation();
        this.loginRequest = new LoginRequest();

        this.loginValidation.initialize();

        
    };
 }