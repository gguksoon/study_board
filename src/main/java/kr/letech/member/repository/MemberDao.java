package kr.letech.member.repository;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.letech.member.model.Member;

@Repository
public class MemberDao implements IMemberDao {

	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	/**
	* Method : getMemId
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param memId
	* @return
	* Method 설명 : memId에 해당하는 member객체 반환
	*/
	@Override
	public Member getMember(String memId) {
		return sqlSession.selectOne("member.getMember", memId);
	}

}
