package org.hjh.mother.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hjh.mother.domain.DataVo;
import org.hjh.mother.domain.MemberVo;
import org.hjh.mother.service.DataService;
import org.hjh.mother.service.MemberService;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/pages")
@AllArgsConstructor
public class PageController {
	
	private DataService dataService;
	private MemberService memberService;

	@GetMapping("/index")
	public void index(Model model) {
		model.addAttribute("nav", "Home");
		model.addAttribute("list", dataService.getList());
		
	}
	
	@GetMapping("/login")
	public void login(Model model) {
		model.addAttribute("nav", "Login");
	}
	
	@GetMapping("/join")
	public void join(Model model) {
		model.addAttribute("nav", "Join");
	}
	
	@GetMapping("/listDrawing")
	public void listDrawing(Model model) {
		model.addAttribute("nav", "Drawing");
	}
	
	@GetMapping("/listEssay")
	public void listEssay(Model model) {
		model.addAttribute("nav", "Essay");
	}
	
	@GetMapping("/listPicture")
	public void listPicture(Model model) {
		model.addAttribute("nav", "Picture");
	}
	
	@GetMapping("/detailEssay")
	public void detailEssay(Model model) {
		
	}
	
	@GetMapping("/register")
	public void register(Model model) {
		model.addAttribute("nav", "Register");
	}
	
	@PostMapping("/join")
	public String join(MemberVo member) {
		boolean flag = memberService.join(member);
		if(flag) {
			//���Լ���
			return "redirect:login";
		}else {
			//���Խ���
			return "redirect:join";
		}
	}
	
	@PostMapping("/checkId")
	public ResponseEntity<String> checkId(String id) {
		int n = memberService.idCheck(id);
		if(n == 1) {
			//�ߺ�x, ��� ����
			return ResponseEntity.status(HttpStatus.OK).body("1");
		}else {
			//�ߺ�o, ��� �Ұ���
			return ResponseEntity.status(HttpStatus.OK).body("0");
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(MemberVo member, HttpServletRequest request) {
		int n = memberService.login(member);
		if(n==1) {
			//�α��μ���
			request.getSession().setAttribute("session_id", member.getId());
		}
		String msg = Integer.toString(n);
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		//�����̷�Ʈ�� ������ ���
		//redirectAttributes.addFlashAttribute("data", "asdfasdf");
		request.getSession().removeAttribute("session_id");
	    return "redirect:"+ request.getHeader("Referer");
	}
	
	@PostMapping("/register")
	public String register(DataVo data) {
		boolean flag = dataService.register(data);
		if(flag) {
			//�۾��⼺��
			return "redirect:index";
		}else {
			//�۾��� ����
			return "redirect:join";
		}
	}
}
