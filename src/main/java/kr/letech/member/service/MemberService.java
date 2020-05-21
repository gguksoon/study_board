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
	* Method : getMember
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : mem_id에 해당하는 Member객체 반환
	*/
	@Override
	public Member getMember(String mem_id) {
		return memberDao.getMember(mem_id);
	}

}
