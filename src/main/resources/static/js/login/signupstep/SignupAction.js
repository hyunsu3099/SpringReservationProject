/**
 * 
 * 
 */
import SignupValidation from "./SignupValidation.js";
import SignupRequest from "./SignupRequest.js";

export default class SignupAction{
    id={};
    signupValidation;
    signupRequest;

    signupBtnHandler = () => {
        if(this.signupValidation.status.isEmailValid 
            &this.signupValidation.status.isPasswordValid
            &this.signupValidation.status.pwChk
            &this.signupValidation.status.isNameValid
            &this.signupValidation.status.isPhoneValid)
        this.signupRequest.signup();
    };

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

    pwInputHandler = () => {
        console.log("pwhandler");
        this.signupValidation.isPwValid($('#' +this.id.pw_input).val());
        if(! this.signupValidation.status.isEmailValid){
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
