<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<main>
    <div class="board_update_container">
        <div class="update_head">
            <a href="/admin/board">공지사항 관리페이지</a>
        </div>

        <div class="board_white_box">
            <div class="post_title">
                <label for="post_title" class="form-label"> ${board.id} </label>
                <input class="form-control form-control-lg" id="post_title"
                    type="text" aria-label=".form-control-lg example"
                    value="${board.title}">
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
                    <div>
                        게시상태 :
                        <span>
                            <input class="form-check-input" type="checkbox" id="publish_Chk">
                            <script>
                                if( '${board.publish}'==1 ) $('#publish_Chk').prop('checked', true);
                            </script>
                        </span>
                    </div>
                </div>
            </div>
            <div class="post_content">
                <div>
                    <label for="post_content" class="form-label">글 내용:</label>
                    <textarea class="form-control" id="post_content" rows="15">${board.content}</textarea>
                </div>
                <div>
                    <button type="button" class="btn btn-outline-dark">돌아가기</button>
                    <button type="button" class="btn btn-outline-dark">수정</button>
                    <button type="button" class="btn btn-outline-dark">삭제</button>
                </div>

            </div>
            <div class="post_foot">
                <div class="border_top_gray"></div>
                <div></div>
                <div>이전글 : <span><a href="/admin/board/${prev.id}">${prev.title}</a></span></div>
                <div>다음글 : <span><a href="/admin/board/${next.id}">${next.title}</a></span></div>
            </div>
        </div>
    </div>
</main>