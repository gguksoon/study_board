package kr.letech.member.service;

import kr.letech.member.model.Member;

public interface IMemberService {

	/**
	* Method : getMemId
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param memId
	* @return
	* Method 설명 : memId에 해당하는 member객체 반환
	*/
	public Member getMember(String memId);
}
