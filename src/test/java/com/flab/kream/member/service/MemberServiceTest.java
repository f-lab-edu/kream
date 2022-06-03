package com.flab.kream.member.service;

import com.flab.kream.member.dto.MemberRequestDTO;
import com.flab.kream.member.mapper.MemberMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.Validation;
import javax.validation.Validator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberMapper memberMapper;

    @Mock
    private MemberRequestDTO memberRequestDTO;

    private Validator validator = null;

    @BeforeEach
    void setUp() {
        memberRequestDTO = memberRequestDTO.builder().email("hyodg90@gmail.com").password("pass").nickName("ADMIN").gender("M").birth("19901219").imageUrl("testUrl").build();
    }

    @BeforeEach
    public void setupValidator() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void addMemberTest() {
        //when
        memberService.addMember(memberRequestDTO);
        //then
        verify(memberMapper).addMember(any(MemberRequestDTO.class));
    }

    @Test
    @DisplayName("회원가입 실패 테스트 - 멤버아이디 미입력")
    public void addMemberFailTest() {
        //given
        memberRequestDTO = memberRequestDTO.builder().email("hyodg90@gmail.com").password("pass").nickName("ADMIN").gender("M").birth("19901219").imageUrl("testUrl").build();
        //when
        doThrow(IllegalArgumentException.class).when(memberMapper).addMember(any(MemberRequestDTO.class));
        //then
        assertThrows(IllegalArgumentException.class, () -> memberService.addMember(memberRequestDTO));
    }
}
