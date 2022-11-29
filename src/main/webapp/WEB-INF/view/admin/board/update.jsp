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
                <label for="post_title" class="form-label"> 9 </label>
                <input class="form-control form-control-lg" id="post_title"
                    type="text" aria-label=".form-control-lg example"
                    value="사이트 이용가이드">
                
            </div>
            <div class="post_details">
                <div class="border_top_gray"></div>
                <div>
                    <div>
                        <div>작성자: admin</div>
                        <div>작성일: 2022-11-20 10:10</div>
                        <div>최종수정일: 2022-11-20 10:10</div>
                        <div>조회수: 10</div>
                    </div>
                    <div>
                        게시상태 :
                        <span>
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
                        </span>
                    </div>
                </div>
            </div>
            <div class="post_content">
                <div>
                    <label for="post_content" class="form-label">글 내용:</label>
                    <textarea class="form-control" id="post_content" rows="15">
글내용을 수정 할 수 있습니다.
                    </textarea>
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
                <div>이전글 : <span><a href="">글제목</a></span></div>
                <div>다음글 : <span><a href="">예약안내</a></span></div>
            </div>
        </div>
    </div>
</main>