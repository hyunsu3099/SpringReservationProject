/**
 * list.js
 * 관리자계정의 게시판 목록 페이지 요청처리
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-29, 최종수정 2022-11-29
 */
 const id = {
    update_btn: 'btn_update',
    delete_btn: 'btn_delete',
    publish_chk_head: 'publish_',
    delete_chk_head: 'delete_',
    class_post_num: 'post_num'
};

let values ={
    num: {},
    publish: {},
    delete: {}
}


$('document').ready(function(){

    initialStatus();

    $('#'+id.update_btn).on('click',updateFcn);
    $('#'+id.delete_btn).on('click',deleteFcn);
});

const initialStatus = ()=>{

    let nums= [];
    let publish = [];

    $('.'+id.class_post_num).each(function(index,item){
        nums.push( $(item).text() )
    });

    for(let num of nums){
        publish.push ($('#'+id.publish_chk_head + num).is(':checked') ) ;
    }

    values.num = nums;
    values.publish = publish;
}


const updateFcn = () => {
    let nums = values.num;
    let publish = values.publish;

    let updateIds = [];

    for(let i in nums){
        if( $('#'+id.publish_chk_head + nums[i]).is(':checked') != publish[i]) {
            updateIds.push( nums[i] ); 
        }
    }

    const idsStr =updateIds.join(',');
    $.ajax({
        type: 'PATCH',
        url: "/admin/board/"+idsStr,
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

const deleteFcn = () => {

}

