<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<main>
    <div class="reservation_detail_container">
        <div>detail</div>
        <div class="white_box">
            <div class="detail_date">
                <div>12/12</div>
            </div>
            <div class="table_container">
            </div>
            <script>
                const temp_html=`<table class="table_reservation"><tbody>
                        <colgroup><col width="4%"><col width="4%"><col width="10%"><col width="22%"><col width="27%"><col width="5%"><col width="8%"></colgroup>
                        <tr>
                        <td rowspan="4">A</td><td rowspan="4">{</td>
                        <td><div>9:00-12:00</div><div class="gray_text">예약됨</div></td>
                        <td><div>예약id: 1112222</div><div>이름: yzhs</div></td>
                        <td><div>예약시간:2022-12-03/11:11</div><div>전화번호: 000-2222-3333</div></td>
                        <td><input class="form-check-input" type="checkbox" value="" id="flexCheckDefault"></td>
                        <td><button type="button" class="btn btn-secondary">예약취소</button></td>
                        </tr>
                        <tr>
                        <td><div>12:00-15:00</div><div class="green_text">예약가능</div></td>
                        <td><div></div><div></div></td>
                        <td><div></div><div></div></td>
                        <td><input class="form-check-input" type="checkbox" value="" id="flexCheckDefault"></td>
                        <td><button type="button" class="btn btn-success">예약</button></td>
                        </tr>
                        <tr>
                        <td><div>15:00-18:00</div><div class="darkgray_text">이용불가</div></td>
                        <td><div>예약id: 1112222</div><div>이름: yzhs</div></td>
                        <td><div>예약시간:2022-12-03/11:11</div><div>전화번호: 000-2222-3333</div></td>
                        <td><input class="form-check-input" type="checkbox" value="" id="flexCheckDefault"></td>
                        <td><button type="button" class="btn btn-secondary">예약취소</button></td>
                        </tr>
                        </tbody></table>`;
                    $('.reservation_detail_container .table_container').append(temp_html);
                    $('.reservation_detail_container .table_container').append(temp_html);
                    $('.reservation_detail_container .table_container').append(temp_html);
                    $('.reservation_detail_container .table_container').append(temp_html);
            </script>

            <div class="border_line"></div>
            <div class="submit_buttons">
                <div>선택한 목록을 </div>
                <div>
                    <button type="button" class="btn btn-success">예약가능으로 변경</button>
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