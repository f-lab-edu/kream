package com.flab.repository;



import com.flab.model.Member;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper {


    Member getUserList(String id);
}
