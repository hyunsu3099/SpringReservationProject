<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<div class="header2">
    <div class="admin_list">
        <table>
            <tbody>
                <tr>
                    <td id="menu_reservation"><a href="/reservation">예약</a></td>
                    <td id="menu_board"><a href="/board">공지사항</a></td>
                    <td id="menu_introduction"><a href="/introduction">서비스 소개</a></td>
                    <td id="menu_map"><a href="/map">오시는 길</a></td>
                </tr>
            </tbody>
        </table>
    </div>

    <div class="banner">
        <div></div>
        <div></div>
        <div><div class="hidden"> <a href=""><i class="fa-solid fa-arrows-rotate"></i>관리자 뷰 전환</a></div></div>
    </div>
    <script>
        $('.banner>div:nth-child(2)').append(currentViewName);
        if(isAdmin()) $('.banner>div:nth-child(3) div').removeClass("hidden");
        $('.banner>div:nth-child(3) a').attr("href","/admin/" + fieldid);
        $('#menu_'+fieldid).addClass("selected_item");
    </script>
</div>