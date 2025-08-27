package com.site.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dto.Member;
import com.site.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired MemberRepository memberRepository;

	@Override	// id가 존재하는지 확인
	public Member findById(String id) {
		Member member = memberRepository.findById(id).orElseGet(
				() -> { return new Member(); }
				);
		
		return member;
	}

	@Override	// 로그인 확인(id, pw)
	public Member findByIdAndPw(String id, String pw) {
		Member member = memberRepository.findByIdAndPw(id, pw).orElseGet(
				() -> { return new Member(); }
				);
		
		return member;
	}

	@Override //임의로 이름변경
	public Member findLogin(String id, String pw) {
		Member member = memberRepository.findLogin(id,pw).get();
		return member;
	}

}
