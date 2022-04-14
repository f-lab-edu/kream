package com.flab.kream.member.dao;

import com.flab.kream.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MemberDAO {
    MemberDTO save(MemberDTO member);
    MemberDTO findById(int saveId);

}
