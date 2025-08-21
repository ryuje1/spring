package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("member")	// 이렇게 member를 빼면 GetMapping에서 /member 안적어도됨
public class MemberController {
	
	//회원가입
	@GetMapping("/memberInput")
	public String member() {
		return "member/memberInput";
	}
	
	//회원가입
	@PostMapping("/memberInput")
	public String member(
			@RequestParam(name="id", defaultValue="aaa") String id,
			@RequestParam("pw") String pw,
			@RequestParam("name") String name,
			@RequestParam("phone") String phone,
			@RequestParam("gender") String gender,
			Model model) {
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("name", name);
		model.addAttribute("phone", phone);
		model.addAttribute("gender", gender);
		
		return "member/memberResult";
	}
	
	//로그인
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	//로그인
	@PostMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id : "+id);
		System.out.println("pw : "+pw);
		
		// jsp 페이지로 데이터 전송방법
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "member/doLogin";
	}
}
