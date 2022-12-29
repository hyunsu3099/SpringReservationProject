
/* */
export default class AdminRequest{

    getStatus = () => {
        let result =[];

        $.ajax({
            type: "GET",
            url: "/admin/reservation/status",
            async:false,
            success: function(response){
                
                result = {
                    result: response,
                    len: result.length
                };
            }
        });
        return result;
    }

}