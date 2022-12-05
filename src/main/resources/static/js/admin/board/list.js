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
    create_btn: 'btn_create',
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
    $('#'+id.create_btn).on('click',createHandler);
});

// 리스트 페이지가 업로드 되었을떄, publish 체크박스 상태를 확인
// 각 게시글의 id를 values.num에,
// 각 게시글의 publish를 values.publish에 입력
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

const createHandler = () =>{
    $(location).attr("href", "/admin/board/write");
}

// 리스트 페이지에서, 업데이트 버튼을 눌렀을 때 호출,
// patch /admin/board/{ids} 요청 
// ids: 수정할 아이디 목록 ex) "1,3,4"
const updateFcn = () => {
    let nums = values.num;
    let publish = values.publish;

    let updateIds = [];

    //체크박스 상태가 초기상태와 변했는지를 확인
    //체크박스 상태가 변한 id 값만 patch 요청
    for(let i in nums){
        if( $('#'+id.publish_chk_head + nums[i]).is(':checked') != publish[i]) {
            updateIds.push( nums[i] ); 
        }
    }

     //체크박스 상태가 변한 경우가 있을 때만 ajax 요청
    if(updateIds.length>0){
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
    
}


const deleteFcn = () => {
    let deleteIds = [];

    for(let i in nums){
        if( $('#'+id.delete_chk_head + nums[i]).is(':checked') ) {
            deleteIds.push( nums[i] ); 
        }
    }
    
    if(deleteIds.length>0){
        const idsStr =deleteIds.join(',');

        $.ajax({
            type: 'DELETE',
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
}

