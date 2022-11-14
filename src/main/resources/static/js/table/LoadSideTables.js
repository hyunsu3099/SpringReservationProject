import DayColumns from './DayColumns.js';
import TableRequest from './TableRequest.js';

export default class LoadSideTables{
    //dom 객체
    id = {};
    
    values = {
        //현재 테이블 위치,
        tablePos: 0,
        //준비된 테이블 목록
        tableReady:[0]
    }
    //DayColumns 클래스, TableRequest 클래스,
    dayColumns;
    tableRequest;


    createTable = function(num){
        let funcNum = parseInt(num);

        let currentTablePos = this.values.tableReady.indexOf(this.values.tablePos)+1 ;
        const tempSelectorTag = '#'+this.id.li_class+'_'+currentTablePos;
        let tempDayStr = $(tempSelectorTag +' .hidden').text();

        //dayColumns을 통해 6일 칼럼 얻기
        let data;
        if(funcNum>0){data = this.dayColumns.getNext6Days(tempDayStr);
        }else{data = this.dayColumns.getPrev6Days(tempDayStr);}

        //right: +1, left:-1
        let tablePos = this.values.tablePos+ funcNum;
        this.values.tablePos = tablePos;

        //현재 위치에 테이블이 만들어져있지 않으면 테이블 생성
        let status=0;
        let newId = this.id.li_class+'_';

        if(this.values.tableReady.includes(tablePos)){
            newId += this.values.tableReady.indexOf(tablePos)+1; 
        }
        else{
            this.values.tableReady.push(tablePos);status=1;

            const clone = $('#'+this.id.li).html(); //li tag 하위복제
            newId += this.values.tableReady.length;
            const temp_html= `<li class="${this.id.li_class}" id="${newId}" ></li>`;;
            if(funcNum>0){
				$('#'+this.id.ul).append(temp_html);
			}else{
				$('#'+this.id.ul).prepend(temp_html);
			}

            $('#'+newId).append(clone);
        }


        let response;
        try{ response = tableRequest.getResponse(data[0].strInDay)}
        catch{}
        this.id.li = newId;

        return new tableDatas(newId, data, response, status);
    }

    transform = function(){
        const minPos = this.values.tableReady.reduce((previous, current) => { 
            return previous > current ? current:previous;
        });
        const currentPos = this.values.tablePos-minPos;
        if(currentPos==0 && this.values.tablePos<0){ 
            let promise = new Promise((resolve, reject) => {
                $('#'+this.id.ul +' >.'+this.id.li_class).css('transition','');
                $('#'+this.id.ul +' >.'+this.id.li_class).css('transform','translateX(-100%)');
            });
                $('#'+this.id.ul +' >.'+this.id.li_class).css('transition','.3s');
        }
        setTimeout(() => {
            $('#'+this.id.ul +' >.'+this.id.li_class).css('transform',`translateX(${-100*currentPos}%)`);
        },100);
    }

    constructor(){
        this.dayColumns = new DayColumns();
        this.tableRequest = new TableRequest();
    }
    initiate = function(id){
        this.id = id;
    }
}

/**
 * Filling Table로 넘겨줄 객체
 */
class tableDatas{
    id;
    dateObjs;
    result;
    status; //0:생성안됨, 1 생성됨
    constructor(id, dateObjs, result, status){
        this.id = id;
        this.dateObjs = dateObjs;
        this.result = result;
        this.status = status
    }
}