import TableRequest from './TableRequest.js';
import DayColumns from './DayColumns.js';

/*표 내용을 채워줄 클래스*/
export default class FillingTable{

    /* dom id 객체 */
    id ={};

    /* */
    values = {
        circle_class:["grey_circle","yellow_circle","green_circle"],
        status:[0,1,2],
        dateObjs:[], //{호출카운트:날짜 str 배열}로 객체
        count: 1, //호출 카운트
        result:[]
    }

    /* table request, DayColumns 객체 */
    tableRequest;
    dayColumns;

    /** 열채우기 */
    fillDayColumns = function(){
        let tempstartpoint = this.values.dateObjs.length -6;
        let selectorTagPrefix = '#' + this.id.li +' thead';
        for(let i=0; i<6;i++){
            let tempSelectorTag = selectorTagPrefix+` td:nth-child(${i+1})`;
            $(tempSelectorTag).empty();
            $(tempSelectorTag).text(this.values.dateObjs[tempstartpoint + i].strforCol);
        }
    }
     /** 테이블 위 날자 업데이트 */
    fillBarLabel(){
        let tempstartpoint = this.values.dateObjs.length -6;
        let tempSelectorTag = '#'+this.id.li+' .' + this.id.li_p_span_class;
        let temp_text = this.values.dateObjs[tempstartpoint].strforCol + ' ~ '
        + this.values.dateObjs[tempstartpoint+5].strforCol;
        
        console.log('tempSelectorTag:', tempSelectorTag);
        $(tempSelectorTag).empty();
        $(tempSelectorTag).text(temp_text);
        $('#'+this.id.li+ '> .hidden').empty();
        $('#'+this.id.li+ '> .hidden').text(this.values.dateObjs[tempstartpoint].strInDay);
    }

    /**테이블에 동그라미 채우기*/
    fillCircles = function(){
        let selectorTagPrefix = '#' + this.id.li +' tbody';
        let result =[];
        /* 6일 * 4방 24칸을 채울 어레이*/
        if(this.values.result.length<24){
            result = new Array(24);
            for(let i=0; i<24;i++){result[i]=0;}
        }else{
            result =this.values.result;
        }
        /* 각예약 Column에 예약 상태를 집어 넣는다. */
        for(let i=0; i<4;i++){for(let j=0; j<6;j++){
            let temp_html = `<div class='${this.values.circle_class[result[i*6+j]]}'></div>`;
            let tempSelectorTag = selectorTagPrefix+`>tr:nth-child(${i+1})>td:nth-child(${j+1})`;
            $(tempSelectorTag).empty();
            $(tempSelectorTag).append(temp_html);
        }}
        
    }

    /* */
    newData = function(tableDatas){
        console.log(tableDatas);
        this.id.li =tableDatas.id;
        this.values.result.push(tableDatas.result) ;
        this.values.dateObjs = this.values.dateObjs.concat([],tableDatas.dateObjs);

        this.fillCircles();
        this.fillDayColumns();
        this.fillBarLabel();
    }
    initiate =function(id){
        this.id=id;
        this.dayColumns= new DayColumns();
        this.values.dateObjs = this.dayColumns.get6Days();
        try{ this.values.result =new TableRequest().getStatus(this.values.dateObjs[0]);}
        catch(e){console.log('아직request가 준비되지 않음:');}
    };
}
