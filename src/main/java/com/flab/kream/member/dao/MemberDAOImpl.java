package com.flab.kream.member.dao;

import com.flab.kream.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class MemberDAOImpl implements MemberDAO {

    @Override
    public MemberDTO save(MemberDTO member) {
        save(member);
        return member;
    }


    @Override
    public MemberDTO findById(int saveId) {
        return findById(saveId);
    }


}
