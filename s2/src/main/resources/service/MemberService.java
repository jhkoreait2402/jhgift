package service;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberService {
	

	MemberDTO memberDTO;

	public String login(MemberDAO memberDAO) {
		return memberDAO.login(memberDTO);
	}
}
