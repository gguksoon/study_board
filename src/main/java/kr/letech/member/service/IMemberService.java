package kr.letech.member.service;

import kr.letech.member.model.Member;

public interface IMemberService {

	/**
	* Method : getMember
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : mem_id에 해당하는 Member객체 반환
	*/
	public Member getMember(String mem_id);
}
