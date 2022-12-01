<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<main>
    <div class="index_container">
        <!--logo넣는 곳-->
        <div class="index_signature_logo"><p></p></div>
        <!--웹페이지 설명-->
        <div class="index_desc">
            <div class="index_desc_en"><span>This web page was built using the Spring Framework</span></div>
            <div class="index_desc_en"><span>It was created to implement a reservation service</span></div>
            <div class="index_desc_kr"><span>이 웹 페이지는 스프링 프레임워크를 이용해</span></div>
            <div class="index_desc_kr"><span>예약 서비스를 구현하기 위해 만들어 졌습니다</span></div>
        </div>
        <!--표-->
        <div class="index_table_container">
            <!--열 설명용 표-->
            <div class="index_table_tables">
                <div>
                    <p> <!--한줄 띄우기--> </p>
                    <table class="table_rowname">
                        <thead><tr><td> &nbsp</td></tr></thead>
                        <tbody>
                            <tr><td>A</td></tr>
                            <tr><td>B</td></tr>
                            <tr><td>C</td></tr>
                            <tr><td>D</td></tr>
                        </tbody>
                    </table>
                </div>
            <!--예약페이지 표, js로 옆으로 가기 누를때에 다음표 만들기 구현하기-->
            <div> 
            <ul class="index_table_items" id="index_table_items" >
                    <li class="index_table_item" id="index_table_item_1">
                        
                        <div class="hidden"></div>
                        <p>
                            <span class="left" ><a>◀ </a></span>
                            <span class="table_header">11/12(월) ~ 11/17(목)</span>
                            <span class="right" ><a> ▶</a></span>
                        </p>
                        <table class="table_reservation">
                            <!--6개 열-->
                            <colgroup><col> <col><col><col><col><col></colgroup>
                            <thead>
                                <tr><td>11/12(월)</td><td>11/13(화)</td><td>11/14(수)</td><td>11/15(목)</td><td>11/16(금)</td><td>11/17(토)</td></tr>
                            </thead>
                            <tbody><!-- 총 6 * 4 개 칼럼-->
                                <tr><td> </td><td> </td><td> </td><td> </td><td> </td><td> </td></tr>
                                <tr><td> </td><td> </td><td> </td><td> </td><td> </td><td> </td></tr>
                                <tr><td> </td><td> </td><td> </td><td> </td><td> </td><td> </td></tr>
                                <tr><td> </td><td> </td><td> </td><td> </td><td> </td><td> </td></tr>
                            </tbody>
                        </table>
                    </li>
                </ul>
            </div>
            </div>
        
            <!--index of 예약상태-->
            <div class="index_table_legend">
                <div class="green_circle small_circle"></div>
                <span> :예약가능</span>
                <div class="yellow_circle small_circle"></div>
                <span> :예약임박</span>
                <div class="grey_circle small_circle"></div>
                <span> :예약마감</span>
            </div>
            

            <div class="index_table_label">
                <div>실시간 예약현황</div>
                <div>Reservation</div>
                <div class="label_desc">
                <div >예약가능 날짜를 확인하세요</div>
                <div>마우스를 올리면 잔여예약시간을 확인할 수 있습니다
                </div></div>
            </div>
        </div> <!--표 컨테이너 내용 끝-->
        
        
        <!--메뉴 내용들-->
        <div class="index_menu_container">
            <div class="index_menu_item" id="item1">
                <div class="white_box">
                    <div style="background-color:#ECC8D3;"><a><img src="/images/menues/reservation.png"></a></div>
                </div>
                <div>
                    <div><a>예약하기</a></div>
                    <div><a>Reservation</a></div>
                    <div><a>원하는날짜에 예약해 보세요</a></div>
                </div>
            </div>
            <div class="index_menu_item" id="item2">
                <div class="white_box">
                    <div style="background-color:#E9DDAE;"><a><img src="/images/menues/map.png"></a></div>
                </div>
                <div>
                    <div><a>오시는길</a></div>
                    <div><a>Map</a></div>
                    <div><a>위치를 확인하세요</a></div>
                </div>
            </div>
            <div class="index_menu_item"id="item3">
                <div class="white_box">
                    <div style="background-color:#ECC8D3;"> <a><img src="/images/menues/board.png"></a> </div>
                </div>
                <div>
                    <div><a>공지사항</a></div>
                    <div><a>Board</a></div>
                    <div><a>공지사항 내용을 확인하세요</a></div>
                </div>
            </div>
            <div class="index_menu_item" id="item4">
                <div class="white_box">
                    <div style="background-color:#ECC8D3;">
                        <a><img src="/images/menues/introduction.png"></a>
                    </div>
                </div>
                <div>
                    <div><a>서비스소개</a></div>
                    <div><a>Service</a></div>
                    <div><a>이 웹사이트의 서비스를 소개합니다.</div></p>
                </div>
            </div>
        </div>

        <script>
            $(".index_menu_container>#item1 a").attr('href','/reservation');
            $(".index_menu_container>#item2 a").attr('href','/map');
            $(".index_menu_container>#item3 a").attr('href','/board');
            $(".index_menu_container>#item4 a").attr('href','/introduction');
        </script>

    </div>    
</main>