package com.flab.kream.member.service;

import com.flab.kream.member.dto.MemberDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;




@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;

    @Test
    public void join() throws Exception{
        //given
        MemberDTO member = new MemberDTO();
        member.setMemberId(1);
        member.setEmail("test@flab.com");
        member.setNickName("");
        member.setBirthDate("");
        member.setCreateBy("");
        member.setPassword("");
        member.setImageUrl("");
        member.setUpdatedDate("");
        member.setCreatedDate("");
        member.setGender("");


        //when
        int saveId = memberService.join(member);

        //then
        MemberDTO findMember = memberService.findOne(saveId);
        Assertions.assertThat(member.getMemberId()).isEqualTo(findMember.getMemberId());

    }

}