/**
 * BoardController.java
 * 관리자계정의 게시판 요청처리
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-28, 최종수정 2022-12-2
 */
package com.springreservation.web.controller.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springreservation.web.dto.BoardDto;
import com.springreservation.web.service.BoardService;

@Controller("AdminBoardController") 
@RequestMapping("/admin/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    //admin 일경우만 가능한 쿼리의경우 isAdmin 파라미터 포함하여 요청
    private final int isAdmin=1;

    //List 가져오기 Get
    //request 파라미터 : {page: 요청 페이지, key: 검색필드, val: 검색어}
    //Model ,{list: 게시글리스트, pages: 보여줄 목록 페이지들, current: 현재페이지} jsp로 응답
    //뷰 : "admin.head.board.list"
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
        List<BoardDto> list = boardService.getList(page, key, val, isAdmin);

        //페이지수 설정 1~8페이지
        //boardService 이용 (getCount)
        int startpage = (page/maxnumPage) * maxnumPage + 1;
        int lastpage = boardService.getCounts(key, val, isAdmin)/postPerPage +2;
        if(lastpage>startpage+maxnumPage+2) lastpage = startpage+maxnumPage+1;
        // model에 넘겨줄 페이지 수
        List<Integer> pages = IntStream.range(startpage,lastpage)
                                .boxed()
                                .collect(Collectors.toList());

        model.addObject("list", list);
        model.addObject("pages", pages);
        model.addObject("currentpage", page);
        model.setViewName("admin.head.board.list");
        return model;
    }// END of getList()
    
    //상세 페이지( 수정하기 페이지 ) Get
    //Model ,{list: 게시글리스트, pages: 보여줄 목록 페이지들, current: 현재페이지} jsp로 응답
    //뷰 : "admin.head.board.list
    @GetMapping("/{id}")
    public ModelAndView updateview( @PathVariable int id){

        BoardDto board = boardService.get(id, isAdmin);
        BoardDto prev = boardService.getPrev(id, isAdmin);
        BoardDto next = boardService.getNext(id, isAdmin);
        
        ModelAndView model = new ModelAndView();
        model.addObject("board", board);
        model.addObject("prev", prev);
        model.addObject("next", next);
        model.setViewName("admin.board.update");
        return model;
    }

    //글쓰기 페이지 Get
    @GetMapping("/write")
    public String writepage(){return "admin.board.create"; }

    //글쓰기 Post
    @ResponseBody
    @PostMapping("")
    public String create(@RequestBody BoardDto boardDto){
        int result = boardService.create(boardDto.getBoard(),isAdmin);
        return "{ \"result\" : [ {\"result\": \" "+ result + "\"} ] }";
    }

    //수정하기 Put(전체 수정)
    @ResponseBody
    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody BoardDto boardDto){
        boardDto.setId(id);
        int result = boardService.update(boardDto.getBoard(),isAdmin);
        return "{ \"result\" : [ {\"result\": \" "+ result + "\"} ] }";
    }

    //게시상태(publish) 수정하기 Patch
    @ResponseBody
    @PatchMapping("/{ids}")
    public String patchStatus(@PathVariable String ids){
        String[] str = StringUtils.commaDelimitedListToStringArray(ids);
        List<Integer> id = new ArrayList<>();
        for(int i=0; i<str.length; i++) id.add(Integer.parseInt(str[i]));

        int result = boardService.propPublishes(id, isAdmin);

        return "{ \"result\" : [ {\"result\": \" "+ result + "\"} ] }";
    }

    //글 삭제하기 delete
    @ResponseBody
    @DeleteMapping("/{ids}")
    public String delete(@PathVariable String ids){
        String[] str = StringUtils.commaDelimitedListToStringArray(ids);
        List<Integer> id = new ArrayList<>();
        for(int i=0; i<str.length; i++) id.add(Integer.parseInt(str[i]));

        int result = boardService.deletePosts(id, isAdmin);

        return "{ \"result\" : [ {\"result\": \" "+ result + "\"} ] }";
    }
}
