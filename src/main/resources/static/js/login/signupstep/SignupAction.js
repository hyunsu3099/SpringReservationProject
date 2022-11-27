/**
 * SignupAction.js
 * 회원가입 폼의 검증 절차 이벤트 핸들러 추가 및 버튼 이벤트 핸들러 추가
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-16, 최종수정 2022-11-24
 */
import SignupValidation from "./SignupValidation.js";
import SignupRequest from "./SignupRequest.js";

export default class SignupAction{
    id={};
    signupValidation;
    signupRequest;

    // 회원가입 정보가 모두 정상적으로 입력되었을 때, 회원가입버튼 활성화
    signupBtnHandler = () => {
        if(this.signupValidation.status.isEmailValid 
            &this.signupValidation.status.isPwValid
            &this.signupValidation.status.pwChk
            &this.signupValidation.status.isNameValid
            &this.signupValidation.status.isPhoneValid){
        //회원가입 정보 전송
        this.signupRequest.signup(
            $('#'+this.id.email_input).val(),
            $('#'+this.id.pw_input).val(),
            $('#'+this.id.name_input).val(),
            $('#'+this.id.phone_input).val()
        );}else{
            console.log(
                'email : ', this.signupValidation.status.isEmailValid ,
                'pw : ', this.signupValidation.status.isPwValid ,
                'pwChk : ', this.signupValidation.status.pwChk ,
                'name : ', this.signupValidation.status.isNameValid ,
                'phone : ', this.signupValidation.status.isPhoneValid
            );
        }
    };

    // 이메일 input에서 커서가 없어졌을때 핸들러동작
    // signupValidation 확인후 메시지 출력
    emailInputHandler = () => {
        console.log("emailhandler");
        this.signupValidation.isEmailValid($('#' +this.id.email_input).val());
        if(! this.signupValidation.status.isEmailValid){
            $('#'+this.id.email_help).addClass('red_text');
            $('#'+this.id.email_input).addClass('is-invalid');
            $('#'+this.id.email_help).text(this.signupValidation.status.message.email);
        }else{
            $('#'+this.id.email_help).removeClass('red_text');
            $('#'+this.id.email_input).removeClass('is-invalid');
            $('#'+this.id.email_help).empty();
        }
    };

    // pw input에서 커서가 없어졌을때 핸들러동작
    // signupValidation 확인후 메시지 출력
    pwInputHandler = () => {
        console.log("pwhandler");
        this.signupValidation.isPwValid($('#' +this.id.pw_input).val());
        if(! this.signupValidation.status.isPwValid){
            $('#'+this.id.pw_help).addClass('red_text');
            $('#'+this.id.pw_input).addClass('is-invalid');
            $('#'+this.id.pw_help).text(this.signupValidation.status.message.pw);
        }else{
            $('#'+this.id.pw_help).removeClass('red_text');
            $('#'+this.id.pw_input).removeClass('is-invalid');
            $('#'+this.id.pw_help).empty();
        }
        this.pwchkInputHandler();
    };

    // pwChk input에서 커서가 없어졌을때 핸들러동작
    // signupValidation 확인후 메시지 출력
    pwchkInputHandler = () => {
        this.signupValidation.pwChk($('#' +this.id.pwchk_input).val());
        if(! this.signupValidation.status.pwChk){
            $('#'+this.id.pwchk_help).addClass('red_text');
            $('#'+this.id.pwchk_input).addClass('is-invalid');
            $('#'+this.id.pwchk_help).text(this.signupValidation.status.message.pwChk);
        }else{
            $('#'+this.id.pwchk_help).removeClass('red_text');
            $('#'+this.id.pwchk_input).removeClass('is-invalid');
            $('#'+this.id.pwchk_help).empty();
        }
    };

    // name input에서 커서가 없어졌을때 핸들러동작
    // signupValidation 확인후 메시지 출력
    nameInputHandler = () => {
        this.signupValidation.isNameValid($('#' +this.id.name_input).val());
        if(! this.signupValidation.status.isNameValid){
            $('#'+this.id.name_help).addClass('red_text');
            $('#'+this.id.name_input).addClass('is-invalid');
            $('#'+this.id.name_help).text(this.signupValidation.status.message.name);
        }else{
            $('#'+this.id.name_help).removeClass('red_text');
            $('#'+this.id.name_input).removeClass('is-invalid');
            $('#'+this.id.name_help).empty();
        }
    };

    // phone input에서 커서가 없어졌을때 핸들러동작
    // signupValidation 확인후 메시지 출력
    phoneInputHandler = 
    () => {
        this.signupValidation.isPhoneValid($('#' +this.id.phone_input).val());
        if(! this.signupValidation.status.isPhoneValid){
            $('#'+this.id.phone_help).addClass('red_text');
            $('#'+this.id.phone_input).addClass('is-invalid');
            $('#'+this.id.phone_help).text(this.signupValidation.status.message.phone);
        }else{
            $('#'+this.id.phone_help).removeClass('red_text');
            $('#'+this.id.phone_input).removeClass('is-invalid');
            $('#'+this.id.phone_help).empty();
        }
    };

    //
    initialize = (id) =>{
        this.id= id;
        this.signupValidation = new SignupValidation();
        this.signupRequest = new SignupRequest();
        this.signupValidation.initialize(id);

        $('#'+this.id.btn).on("click",this.signupBtnHandler);

        $('#'+this.id.email_input).on("blur",this.emailInputHandler);
        $('#'+this.id.pw_input).on("blur",this.pwInputHandler);
        $('#'+this.id.pwchk_input).on("blur",this.pwchkInputHandler);
        $('#'+this.id.name_input).on("blur",this.nameInputHandler);
        $('#'+this.id.phone_input).on("blur",this.phoneInputHandler);

    };
}
