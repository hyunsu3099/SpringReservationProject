/**
 * AddressController.java
 * 주소(위치정보) 보기 요청처리
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-28, 최종수정 2022-11-28
 */
package com.springreservation.web.controller.map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("AddressContoller")
@RequestMapping("/map")
public class AddressContoller {
    
    @GetMapping("")
    public String address(){
        return "all.map.map";
    }
}
