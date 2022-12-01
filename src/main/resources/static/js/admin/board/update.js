/**
 * update.js
 * 관리자계정의 게시판 업데이트페이지 요청처리
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-29, 최종수정 2022-12-2
 */

/**
 * dom id 객체 정리
 */
 const id = {
    btn_update: 'btn_update',
    btn_delete: 'btn_delete',
    btn_back: 'btn_back',
    post_id:'btn_update',
    form_title: 'post_title',
    form_content: 'post_content',
    publish: 'publish_chk'
};

/**
 * 이벤트 핸들러 부여 및 초기값 세팅
 */
$('document').ready(function(){
    $('#'+id.btn_update).on('click',putFcn);
    $('#'+id.btn_delete).on('click',deleteFcn);
    $('#'+id.btn_back).on('click',backHandler);
});

const putFcn = () =>{
    const id = $('#'+this.id.post_id).text();
    
    let publish_val = 0;
    if( $('#'+id.publish).is(':checked')) publish_val = 1; //체크박스 값 가져오기
    const data = {
        title: $('#'+id.form_title).val(),      //게시글제목
        content: $('#'+id.form_content).val(),  //게시글내용
    };

    $.ajax({
        type: 'PUT',
        url: "/admin/board/"+id,
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
const deleteFcn = () =>{

    const id = $('#'+this.id.post_id).text();

    $.ajax({
        type: 'DELETE',
        url: "/admin/board/"+id,
        async: false,
        //meta태그의 숨겨진 csrf 토큰을 가져옴
        headers: {
          'X-CSRF-TOKEN': $("meta[name='_csrf']").attr("th:content")
        },
        success: (response)=>{
            console.log(response);
        }   
    });
}
const backHandler = () =>{
    $(location).attr("href","/admin/board");
}