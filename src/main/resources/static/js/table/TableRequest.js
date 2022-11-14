export default class TableRequest{

    //오늘날짜 기준으로 가져오기
    getStatus =function(){
        let data;

        $.ajax({
            type: "get",
            url: "reservation/status",
            data:{},
            success: function(response){
                data = response.data;
            }
        });
        return data;
    }

    //첫 날짜가 있을때 'yyyymmdd 형'
    getResponse = function(dayStr){
        let data;
        $.ajax({
            type: "get",
            url: "reservation/status",
            data:{firstday:dayStr},
            success: function(response){
                data = response.data;
            }
        });
        return data;
    }
}