/**
 * LoginValidation.js
 * 로그인 입력 정보 검증
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-16, 최종수정 2022-11-25
 */
export default class LoginValidation{

    /**
     * dom id 객체
     */
    id={};

    status = {
        isEmailValid: false,
        isPwValid: false,
        message:{
            email: '',
            pw: ''
        }
    };
    
    //이메일 확인
    isEmailValid = (value) => {
        //100자 이하로
        const usingLengthMax = !(/.{100}/.test(value));
        //이메일 형식확인
        const emailValid = (/\w+@\w+([-.]\w+)*\.[a-zA-Z]{2,4}$/.test(value));
        //공백문자 확인
        const usingSpace = !(/\s/.test(value));

        if(!usingLengthMax) { this.status.isEmailValid=false; this.status.message.email="100자 이하로 적어주세요"; return false;}

        if(!emailValid) { this.status.isEmailValid=false; this.status.message.email="이메일 형식을 확인해주세요"; return false;}

        if(!usingSpace) { this.status.isEmailValid=false; this.status.message.email="사용할 수 없는 문자가 포함되어 있습니다 (공백)"; return false;}

        this.status.isEmailValid=true;
        this.status.message.email="";
        return true;
    };

    //패스워드 검증
    isPwValid = (value) => {
        //4자 이상인지 확인
        const usingLengthMin = (/.{4}/.test(value));
        //공백이 있는지 확인
        const usingSpace = !(/\s/.test(value));

        if(!usingLengthMin) { this.status.isPwValid=false; this.status.message.pw="비밀번호를 4자 이상 입력해주세요";return false;}

        if(!usingSpace) { this.status.isPwValid=false; this.status.message.pw="사용할 수 없는 문자가 포함되어 있습니다 (공백)";return false;}

        this.status.isPwValid=true;
        this.status.message.pw="";
        return true;
    };

    //전화번호 확인
    isPhoneValid = (value) => {

        //전화번호 형식 확인
        const phoneValid = (/.\d{2,3}-\d{3,5}-\d{4}/.test(value));

        if(!phoneValid) { this.status.isEmailValid=false; this.status.message.email="전화번호 형식을 확인해 주세요 000-0000-0000";return false;}

        this.status.isEmailValid=true; this.status.message.email="";
        return true;
    };


    initialize = (id) => {
        this.id=id;
    };
}