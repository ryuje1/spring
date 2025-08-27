package com.site.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity	//JPA table 생성 @Entity 붙이는 순간 Member라는 테이블 자동생성됨
public class Member {
	
	@Id	//기본키 설정 - primary key
	private String id;
	@Column(nullable=false, length=100)	//하나의 컬럼으로 등록시켜줌, (nullable=false, length=100) => pw varchar2(100) not null, 과 같음
	private String pw;
	@Column(nullable=false, length=100)
	private String name;
	@Column(length=50)	// nullable 기본은 true
	private String phone;
	@ColumnDefault("'남자'")	// default '남자', 와 같음
	private String gender;
	@Column(length=100)
	private String hobby;
	@CreationTimestamp	// 시간 자동입력 - sysdate와 같음
	private Timestamp mdate;
}
