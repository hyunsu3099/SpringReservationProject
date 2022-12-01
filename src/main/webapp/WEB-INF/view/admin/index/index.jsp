<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<main>
    <div class="index_container">
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