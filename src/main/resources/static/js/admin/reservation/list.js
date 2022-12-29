import Request from './inc/Request.js';
import TableElements from './inc/TableElements.js';

/**
 * list.js
 * 관리자계정의 예약 리스트 페이지
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-12-20, 최종수정 2022-12-20
 */

/**
 * dom id 객체 정리
 */
 const id = {
    table : 'table_reservation',
    reservation_box_class : 'round_box',
    table_tbody_selector: '.table_reservation>tbody',
    table_thead_selector: '.table_reservation>thead>tr',
    table_moveheader_selector: '.table_container>div:nth-child(2)>div>div'
}

const tableElements = new TableElements();


$('document').ready(function(){
    boxClickHandler();

    tableElements.initialize(id);

});



const boxClickHandler = () => {
    
    $('.'+id.reservation_box_class).on("click", function(e){
        if($(this).hasClass('box_enabled')){
            $(this).removeClass('box_enabled');
        }else{
            $(this).addClass('box_enabled');
        }
    })

}