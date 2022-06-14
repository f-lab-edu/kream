package com.flab.kream.member.controller;

import com.flab.kream.member.dto.MemberRequestDTO;
import com.flab.kream.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<HttpStatus> addMember(@Validated @RequestBody MemberRequestDTO memberRequestDTO) {
        memberService.addMember(memberRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
