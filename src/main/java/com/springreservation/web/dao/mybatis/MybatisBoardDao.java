/**
 * MybatisBoardDao.java
 * 게시판에 대한 데이터요청 Dao 구현채
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-29, 최종수정 2022-11-30
 */
package com.springreservation.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springreservation.web.dao.BoardDao;
import com.springreservation.web.entity.Board;

@Repository
public class MybatisBoardDao implements BoardDao {

    private BoardDao mapper;

    @Autowired
    MybatisBoardDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(BoardDao.class);
    }

    //list 불러오기
    @Override
    public List<Board> getList(int offset, int limit, String key, String val, int isAdmin) {
        return mapper.getList(offset, limit, key, val, isAdmin);
    }
    //글개수 확인
    @Override
    public int getCounts(String key, String val, int isAdmin) {return mapper.getCounts(key, val, isAdmin);}

    @Override
    public Board get(int id, int isAdmin){return mapper.get(id, isAdmin);}
    @Override
    public Board getPrev(int id, int isAdmin) {return mapper.getPrev(id, isAdmin);}
    @Override
    public Board getNext(int id, int isAdmin) {return mapper.getNext(id, isAdmin);}

    //글쓰기
    @Override
    public int create(Board board) { return mapper.create(board); }

    //수정하기
    @Override
    public int update(Board board) { return mapper.update(board); }

    @Override
    public int patch(int id) {return mapper.patch(id);}

    @Override
    public int delete(int id) {return mapper.delete(id);}
    @Override
    public int hit(int id) {return mapper.hit(id);}
    
}
