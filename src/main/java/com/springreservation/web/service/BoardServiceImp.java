/**
 * BoardServiceImp.java
 * 게시판에 대한 데이터요청 서비스 구현체
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-29, 최종수정 2022-12-2
 */
package com.springreservation.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springreservation.web.dao.BoardDao;
import com.springreservation.web.dto.BoardDto;
import com.springreservation.web.entity.Board;

@Service
public class BoardServiceImp implements BoardService {

    @Autowired
    BoardDao boardDao;
    
    //공지사항 목록을 불러옴
    //page: 요청할 뷰의 게시판 페이지, key: 검색필드, val: 검색어,
    //isAdmin : Admin으로 접근시 모든목록 반환
    @Override
    public List<BoardDto> getList(int page, String key, String val,int isAdmin) {

        //보여줄 페이지 수 기본값
        int postPerPage = 8;

        int offset = (page-1) * postPerPage;
        int limit = offset + postPerPage;
        
        List<Board> list= boardDao.getList(offset, limit, key, val, isAdmin);

        List<BoardDto> result = new ArrayList<>();
        for(Board board : list) result.add( board.getBoardDto() );

        return result;
    }
    public List<BoardDto> getList(int page, String key, String val){ return getList(page, key, val,0);} //관리자 뷰에서 접근하지 않았을때

    //detail 포스트 보기
    //id: board 테이블 id
    //isAdmin : Admin으로 접근시 모든목록 반환
    @Override
    public BoardDto get(int id, int isAdmin) {
        Board board = boardDao.get(id, isAdmin);
        if(board==null)return new BoardDto();
        return board.getBoardDto();
    }
    public BoardDto get(int id){return get(id, 0);}//관리자 뷰에서 접근하지 않았을때


    //이전글 정보 가져오기
    //id: 현재 글의 board 테이블 id
    //isAdmin : Admin으로 접근시 모든목록 반환
    @Override
    public BoardDto getPrev(int id, int isAdmin) {
        Board board = boardDao.getPrev(id, isAdmin);
        if(board==null)return new BoardDto();
        return board.getBoardDto();
    }
    public BoardDto getPrev(int id){return getPrev(id, 0);}//관리자 뷰에서 접근하지 않았을때


    //다음글 정보 가져오기
    //id: 현재 글의 board 테이블 id
    //isAdmin : Admin으로 접근시 모든목록 반환
    @Override
    public BoardDto getNext(int id, int isAdmin) {
        Board board = boardDao.getNext(id, isAdmin);
        if(board==null)return new BoardDto();
        return board.getBoardDto();
    }
    public BoardDto getNext(int id){return getNext(id, 0);}//관리자 뷰에서 접근하지 않았을때


    //글갯수 가져오기
    // key: 검색필드, val: 검색어,
    //isAdmin : Admin으로 접근시 모든목록 반환
    @Override
    public int getCounts(String key, String val, int isAdmin) {
        return boardDao.getCounts(key, val, isAdmin);
    }
    public int getCounts(String key, String val){return getCounts(key,val, 0);}//관리자 뷰에서 접근하지 않았을때

    // post 요청 글 작성하기( insert 쿼리)
    // name, title, content, publish 를 포함한 board 객체
    // isAdmin : Admin페이지에서 접근해야만 Dao 요청
    @Override
    public int create(Board board, int isAdmin) {
        if(isAdmin==1)return boardDao.create(board);
        else return 0;
    }

    // 게시글 수정 update 쿼리
    // name, title, content, publish ,id 를 포함한 board 객체
    // isAdmin : Admin페이지에서 접근해야만 Dao 요청
    @Override
    public int update(Board board, int isAdmin) {
        if(isAdmin==1)return boardDao.update(board);
        else return 0;
    }

    // 게시글 게시여부 patch요청 (update 쿼리)
    // id : 테이블 내 publish 값 전환할 컬럼 id
    // isAdmin : Admin페이지에서 접근해야만 Dao 요청
    @Override
    public int patch(int id, int isAdmin) {
        if(isAdmin==1) return boardDao.patch(id);
        else return 0;
    }

    // 여러 개 게시글 게시여부 patch요청 (update 쿼리)
    // list : 테이블 내 publish 값 전환할 컬럼 id의 리스트
    // isAdmin : Admin페이지에서 접근해야만 Dao 요청
    @Override
    public int propPublishes(List<Integer> list, int isAdmin) {
        int result =0;
        for(int i : list){
            result += patch(i,isAdmin);
        }
        return result;
    }

    // 게시글 삭제 delete 쿼리
    // id : 삭제할 컬럼 id
    // isAdmin : Admin페이지에서 접근해야만 Dao 요청
    @Override
    public int delete(int id, int isAdmin) {
        if(isAdmin==1) return boardDao.delete(id);
        else return 0;
    }

    // 게시글 삭제 delete 쿼리
    // id : 삭제할 컬럼 id
    // isAdmin : Admin페이지에서 접근해야만 Dao 요청
    @Override
    public int deletePosts(List<Integer> list, int isAdmin) {
        int result =0;
        for(int i : list){
            result += delete(i,isAdmin);
        }
        return result;
    }

    // 게시글 열람시 조회수 올리기
    // id : 삭제할 컬럼 id
    @Override
    public int hit(int id){
        return boardDao.hit(id);
    }
}
