package com.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.dto.Member;

@Mapper
public interface MemberMapper {

	// 전체회원리스트
	List<Member> selectAll();

	// 로그인 정보
	Member selectLogin(String id, String pw);

}
