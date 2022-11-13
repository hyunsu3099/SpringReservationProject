import FillingTable from './table/FillingTable.js';
import LoadSideTables from './table/LoadSideTables.js';

/*
    dom id 값 부여.
*/

let id = {
    ul:'index_table_items',
    li:'index_table_item_1',
    li_class:'index_table_item',
    li_table_class:'table_reservation',
    li_p_span_class:'table_header'
};

const fillingTable = new FillingTable();
const loadSideTables = new LoadSideTables();

$('document').ready(function(){
    
    loadSideTables.initiate(id);
    fillingTable.initiate(id);
    fillingTable.fillCircles();
    fillingTable.fillDayColumns();
    fillingTable.fillBarLabel();

    $('.left>a').on("click", getLeftTable);
    $('.right>a').on("click", getRightTable);
});

let getLeftTable = function(){
    let tabledata = loadSideTables.createTable(-1);
    if(tabledata.status==1){
        fillingTable.newData(tabledata);
    }
}
let getRightTable = function(){
    let tabledata = loadSideTables.createTable(1);
    if(tabledata.status==1){
        fillingTable.newData(tabledata);
    }
}