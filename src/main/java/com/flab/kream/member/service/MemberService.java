package com.flab.kream.member.service;


import com.flab.kream.member.dao.MemberDAOImpl;
import com.flab.kream.member.dto.MemberDTO;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberDAOImpl memberDAO;

    public MemberService(MemberDAOImpl memberDAO) {
        this.memberDAO = memberDAO;
    }


    public int join(MemberDTO member){
        validateDuplicateMember(member);//중복 회원 검증
        memberDAO.save(member);
        return member.getMemberId();

    }

    private void validateDuplicateMember(MemberDTO member) {
        MemberDTO result = memberDAO.findById(member.getMemberId());
        if(result == null){
            throw new IllegalStateException("이미 있는 회원입니다.");
        }
    }

    public MemberDTO findOne(int saveId){
        return memberDAO.findById(saveId);
    }
}
