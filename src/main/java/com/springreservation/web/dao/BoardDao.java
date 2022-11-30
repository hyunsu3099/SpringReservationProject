/**
 * BoardDao.java
 * 게시판에 대한 데이터요청 Dao 지시서
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-29, 최종수정 2022-11-29
 */
package com.springreservation.web.dao;

import java.util.List;

import com.springreservation.web.entity.Board;

public interface BoardDao {

    public List<Board> getList(int offset, int limit, String key, String val, int isAdmin);

    public Board get(int id, int isAdmin);
    public Board getPrev(int id, int isAdmin);
    public Board getNext(int id, int isAdmin);
    public int getCounts(String key, String val, int isAdmin);

    public int create(Board board);
    public int update(Board board);

    public int patch(int id);
    public int delete(int id);

    public int hit(int id);
}
