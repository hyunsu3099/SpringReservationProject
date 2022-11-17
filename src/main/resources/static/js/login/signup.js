/**
* 
* 
*/
import SignupAction from './signupstep/SignupAction.js';

//dom id
let id={
    email_input:"input_email",
    pw_input:"input_pw",
    pwchk_input:"input_pw_chk",
    name_input:"input_name",
    phone_input:"input_phone",

    email_help:"email_help",
    pw_help:"pw_help",
    pwchk_help:"pw_chk_help",
    name_help:"name_help",
    phone_help:"phone_help",

    btn:"btn"
};

let signupAction;
 
$(document).ready(()=>{
    signupAction = new SignupAction();
    signupAction.initialize(id);
    
});
 
 
const signupBtnHandler = () => {
}; 