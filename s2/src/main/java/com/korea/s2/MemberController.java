package com.korea.s2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.MemberService;
import util.Common;


@Controller
public class MemberController {

//	final MemberService memberservice;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String member() {
		return Common.Board.VIEW_PATH + "login";
	}
	
}
