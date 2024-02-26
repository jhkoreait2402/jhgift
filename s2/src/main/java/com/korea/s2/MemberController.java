package com.korea.s2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MemberDAO;
import lombok.RequiredArgsConstructor;
import service.MemberService;
//import service.MemberService;
import util.Common;

@RequiredArgsConstructor
@Controller
public class MemberController {

	final MemberService memberservice;
	MemberDAO memberDAO;

	//페이지 이동
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String member() {
		return Common.Board.VIEW_PATH + "login.jsp";
	}
	
	//로그인
	@ResponseBody
	public String login(MemberService memberService) {
		return memberService.login(memberDAO);
	}


	
	
	//회원가입
	
	
	
}
