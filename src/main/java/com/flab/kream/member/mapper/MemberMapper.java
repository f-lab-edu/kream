package com.flab.kream.member.mapper;

import com.flab.kream.member.dto.MemberRequestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberMapper {
    int selectMemberIdCnt(long memberId);

    int selectMemberEmail(String email);

    void addMember(MemberRequestDTO memberRequestDTO);
}
