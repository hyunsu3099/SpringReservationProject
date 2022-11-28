/**
 * BoardController.java
 * 관리자계정의 게시판 요청처리
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-28, 최종수정 2022-11-28
 */
package com.springreservation.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("AdminBoardController")
@RequestMapping("/admin/board")
public class BoardController {

    @GetMapping("")
    public String list(){
        return "admin.board.list";
    }
    
    @GetMapping("/detail")
    public String detail(){
        return "admin.board.detail";
    }

    @GetMapping("/create")
    public String create(){
        return "admin.board.create";
    }

    @GetMapping("/update")
    public String update(){
        return "admin.board.update";
    }
}
