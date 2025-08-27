package com.site.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.site.dto.Member;

@Repository	//생략가능
public interface MemberRepository extends JpaRepository<Member, String> {

	//로그인 확인
	Optional<Member> findByIdAndPw(String id, String pw);

}
