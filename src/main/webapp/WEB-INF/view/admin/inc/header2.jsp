<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>

<div class="header2">

    <div class="admin_list">
        <table>
            <tbody>
                <tr>
                    <td id="menu_reservation"><a href="/admin/reservation">예약관리</a></td>
                    <td id="menu_board"><a href="/admin/board">공지사항</a></td>
                    <td id="menu_introduction"><a href="/admin/introduction">서비스 소개</a></td>
                    <td id="menu_map"><a href="/admin/map">오시는 길</a></td>
                    <td id="menu_member"><a href="/admin/member">회원관리</a></td>
                    <td id="menu_db"><a href="/dev/db">db관리</a></td>
                </tr>
            </tbody>
        </table>
    </div>

    <div class="banner">
        <div></div>
        <div></div>
        <div><div><a href=""><i class="fa-solid fa-arrows-rotate"></i> 회원보기 전환 </a></div></div>
    </div>
    <script>
        $('.banner>div:nth-child(2)').append(currentViewName);
        $('.banner>div:nth-child(3) a').attr("href","/" + fieldid);
        $('#menu_'+fieldid).addClass("selected_item");
    </script>
</div>