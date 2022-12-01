/**
 * HomeController.java
 * 인덱스페이지 요청처리
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-8, 최종수정 2022-11-28
 */
package com.springreservation.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("")
public class HomeController{
    
    @RequestMapping({"","/index"})
    public String index(){
        return "index";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin.head.index.index";
    }
}