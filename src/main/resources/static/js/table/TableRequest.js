export default class TableRequest{
    
    //오늘날짜 기준으로 가져오기
    getStatus =function(){
        let data =[];

        $.ajax({
            type: "get",
            url: "/reservation/status",
            data:{firstday:""},
            async:false,
            success: function(response){
                let temp = JSON.parse(response);
                console.log(temp);
                for(let i=0; i<temp.length; i++){
                    data[i]=temp[i].status;
                }
            }
        });
        return data;
    }

    //첫 날짜가 있을때 'yyyymmdd 형'
    getResponse = function(dayStr){
        let data =[];
        $.ajax({
            type: "get",
            url: "/reservation/status",
            data:{firstday:dayStr},
            async:false,
            success: function(response){
                let temp = JSON.parse(response);
                console.log(temp);
                for(let i=0; i<temp.length; i++){
                    data[i]=temp[i].status;
                }
            }
        });
        return data;
    }
}