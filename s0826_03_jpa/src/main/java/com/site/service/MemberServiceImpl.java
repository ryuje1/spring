package com.site.service;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dto.Member;
import com.site.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired MemberRepository memberRepository;

	@Override
	public Member findByIdAndPw(Member m) {
		String id = m.getId();
		String pw = m.getPw();
		// orElseGet() : find메소드를 진행할때 데이터가 없을 경우 빈객체 생성
		// Jpa 규칙 find By Id : id 데이터 값을 주입
		// findByIdAndPw(id, pw) = select * from member where id=#{id} and pw=#{pw}
		// findById - 기본 메소드로 제공 그 외는 직접 만들어서 넣기
		Member member = memberRepository.findByIdAndPw(id, pw).orElseGet(
				() -> {return new Member();}
				);
		
		// find 메소드를 해서 데이터가 넘어오면 없을 경우 에러 발생
//		Member member = memberRepository.findByIdAndPw(id, pw).orElseThrow(
////				new Supplier<IllegalArgumentException>() {
////					
////					public IllegalArgumentException get() {
////						return new IllegalArgumentException("예외발생 - 데이터가 없습니다.");
////					}
////				};
//				
//				// 예외처리 람다식
//				() -> {
//					return new IllegalArgumentException("예외발생-데이터가 없음");
//				}
//		);
		return member;
	}

}
