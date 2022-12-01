<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <c:forEach var="n" items="${list}">
                        <tr>
                            <td class="post_num">${n.id}</td>
                            <td><a href="/admin/board/${n.id}">${n.title}</a></td>
                            <td>${n.userName}</td>
                            <td><div>${n.regDate}</div><div>${n.editDate}</div></td>
                            <td>
                                <c:choose>
                                    <c:when test="${n.publish==0}">
                                        <input class="form-check-input" type="checkbox" id="publish_${n.id}">
                                    </c:when>
                                    <c:otherwise>
                                        <input class="form-check-input" type="checkbox" id="publish_${n.id}" checked>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td><input class="form-check-input" type="checkbox" id="delete_${n.id}"></td>
                        </tr>
                        <tr><td colspan="6"><div class= "column_border">
                            <div></div><div></div>
                        </div></tr>
                    </c:forEach>
                </tbody>
            </table>

            <div class="board_foot">
                <div>
                    <span><a href="">&lt;</a> </span>
                    <span>
                        <ul>
                            <c:forEach var="n" items="${pages}">
                                <c:choose>
                                    <c:when test="${n==currentpage}">
                                        <li class="selected_item"><a href="/admin/board?page=${n}">${n}</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><a href="/admin/board?page=${n}">${n}</a></li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </ul>
                    </span>
                    <span><a href="">&gt;</a></span>
                </div>
                <div>
                    <div>
                        <button class="btn btn-primary" type="button" id="btn_update">업데이트</button>
                        <button class="btn btn-secondary" type="button" id="btn_delete">선택삭제</button>
                    </div>
                    <div>
                        <button class="btn btn-primary" type="button" id="btn_create">새글작성</button>
                    </div>
                </div>
            </div>
        </div>

    </div>
</main>