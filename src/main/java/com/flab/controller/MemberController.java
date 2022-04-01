package com.flab.controller;

import com.flab.model.Member;
import com.flab.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/hi")
    public String member(){
        Member member = memberService.getMember("testid");
        System.out.println("member = " + member.toString());
        return "test";
    }

    @GetMapping("/hi2")
    public String test(){
        return "test";
    }

}













