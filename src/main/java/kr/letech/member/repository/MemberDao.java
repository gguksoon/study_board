package kr.letech.member.repository;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.letech.member.model.Member;

@Repository
public class MemberDao implements IMemberDao {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/**
	* Method : getMember
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : mem_id에 해당하는 member객체 반환
	*/
	@Override
	public Member getMember(String mem_id) {
		return sqlSession.selectOne("member.getMember", mem_id);
	}

}
