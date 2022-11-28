<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<main>
    <div>
        <!--메뉴 내용들-->
        <div class="index_menu_container">
            <ul>
                <li id="item1"><span><a>예약관리</a></span></li>
                <li id="item2"><span><a>공지사항</a></span></li>
                <li id="item3"><span><a>회원관리</a></span></li>
            </ul>
        </div>

        <script>
            $(".index_menu_container #item1 a").attr('href','/admin/reservation');
            $(".index_menu_container #item2 a").attr('href','/admin/board');
            $(".index_menu_container #item3 a").attr('href','/admin/member');
        </script>

    </div>    
</main>