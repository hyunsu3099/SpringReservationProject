<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<main>
    <div class="board_list_container">
        <div class="searchbar">
            <select class="form-select" aria-label="Default select example">
                <option selected value="1">제목</option>
                <option value="2">작성자</option>
                <option value="3">날짜</option>
            </select>

            <input class="input_search" type="text" >

            <button type="button" class="btn btn-outline-dark">검색</button>
        </div>

        <div class = "board_white_box">
            <table>
                <colgroup>
                    <col width="8%">
                    <col width="41%">
                    <col width="12%">
                    <col width="23%">
                    <col width="8%">
                    <col width="8%">
                </colgroup>
                <thead>
                    <tr>
                        <td>번호</td>
                        <td>글제목</td>
                        <td>작성자</td>
                        <td><div>작성일</div><div>최종수정일</div></td>
                        <td>게시</td>
                        <td>삭제</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>9</td>
                        <td>예약안내</td>
                        <td>admin</td>
                        <td><div>2022-11-22</div><div>2022-11-22</div></td>
                        <td>
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
                        </td>
                        <td>
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                        </td>
                    </tr>
                    <tr><td colspan="6"><div class= "column_border"><div></div><div></div></div></tr>
                    <tr>
                        <td>9</td>
                        <td>예약안내</td>
                        <td>admin</td>
                        <td><div>2022-11-22</div><div>2022-11-22</div></td>
                        <td>
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
                        </td>
                        <td>
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                        </td>
                    </tr>
                    <tr><td colspan="6"><div class= "column_border"><div></div><div></div></div></tr>
                    <tr>
                        <td>9</td>
                        <td>예약안내</td>
                        <td>admin</td>
                        <td><div>2022-11-22</div><div>2022-11-22</div></td>
                        <td>
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
                        </td>
                        <td>
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                        </td>
                    </tr>
                    <tr><td colspan="6"><div class= "column_border"><div></div><div></div></div></tr>
                    <tr>
                        <td>9</td>
                        <td>예약안내</td>
                        <td>admin</td>
                        <td><div>2022-11-22</div><div>2022-11-22</div></td>
                        <td>
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
                        </td>
                        <td>
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                        </td>
                    </tr>
                    <tr><td colspan="6"><div class= "column_border"><div></div><div></div></div></tr>
                    <tr>
                        <td>9</td>
                        <td>예약안내</td>
                        <td>admin</td>
                        <td><div>2022-11-22</div><div>2022-11-22</div></td>
                        <td>
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
                        </td>
                        <td>
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                        </td>
                    </tr>
                    <tr><td colspan="6"><div class= "column_border"><div></div><div></div></div></tr>
                    <tr>
                        <td>9</td>
                        <td>예약안내</td>
                        <td>admin</td>
                        <td><div>2022-11-22</div><div>2022-11-22</div></td>
                        <td>
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
                        </td>
                        <td>
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                        </td>
                    </tr>
                    <tr><td colspan="6"><div class= "column_border"><div></div><div></div></div></tr>
                </tbody>
            </table>

            <div class="board_foot">
                <div>
                    <span><a href="">&lt;</a> </span>
                    <span>
                        <ul>
                            <li class="selected_item"><a href="">1</a></li>
                            <li><a href="">2</a></li>
                            <li><a href="">3</a></li>
                            <li><a href="">4</a></li>
                            <li><a href="">5</a></li>
                            <li><a href="">6</a></li>
                            <li><a href="">7</a></li>
                            <li><a href="">8</a></li>
                        </ul>
                    </span>
                    <span><a href="">&gt;</a></span>
                </div>
                <div>
                    <button class="btn btn-primary" type="button">업데이트</button>
                    <button class="btn btn-secondary" type="button">선택삭제</button>
                </div>
            </div>
        </div>

    </div>
</main>