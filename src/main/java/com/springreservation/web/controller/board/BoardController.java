/**
 * BoardController.java
 * 공지사항 보기 요청처리
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-28, 최종수정 2022-12-2
 */
package com.springreservation.web.controller.board;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springreservation.web.dto.BoardDto;
import com.springreservation.web.service.BoardService;

@Controller("BoardController")
@RequestMapping("/board")
public class BoardController {
    
    @Autowired
    private BoardService boardService;
    
    //List 가져오기 Get
    //request 파라미터 : {page: 요청 페이지, key: 검색필드, val: 검색어}
    //Model ,{list: 게시글리스트, pages: 보여줄 목록 페이지들, current: 현재페이지} jsp로 응답
    //뷰 : "all.head.board.list"
    @GetMapping("")
    public ModelAndView list(HttpServletRequest request){

        //반환 모델
        ModelAndView model = new ModelAndView();

        // 기본 페이지 값 및 기본쿼리값
		int page = 1;
		String key = "title";
		String val = "";

        //보여줄 페이지 수 기본값
        int postPerPage = 8;
        int maxnumPage = 8;

        // 요청 파라미터에서 page 값과 쿼리 키 가 있을 경우 가져오기
        if(request.getParameter("page")!=null) page =  Integer.parseInt(request.getParameter("page")) ;
	    if(request.getParameter("key")!=null) key =  request.getParameter("key") ;
        if(request.getParameter("val")!=null) val =  request.getParameter("val") ;

        // 출력할 boardlist 
        //boardService 이용
        List<BoardDto> list = boardService.getList(page, key, val);

        //페이지수 설정 1~8페이지
        //boardService 이용 (getCount)
        int startpage = (page/maxnumPage) * maxnumPage + 1;
        int lastpage = boardService.getCounts(key, val)/postPerPage +2;
        if(lastpage>startpage+maxnumPage+2) lastpage = startpage+maxnumPage+1;
        // model에 넘겨줄 페이지 수
        List<Integer> pages = IntStream.range(startpage,lastpage)
                                .boxed()
                                .collect(Collectors.toList());

        model.addObject("list", list);
        model.addObject("pages", pages);
        model.addObject("currentpage", page);
        model.setViewName("all.head.board.list");
        return model;

    }// END of getList()

    //상세 페이지 Get
    //Model ,{board: 게시글, prev:이전글, next: 다음글} jsp로 응답
    //뷰 : "all.board.detail
    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable int id){

        ModelAndView model = new ModelAndView();

        //detail 게시글 가져오기
        BoardDto board = boardService.get(id);
        //이전, 이후 글  가져오기
        BoardDto prev = boardService.getPrev(id);
        BoardDto next = boardService.getNext(id);

        //목록 불러오기 성공시 조회수 1 증가
        if(board!=null) boardService.hit(id);
        
        model.addObject("board", board);
        model.addObject("prev", prev);
        model.addObject("next", next);
        model.setViewName("all.board.detail");
        return model;
    }
    
}
