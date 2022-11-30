package com.springreservation.web.service;

import java.util.List;

import com.springreservation.web.dto.BoardDto;
/**
 * BoardService.java
 * 게시판에 대한 데이터요청 서비스의 지시서
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-29, 최종수정 2022-11-29
 */
import com.springreservation.web.entity.Board;

public interface BoardService {

    public List<BoardDto> getList(int page, String key, String val,int isAdmin);
    public List<BoardDto> getList(int page, String key, String val);

    public BoardDto get(int id, int isAdmin);
    public BoardDto get(int id);
    public BoardDto getPrev(int id, int isAdmin);
    public BoardDto getPrev(int id);
    public BoardDto getNext(int id, int isAdmin);
    public BoardDto getNext(int id);

    public int getCounts(String key, String val, int isAdmin);
    public int getCounts(String key, String val);

    public int create(Board board, int isAdmin);
    public int update(Board board, int isAdmin);

    public int patch(int id, int isAdmin);
    public int propPublishes(List<Integer> list, int isAdmin);

    public int delete(int id, int isAdmin);
    public int deletePosts(List<Integer> list, int isAdmin);

    public int hit(int id);
}
