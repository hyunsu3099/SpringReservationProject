<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<main>
    <div class="board_create_container">

        <div class="update_head">
            <a href="/admin/board">공지사항 관리페이지</a>
            <div>글쓰기</div>
        </div>

        <div class="board_white_box">
            <div class="post_title">
                <label for="post_title" class="form-label"> 글제목: </label>
                <input class="form-control form-control-lg" id="post_title"
                    type="text" aria-label=".form-control-lg example"
                    value="">
                
            </div>
            <div class="post_details">
                <div class="border_top_gray"></div>
                <div>
                    <div>
                        <div>작성자: <span id="writer_name">admin</span></div>
                    </div>
                    <div>
                        게시상태 :
                        <span>
                            <input class="form-check-input" type="checkbox" id="publish_chk" checked>
                        </span>
                    </div>
                </div>
            </div>

            <div class="post_content">
                <div>
                    <label for="post_content" class="form-label">글 내용:</label>
                    <textarea class="form-control" id="post_content" rows="15"></textarea>
                </div>
                <div>
                    <button type="button" class="btn btn-outline-dark" id="btn_back">돌아가기</button>
                    <button type="button" class="btn btn-outline-dark" id="btn_upload">업로드</button>
                </div>
            </div>
            <div class="post_foot">
                <div class="border_top_gray"></div>
                <div></div>
            </div>
        </div>
    </div>
</main>