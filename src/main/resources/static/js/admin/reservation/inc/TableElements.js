import DayColumns from '../../../table/DayColumns.js';
import AdminRequest from './AdminRequest.js';

/**
 * TableElements.js
 * 테이블 구성요소를 업데이트하는 파일
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-12-22, 최종수정 2022-12-22
 */

export default class TableElements{

    /*dom id */
    id={};

    values={
        dateObjs:[],
        result:[],
        result_len: 0
    };

    dayColumns;

    /** 날짜 채우기 */
    fillContents = () =>{
        const selectorTagPrefix = this.id.table_tbody_selector;
        let result =[];

        const $div_round_box = $("<div>",{attr:{class:"round_box"}});
        const $table = $("<table>",{});
        const $tr = $("<tr>",{});
        const $td1 = $("<td>",{text:"<div>9:00~12:00</div>"});
        const $td2 = $("<td>",{text:"방법2"});
        const $td3 = $("<td>",{text:"<td><div>예약가능</div></td>"});
        
        $tr.append($td1);
        $tr.append($td2);
        $tr.append($td3);

        const date_len = 6;

        for(let i=0; i<this.values.result_len; i++){

            const j=parseInt(i/date_len);
            const k=i%date_len;

            const tempSelectorTag = selectorTagPrefix + ` tr:nth-child(${j+1})>td:nth-child(${k+1})`;

            $div_round_box.append($table);
            $table.append($tr);
            $(tempSelectorTag).append($div_round_box);

            
        }

        /* 각예약 Column에 예약 상태를 집어 넣는다. */
        for(let i=0; i<4;i++){for(let j=0; j<6;j++){
            let temp_html = `<div class='${this.values.circle_class[result[i*6+j]]}'></div>`;
            let tempSelectorTag = selectorTagPrefix+`>tr:nth-child(${i+1})>td:nth-child(${j+1})`;
            $(tempSelectorTag).empty();
            $(tempSelectorTag).append(temp_html);
        }}
        
    }

    /** 날짜 채우기 */
    fillDateColumns = () => {
        let tempstartpoint = this.values.dateObjs.length -6;
        const selectorTagPrefix = this.id.table_thead_selector;
        for(let i=0; i<6;i++){
            let tempSelectorTag = selectorTagPrefix+` td:nth-child(${i+1})`;
            $(tempSelectorTag).empty();
            $(tempSelectorTag).text(this.values.dateObjs[tempstartpoint + i].strforCol);
        }
        let tempSelectorTag = this.id.table_moveheader_selector + ' .table_header';
        $(tempSelectorTag).empty();
        const head_text = this.values.dateObjs[0].strforCol + ' ~ ' + this.values.dateObjs[5].strforCol ;
        $(tempSelectorTag).text(head_text);
    
    }


    initialize = (id) => {
        this.id = id;
        this.dayColumns= new DayColumns();
        this.values.dateObjs = this.dayColumns.get6Days();

        this.fillDateColumns();

        try{ 
            const result=new AdminRequest().getStatus(this.values.dateObjs[0]);

            this.values.result = result.result;
            this.values.result_len = result.len;
        }catch(e){console.log('아직request가 준비되지 않음:');}
    }
}