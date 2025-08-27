package com.site.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity	//Member라는 테이블 자동생성
public class Member {
	@Id	//primary key (기본키)로 등록 
	private String id;
	@Column(nullable = false, length=100)	//SQL - pw varchar2(100) not null 과 같음
	private String pw;
	@Column(nullable = false, length=100)
	private String name;
	@Column(length=300)	//010-1111-1111, nullable default = true라서 생략가능
	private String phone;
	@ColumnDefault("'남자'")	//gender varchar2(30) default '남자'
	private String gender;
	@Column(length=100)
	private String hobby;
	@CreationTimestamp	//시간 자동입력
	private Timestamp mdate;
}
