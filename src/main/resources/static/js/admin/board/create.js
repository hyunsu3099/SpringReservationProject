/**
 * create.js
 * 관리자계정의 게시판 글쓰기페이지 create 요청처리
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-29, 최종수정 2022-11-29
 */
const id = {
    form_title: 'post_title',
    form_content: 'post_content',
    writer_name: 'writer_name',
    btn_upload: 'btn_upload',
    publish: 'publish_chk'
};


$('document').ready(function(){
    $('#'+id.btn_upload).on('click',submit);
    $('#'+id.writer_name).empty();
    $('#'+id.writer_name).text(getUserName());
});


const submit = ()=>{
    let publish_val = 0;
    if( $('#'+id.publish).is(':checked')) publish_val = 1;
    const data = {
        userName: $('#'+id.writer_name).text(),
        title: $('#'+id.form_title).val(),
        content: $('#'+id.form_content).val(),
        publish: publish_val
    };
    console.log(data);
    $.ajax({
        type: 'POST',
        url: "/admin/board",
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(data),
        cache : false,
        //meta태그의 숨겨진 csrf 토큰을 가져옴
        headers: {
          'X-CSRF-TOKEN': $("meta[name='_csrf']").attr("th:content")
        },
        success: (response)=>{
            console.log(response);
        }   
    });
} 

const getUserName = () => {
    let name="ananymous";

    $.ajax({
        type: 'GET',
        url: "/auth/name",
        headers: {
          'X-CSRF-TOKEN': $("meta[name='_csrf']").attr("th:content")
        },
        async: false,
        success: (response)=>{
            let data = JSON.parse(response);
            data = data.result[0];
            name = data.name;
        }   
    });
    return name;
}

