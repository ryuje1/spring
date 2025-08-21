package com.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dao.MemberMapper;
import com.site.dto.Member;

@Service
public class MServiceImpl implements MService {
	
	@Autowired MemberMapper memberMapper;

	// id, pw 확인
	@Override
	public Member findByIdAndPw(String id, String pw) {
		Member member = memberMapper.findByIdAndPw(id, pw);
		return member;
	}

	// 회원리스트
	@Override
	public List<Member> findAll() {
		List<Member> list = memberMapper.findAll();
		return list;
	}

	// 회원상세보기
	@Override
	public Member findAndId(String id) {
		Member member = memberMapper.findAndId(id);
		return member;
	}

}
