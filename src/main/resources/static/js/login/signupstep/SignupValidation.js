/**
 * 
 * 
 */
 export default class SignupValidation{

    id={};

    status = {
        isEmailValid: false,
        isPwValid: false,
        pwChk: false,
        isNameValid: false,
        isPhoneValid: false,
        message:{
            email: '',
            pw: '',
            pwChk: '',
            name: '',
            phone: ''
        }
    };
    
    isEmailValid = (value) => {
        const usingLengthMax = !(/.{,100}/.test(value));
        const emailValid = (/\w+@\w+([-.]\w+)*\.[a-zA-Z]{2,4}$/.test(value));
        const usingSpace = !(/\s/.test(value));

        if(!usingLengthMax) { this.status.isEmailValid=false; this.status.message.email="100자 이하로 적어주세요"; return false;}

        if(!emailValid) { this.status.isEmailValid=false; this.status.message.email="이메일 형식을 확인해주세요"; return false;}

        if(!usingSpace) { this.status.isEmailValid=false; this.status.message.email="사용할 수 없는 문자가 포함되어 있습니다 (공백)"; return false;}

        this.status.isEmailValid=true;
        this.status.message.email="";
        return true;
    };

    isPwValid = (value) => {
        const usingLengthMin = (/.{4}/.test(value));
        const usingSpace = !(/\s/.test(value));

        if(!usingLengthMin) { this.status.isPwValid=false; this.status.message.pw="비밀번호를 4자 이상 입력해주세요"; return false;}

        if(!usingSpace) { this.status.isPwValid=false; this.status.message.pw="사용할 수 없는 문자가 포함되어 있습니다 (공백)";return false;}

        this.status.isPwValid=true;
        this.status.message.pw ="";
        return true;
    };

    pwChk = (value) => {

        if(value != $('#'+this.id.pw_input).val()) { this.status.pwChk=false; this.status.message.pwChk="비밀번호가 일치하지 않습니다.";return false;}

        this.status.pwChk=true;
        this.status.message.pwChk="";
        return true;
    };

    isNameValid = (value) => {
        const usingLengthMin = (/.{2,}/.test(value));
        const nameValid = !(/.*[\d\!\@\#\$\%\^\&\*].*/.test(value));

        if(!usingLengthMin) {this.status.isNameValid=false; this.status.message.name="이름을 2자이상 입력해주세요";return false;}

        if(!nameValid) { this.status.isNameValid=false; this.status.message.name="사용할 수 없는 문자가 포함되어 있습니다.";return false;}

        this.status.isNameValid=true;
        this.status.message.name="";
        return true;
    };

    isPhoneValid = (value) => {
        const phoneValid = (/.\d{2,3}-\d{3,5}-\d{4}/.test(value));

        if(phoneValid) this.status.isPhoneValid=true;
        else{ this.status.isPhoneValid=false; this.status.message.phone="전화번호 형식을 확인해 주세요";return false;}

        this.status.message.phone="";
        return true;
    };


    initialize = (id) => {
        this.id=id;
    };
}