package com.flab.kream.member.service;

import com.flab.kream.exception.CustomException;
import com.flab.kream.member.dto.MemberRequestDTO;
import com.flab.kream.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.flab.kream.exception.ErrorCode.EMAIL_DUPLICATED;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    @Transactional
    public void addMember(MemberRequestDTO memberRequestDTO) {
        int reuslt = memberMapper.selectMemberEmail(memberRequestDTO.getEmail());
        if (reuslt > 0) {
            throw new CustomException(EMAIL_DUPLICATED);
        } else {
            memberMapper.addMember(memberRequestDTO);
        }
    }
}
