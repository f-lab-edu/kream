package com.flab.kream.member.controller;

import com.flab.kream.member.dto.MemberDTO;
import com.flab.kream.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/join")
    public int join(MemberDTO member){
        int id = memberService.join(member);
        return id;
    }

}
