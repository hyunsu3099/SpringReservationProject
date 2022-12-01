/**
 * create.js
 * 관리자계정의 게시판 글쓰기페이지 create 요청처리
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-29, 최종수정 2022-12-2
 */

/**
 * dom id 객체 정리
 */
const id = {
    form_title: 'post_title',
    form_content: 'post_content',
    writer_name: 'writer_name',
    btn_upload: 'btn_upload',
    btn_back: 'btn_back',
    publish: 'publish_chk'
};

/**
 * 이벤트 핸들러 부여 및 초기값 세팅
 */
$('document').ready(function(){
    $('#'+id.btn_upload).on('click',submit);
    $('#'+id.writer_name).empty();
    $('#'+id.writer_name).text(getUserName());
    $('#'+id.btn_back).on('click',backHandler);
});


/**
 * 업로드 버튼 누를 시, post 요청 ajax 보내기
 */
const submit = ()=>{
    let publish_val = 0;
    if( $('#'+id.publish).is(':checked')) publish_val = 1; //체크박스 값 가져오기
    const data = {
        userName: $('#'+id.writer_name).text(), //유저이름
        title: $('#'+id.form_title).val(),      //게시글제목
        content: $('#'+id.form_content).val(),  //게시글내용
        publish: publish_val                    //게시상태
    };

    $.ajax({
        type: 'POST',
        url: "/admin/board",
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(data),
        cache : false,
        async : false,
        headers: {'X-CSRF-TOKEN': $("meta[name='_csrf']").attr("th:content")},
        success: (response)=>{
            console.log(response);
        }   
    });
} 

/**
 * 서버에, 로그인되어있는 작성자이름 요청하기
 */
const getUserName = () => {
    let name="ananymous"; // 초기 작성자이름

    $.ajax({
        type: 'GET',
        url: "/auth/name",
        headers: {'X-CSRF-TOKEN': $("meta[name='_csrf']").attr("th:content")},
        async: false,
        success: (response)=>{
            let data = JSON.parse(response);
            data = data.result[0];
            name = data.name;

            $(location).attr("href","/admin/board");
        }   
    });
    return name;
}

const backHandler = () =>{
    $(location).attr("href","/admin/board");
}
