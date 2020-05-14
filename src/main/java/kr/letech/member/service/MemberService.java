package kr.letech.member.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.letech.member.repository.IMemberDao;
import kr.letech.member.model.Member;

@Service
public class MemberService implements IMemberService {

	@Resource(name = "memberDao")
	private IMemberDao memberDao;
	
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
		return memberDao.getMember(memId);
	}

}
