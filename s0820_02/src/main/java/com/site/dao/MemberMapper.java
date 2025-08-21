package com.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.dto.Member;

@Mapper
public interface MemberMapper {
	List<Member> selectAll();
}
