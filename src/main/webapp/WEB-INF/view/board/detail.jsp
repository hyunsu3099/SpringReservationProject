<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<main>
    <div class="board_update_container">
        <div class="update_head">
            <a href="/admin/board">공지사항 관리페이지</a>
        </div>

        <div class="white_box">
            <div class="post_title">
                <div>${board.id}</div>
                <div>"${board.title}"</div>
            </div>
            <div class="post_details">
                <div class="border_top_gray"></div>
                <div>
                    <div>
                        <div>작성자: ${board.userName}</div>
                        <div>작성일: ${board.regDate}</div>
                        <div>최종수정일: ${board.editDate}</div>
                        <div>조회수: ${board.hit}</div>
                    </div>
                </div>
            </div>
            <div class="post_content">
                <div>
                    <div>글 내용:</div>
                    <div>${board.content}</div>
                </div>
                <div>
                    <button type="button" class="btn btn-outline-dark" id="btn_back">돌아가기</button>
                </div>

            </div>
            <div class="post_foot">
                <div class="border_top_gray"></div>
                <div></div>
                <div>이전글 : <span><a href="/board/${prev.id}">${prev.title}</a></span></div>
                <div>다음글 : <span><a href="/board/${next.id}">${next.title}</a></span></div>
            </div>
        </div>
    </div>
</main>