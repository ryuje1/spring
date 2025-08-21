package com.site.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
	private Integer sno;
	private String name;
//	private Integer kor;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
}
