import FillingTable from './table/FillingTable.js';

/*
    dom id 갑 부여.
*/
let id = {
    table:'table_reservation',
    p_above_table_span:'table_thisweeks'
};

const fillingTable = new FillingTable();

$('document').ready(function(){
    
    fillingTable.initiate(id);
    fillingTable.fillCircles();
    fillingTable.fillDayColumns();
    fillingTable.fillBarLabel();

});