package service;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberService {
	
	MemberDTO dto;

	public String login(MemberDAO memberDAO) {
		return memberDAO.login(MemberDTO dto);
	}
}
