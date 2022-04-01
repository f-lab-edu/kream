package com.flab.service;

import com.flab.model.Member;
import com.flab.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }


    public Member getMember(String id) {
        return memberMapper.getUserList(id);
    }


}

