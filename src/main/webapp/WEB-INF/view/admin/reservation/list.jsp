<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<script>

</script>

<main>
    <div class="reservation_list_container">
        <div class="reserv_page_link">
            <span id="list" class="selected_item">
                <a href="/admin/reservation/list">일자별 예약상태보기</a>
            </span>
            <span id="history">
                <a href="/admin/reservation/history">기록보기</a>
            </span>
        </div>
        <div>list</div>
        <div class="white_box">
            <div class="table_container">
                <div> <!-- row table -->
                    <div> <!--한줄 띄우기--> </div>
                    <table class="table_rowname">
                        <thead><tr><td> &nbsp</td><td> &nbsp</td></tr></thead>
                        <tbody>
                            <c:forEach var="n" items="${reservationNames}">
                                <tr><td>${n.reservationName}</td><td><span>{</span></td> </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div> <!-- row table -->
                    <div>
                        <div>
                            <span class="left" ><a>◀ </a></span>
                            <span class="table_header">11/12(월) ~ 11/17(목)</span>
                            <span class="right" ><a> ▶</a></span>
                        </div>
                    </div>

                    <ul class="index_table_items" id="index_table_items" >
                        <li class="index_table_item" id="index_table_item_1">
                        <table class="table_reservation" id="table_reservation">
                            <!--6개 열-->
                            <colgroup><col><col><col><col><col><col></colgroup>
                            <thead>
                                <tr><td>11/12(월)</td><td>11/13(화)</td><td>11/14(수)</td><td>11/15(목)</td><td>11/16(금)</td><td>11/17(토)</td></tr>
                            </thead>
                            <tbody><!-- 총 6 * 4 개 칼럼-->
                                <c:forEach var="n" items="${reservationNames}">
                                    <tr><td> </td><td> </td><td> </td><td> </td><td> </td><td> </td></tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        </li>
                    </ul>
                </div>
            </div><!-- table container 끝-->
            
            <script>
                // const temp_html = `<div class="round_box">
                // <table>
                // <tr><td><div>9:00~12:00</div></td></tr>
                // <tr><td>
                //     <div class="timebar">
                //         <div class="time_disabled" style="height:40%"></div>
                //         <div class="time_enabled" style="height:50%"></div>
                //         <div class="time_disabled" style="height:10%"></div>
                //     </div>
                // </td></tr>
                // <tr><td><div>예약가능</div></td><td> <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault"></td></tr>
                // </table>
                // </div>`;
                // $('.reservation_list_container .table_reservation>tbody>tr>td').append(temp_html);
            </script>

            <div class="time_selects">
                <select class="form-select" aria-label="Default select example">
                    <option selected>Open this select menu</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </select>
            </div>
            
            <div class="submit_buttons">
                <div>선택한 목록을 </div>
                <div>
                    <button type="button" class="btn btn-success" id="">예약취소</button>
                </div>
                <div>
                    <button type="button" class="btn btn-secondary">예약됨으로 변경</button>
                </div>
            </div>
            <div class="disable_button">
                <div>비활성화 사유 :</div>
                <div>
                    <div class="input-group mb-3">
                        <div class="input-group-text">
                          <input class="form-check-input mt-0" type="checkbox" value="" aria-label="Checkbox for following text input">
                        </div>
                        <input type="text" class="form-control" aria-label="Text input with checkbox">
                    </div>
                </div>
                <div>
                    <button type="button" class="btn btn-secondary">비활성화로 변경</button>
                </div>
            </div>
        </div><!-- white_box 끝-->

    </div>
    
</main>