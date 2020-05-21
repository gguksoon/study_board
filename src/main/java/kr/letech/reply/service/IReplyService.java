package kr.letech.reply.service;

import java.util.List;

import kr.letech.reply.model.Reply;

public interface IReplyService {

	/**
	* Method : getReply
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param reply_seq
	* @return
	* Method 설명 : reply_seq에 해당하는 reply를 반환 
	*/
	Reply getReply(int reply_seq);
	
	/**
	* Method : getReplyList
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param post_seq
	* @return
	* Method 설명 : post_seq에 해당하는 replyList를 반환
	*/
	List<Reply> getReplyList(int post_seq);

	/**
	* Method : insertReply
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param reply
	* @return 성공 : 1, 실패 : 0 
	* Method 설명 : insert reply
	*/
	int insertReply(Reply reply);

	/**
	* Method : updateReply
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param reply
	* @return 성공 : 1, 실패 : 0
	* Method 설명 : update reply
	*/
	int updateReply(Reply reply);
	
	/**
	* Method : deleteReply
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param reply_seq
	* @return 성공 : 1, 실패 : 0
	* Method 설명 : delete reply
	*/
	int deleteReply(int reply_seq);

}
