package com.site.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.site.dto.Member;

//@Repository	//JpaRepository extends시, 생략가능
public interface MemberRepository extends JpaRepository<Member, String> {
	// <리턴객체, 객체기본키타입>
	// 기본메소드
	// select - findAll() : 예외처리없음, 리턴타입-List타입 / findById() : 예외처리필요 / 그 외는 생성 필요
	// insert - save()
	// update - update()
	// delete - delete()

	// id 확인 findById는 기본메소드라 정의 필요X
	
	// 로그인 확인(id, pw) - select할때 데이터가 찾아지면 Optional 객체 리턴
	// select 할때 데이터가 없으면 Optional
	// findByIdAndPw => select * from member where id = #{id} and pw=#{pw}
	// findByIdOrPw => select * from member where id = #{id} or pw=#{pw}
	Optional<Member> findByIdAndPw(String id, String pw);

	@Query(value = "select * from member where id=? and pw=?",nativeQuery = true)
	Optional<Member> findLogin(String id, String pw);

}
