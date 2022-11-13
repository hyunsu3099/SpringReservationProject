/**
 * DateObj{
 *  strInDay='yyyy-mm-dd';
    strforCol='MM/dd(월)';
 * } 식의 출력을 반환하는 클래스
 */
export default class DayColumns{
    startDate;

    /*오늘부터 6일 날짜 출력 */
    get6Days= function(){
        this.startDate = new Date();
        return this.get6DaysLoop();
    }

    /*전주 첫날 날짜입력('yyyymmdd') -> 6일후부터 날짜출력 */
    getNext6Days = function(firstDayOfPrev6Days){
        let tempdate = new Date(firstDayOfPrev6Days.substring(0,4)+'-'+
        firstDayOfPrev6Days.substring(4,6)+'-'+firstDayOfPrev6Days.substring(6,8));
        this.startDate = date.setDate(date.getDate() +6);
        return this.get6DaysLoop();
    }
    /*다음주 첫날 날짜입력('yyyymmdd') -> 6일전부터 6일 날짜출력  */
    getPrev6Days = function(firstDayOfNext6Days){
        let tempdate = new Date(firstDayOfPrev6Days.substring(0,4)+'-'+
        firstDayOfPrev6Days.substring(4,6)+'-'+firstDayOfPrev6Days.substring(6,8));
        this.startDate = date.setDate(date.getDate() +6);
        return this.get6DaysLoop();
    }


    /*6일치 str 배열 생성하는 루프 */
    get6DaysLoop = function(){

        let dates = [];
        let date = new Date(this.startDate);
		
		for(let i=0; i<6;i++){
			let dateObj = new DateObj(date);
			dates.push(dateObj);
            let tempdate = date.setDate(date.getDate() + 1);
		}

        return dates;
    }
}

class DateObj{
    

    constructor(currentdate){
        let date = new Date(currentdate);
        let month = date.getMonth() + 1;
        let day = date.getDate();
        const dayInKorean = getDayinKorean(date);
        this.strforCol = [month,'/', day, '(', dayInKorean,')'].join('');
        const year = date.getFullYear();
        this.strInDay = [year, leftPad(month), leftPad(day)].join('');
    }
}



// 요일 한글명 가져오기
let getDayinKorean = function(date){
    const week = ['일', '월', '화', '수', '목', '금', '토'];
    return week[date.getDay()];
}

// date 형식 1자리 수일때 앞자리 0 추가
let leftPad =function (value) {
    if (value >= 10) {return value;}
    return `0${value}`;
}