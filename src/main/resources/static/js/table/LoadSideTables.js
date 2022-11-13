import TableRequest from "./TableRequest.js";
import DayColumns from "./DayColumns.js";

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
        console.log(tempDayStr);
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

            const temp_html= `<li id="${newId}" class="${this.id.clone_name}"></li>`;;
            if(funcNum>0){
				$('#'+this.id.ul).append(temp_html);
			}else{
				$('#'+this.id.ul).prepend(temp_html);
			}

            $('#'+newId).append(clone);
        }

        let response;
        try{ response = tableRequest.getResponse()}
        catch{}
        return new tableDatas(newId, data, response, status);
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