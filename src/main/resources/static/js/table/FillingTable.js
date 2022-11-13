import TableRequest from './TableRequest.js'

/*표 내용을 채워줄 클래스*/
export default class FillingTable{

    /* dom id 객체 */
    id ={};

    /* */
    values = {
        circle_class:["grey_circle","green_circle","yellow_circle"],
        status:[0,1,2],
        dayColumns:[]
    }

    /* table request 객체 */
    tableRequest;

    fillCircles = function(){
        let selectorTagPrefix = '#' + this.id.table +'>tbody';

        /* 6일 * 4방 24칸을 채울 어레이*/
        let result = new Array(24);
        for(let i=0; i<24;i++){result[i]=0;}
        /* request에 실패 할경우 다 흑색 원 방출 */
        try{
            result = tableRequest.getStatus();
        }catch(e){
            console.log('아직request가 준비되지 않음:',e);
        }

        /* 각예약 Column에 예약 상태를 집어 넣는다. */
        for(let i=0; i<24;i++){
            let temp_html = `<div class='${this.values.circle_class[result[i]]}'></div>`;
            let tempSelectorTag = selectorTagPrefix+` td:nth-child(${i+1})`;
            $(tempSelectorTag).append(temp_html);
        }

    }

    initiate =function(id){
        this.id=id
        this.tableRequest= new TableRequest();
    };
}