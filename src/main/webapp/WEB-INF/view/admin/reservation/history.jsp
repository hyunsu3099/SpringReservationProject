<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<main>
    <div class="reservation_history_container">

        <div class="reserv_page_link">
            <span id="list">
                <a href="/admin/reservation/list">일자별 예약상태보기</a>
            </span>
            <span id="history" class="selected_item">
                <a href="/admin/reservation/history">기록보기</a>
            </span>
        </div>

        <div>history</div>
        <div class="white_box">

            <div class="searchbar">
                <select class="form-select" aria-label="Default select example">
                    <option selected value="1">제목</option>
                    <option value="2">작성자</option>
                    <option value="3">날짜</option>
                </select>

                <input class="input_search" type="text" >

                <button type="button" class="btn btn-outline-dark">검색</button>
            </div>

            <div class="table_container">
                
                <table class="table_reservation">
                    <!--6개 열-->
                    <colgroup>
                        <col width="3%">
                        <col width="23%">
                        <col width="28%">
                        <col width="9%">
                        <col width="15%">
                        <col width="10%">
                        <col width="8%">
                        <col width="5%">
                    </colgroup>
                    <thead>
                        <tr>
                            <td></td>
                            <td>예약시간</td>
                            <td>예약일·예약상세</td>
                            <td>이름</td>
                            <td>계정</td>
                            <td>상태</td>
                            <td><div><button class="btn btn-secondary" type="button" id="btn_delete">전체선택</button></div></td>
                            <td></td>
                        </tr>
                    </thead>
                    <tbody><!-- 총 6 * 4 개 칼럼-->
                        <tr></tr>
                        <c:forEach var="i" begin="1" end="22">
                            <tr>
                                <td></td>
                                <td>2022-12-11/11:10 </td>
                                <td>2022-12-20 / A / 11:10</td>
                                <td>yzhs</td>
                                <td>test@yzhs.go</td>
                                <td>예약됨</td>
                                <td><input class="form-check-input" type="checkbox" value="" id="flexCheckDefault"></td>
                                <td></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </div><!-- table container 끝-->

            <div></div><!-- tabler bottom border-->

            <div class="submit_buttons">
                <div>선택한 목록을</div>
                <div><button type="button" class="btn btn-secondary">예약취소</button></div>
            </div>
        </div><!-- white_box 끝-->

    </div>
    
</main>