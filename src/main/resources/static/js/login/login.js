/**
 * 
 * 
 */
import LoginAction from './loginstep/LoginAction.js';

//dom id 부여
let id={
    class_id:'input_id',
    class_pw:'input_pw',
    class_id_help:'input_id_help',
    class_pw_help:'input_pw_help',
    class_btn:'btn',
    class_form:'form',

    normal_form:'form_1',
    normal_email_input:'form_1>#input_email',
    normal_email_help:'form_1>#email_help',
    normal_pw_input:'form_1>#input_pw_1',
    normal_login_btn:'form_1 button',

    nonmember_form:'form_2',
    nonmember_phone_input:'form_2>#input_phonenumber',
    nonmember_phone_help:'form_2>#phonenumber_help',
    nonmember_pw_input:'form_2>#input_pw_2',
    nonmember_pw_help:'form_2>#pw_help',
    nonmember_login_btn:'form_2 button',

    admin_form:'form_3',
    admin_email_input:'form_3>#input_email_admin',
    admin_email_help:'form_3>#phonenumber_help',
    admin_pw_input:'form_3>#input_pw_admin',
    admin_login_btn:'form_3 button',

    a_find_id:'.login_info>span:nth-child(1)>a',
    a_find_pw:'.login_info>span:nth-child(2)>a',
    a_signup:'.login_info>span:nth-child(3)>a'
};
//loginAction 클래스 객체 준비
let loginAction;

$(document).ready(()=>{
    loginAction = new LoginAction();
    loginAction.initialize(id);

    $('.'+id.class_form+' .'+id.class_btn).on("click",(event)=>loginBtnHandler(event));
});


const loginBtnHandler = (event) => {
    let form_id = $(event.target).parent().attr('id');
    console.log("form_id: ",form_id);
    loginAction.loginBtnHandler(form_id);
};