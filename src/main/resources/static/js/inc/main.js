
const isAdmin = () =>{
    let isAdmin = false;
    $.ajax({
        type: 'GET',
        url: "/auth/isAdmin",
        headers: {'X-CSRF-TOKEN': $("meta[name='_csrf']").attr("th:content")},
        async: false,
        success: (response)=>{
            let data = JSON.parse(response);
            data = data.result[0];
            isAdmin = data.isAdmin;
        }   
    });
    return isAdmin;
}