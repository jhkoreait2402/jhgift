package dao;

import org.apache.ibatis.session.SqlSession;

import dto.MemberDTO;

public class MemberDAO {//ASDFDAS
	
	SqlSession sqlSession;//
//	public MemberDAO(SqlSession sqlSession) {
//		
//		this.sqlSession = sqlSession;
//	}
	
	
	public String login(MemberDTO dto) { // ID, PW
		
		return sqlSession.selectOne("m.loginCheck",dto);
	}
}
