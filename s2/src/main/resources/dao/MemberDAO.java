package dao;

import org.apache.ibatis.session.SqlSession;

import dto.MemberDTO;

public class MemberDAO {
	
	SqlSession sqlSession;
//	public MemberDAO(SqlSession sqlSession) {
//		
//		this.sqlSession = sqlSession;
//	}
	
	
	public String login(MemberDTO dto) {
		
		return sqlSession.selectOne("m.loginCheck",dto);
	}
}
