package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.dto.Member;
import com.site.service.MService;

import jakarta.servlet.http.HttpSession;


@Controller
public class MController {
	
	// 객체선언
	@Autowired MService mService;
	@Autowired HttpSession session;	// 세션가져오기
	
	//회원상세보기
	@GetMapping("/member/mView")
	public String mView(@RequestParam(name="id", defaultValue="aaa") String id, Model model) {
		// service연결 -  List-여러개, 객체-1개, 숫자, 문자열
		Member member = mService.findAndId(id);
		model.addAttribute("member", member);
		
		return "member/mView";
	}
	
	//회원리스트
	@GetMapping("/member/mList")
	public String mList(Model model) {
		// service연결 -  List-여러개, 객체-1개, 숫자, 문자열
		List<Member> list = mService.findAll();
		model.addAttribute("list", list);
		
		return "member/mList";
	}
	
	// 로그인페이지
	@GetMapping("/member/login")
	public String login(@RequestParam(name="flag", required = false) String flag, Model model) {
		model.addAttribute("flag", flag);
		System.out.println("flag : "+flag);
		return "member/login";
	}
	
	// 로그인확인
	@PostMapping("/member/login")
	public String login(Member member, Model model) {
		// id, pw 아이디. 패스워드가 일치하는지 확인
		String id = member.getId();
		String pw = member.getPw();
		Member mem = mService.findByIdAndPw(id, pw);
		
		// Member 객체 확인
		if(mem==null) {
			System.out.println("아이디 또는 패스워드가 일치하지 않습니다.");
			return "redirect:/member/login?flag=-1";
		}else {
			System.out.println("로그인 성공");
			session.setAttribute("session_id", mem.getId());
			session.setAttribute("session_name", mem.getName());
			return "redirect:/?flag=1";
		}
	}
	
	
	// 로그아웃
	@GetMapping("/member/logout")
	public String logout(Model model) {
		//session 삭제
		session.invalidate();	// 세션모두삭제
		
		return "redirect:/?flag=2";
	}

	
}
