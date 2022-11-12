<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<main>
    <div class="main_container">
        <!--logo넣는 곳-->
        <div class="main_signature_logo"><p></p></div>
        <!--웹페이지 설명-->
        <div class="main_desc">
            <p class="main_desc_en">This web page was built using the Spring Framework</p>
            <p class="main_desc_en">It was created to implement a reservation service</p>
            <p class="main_desc_kr">이 웹 페이지는 스프링 프레임워크를 이용해</p>
            <p class="main_desc_kr">예약 서비스를 구현하기 위해 만들어 졌습니다</p>
        </div>
        <!--표-->
        <div class="main_table_container">
            <!--열 설명용 표-->
            <div>
            <span style="display:inline;">
                <p> <!--한줄 띄우기--> </p>
                <table class="table_rowname">
                    <tbody>
                        <tr><td>A</td></tr>
                        <tr><td>B</td></tr>
                        <tr><td>C</td></tr>
                        <tr><td>D</td></tr>
                    </tbody>
                </table>
            </span>
            <!--예약페이지 표, js로 옆으로 가기 누를때에 다음표 만들기 구현하기-->
            <span style="display:inline;">
                <p>
                    <span class="">◀ </span>
                    <span class="table_header">11/12(월) ~ 11/17(목)</span>
                    <span class=""> ▶</span>
                </p>
                <table class="table_reservation">
                    <colgroup>
                        <!--6개 열-->
                        <col>
                        <col>
                        <col>
                        <col>
                        <col>
                        <col>
                    </colgroup>
                    <thead>
                        <tr>
                            <td>11/12(월)</td>
                            <td>11/13(화)</td>
                            <td>11/14(수)</td>
                            <td>11/15(목)</td>
                            <td>11/16(금)</td>
                            <td>11/17(토)</td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr><td> </td><td> </td><td> </td><td> </td><td> </td><td> </td></tr>
                        <tr><td> </td><td> </td><td> </td><td> </td><td> </td><td> </td></tr>
                        <tr><td> </td><td> </td><td> </td><td> </td><td> </td><td> </td></tr>
                        <tr><td> </td><td> </td><td> </td><td> </td><td> </td><td> </td></tr>
                    </tbody>
                </table>
            </span>
            </div>
            <!--index of 예약상태-->
            <div class="main_table_status">
                <span></span>
                <span> :예약가능</span>
                <span></span>
                <span> :예약임박</span>
                <span></span>
                <span> :예약임박</span>
            </div>
            

            <div class="main_table_label">
                <p>실시간 예약현황</p>
            </div>
        </div> <!--표 내용 끝-->
        
        <!--메뉴 내용들-->
        <div class="main_menu_container">
            <div class="main_menu_item" style="display:inline;">
                <div style="width:250px; height:200px; background-color:#ECC8D3;">box</div>
                <div>
                    <P>오시는길</p>
                    <P>Map</p>
                    <P>원하는날짜에 예약해 보세요</p>
                </div>
            </div>
            <div class="main_menu_item" style="display:inline;">
                <div style="width:250px; height:200px; background-color:#E9DDAE;">box</div>
                <div>
                    <P>예약하기</p>
                    <P>Reservation</p>
                    <P>원하는날짜에 예약해 보세요</p>
                </div>
            </div>
        </div>

    </div>    
</main>