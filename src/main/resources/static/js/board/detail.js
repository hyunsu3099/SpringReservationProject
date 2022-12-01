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
    btn_back: 'btn_back',
};

/**
 * 이벤트 핸들러 부여 및 초기값 세팅
 */
$('document').ready(function(){
    $('#'+id.btn_back).on('click',backHandler);
});
const backHandler = () =>{
    $(location).attr("href","/admin/board");
}