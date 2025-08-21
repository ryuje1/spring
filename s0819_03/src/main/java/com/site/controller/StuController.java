package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.site.dto.Student;

@Controller
public class StuController {
	@GetMapping("/stu/stu")
	public String stuInput() {
		return "stu/stuInput";
	}
	
	@PostMapping("/stu/stu")
	public String stuInput(Student student, Model model) {
//		if(student.getKor() == null && student.getEng() == null && student.getMath() == null) {
//			student.setKor(0);
//			student.setEng(0);
//			student.setMath(0);
//		}
		student.setTotal(student.getKor() + student.getEng() + student.getMath());
		student.setAvg(student.getTotal()/3.0);
		model.addAttribute("student", student);
		
		return "stu/stuResult";
	}
	
}
