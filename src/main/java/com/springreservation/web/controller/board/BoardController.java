/**
 * BoardController.java
 * 공지사항 보기 요청처리
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-28, 최종수정 2022-11-28
 */
package com.springreservation.web.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("BoardController")
@RequestMapping("/board")
public class BoardController {

    @GetMapping({"", "/list"})
    public String list(){
        return "all.board.list";
    }

    @GetMapping("/detail")
    public String detail(){
        return "all.board.board";
    }
    
}
