package kr.letech.reply.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.letech.reply.model.Reply;
import kr.letech.reply.repository.IReplyDao;

@Service
public class ReplyService implements IReplyService {

	@Resource(name = "replyDao")
	private IReplyDao replyDao;
	
	/**
	* Method : getReply
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param reply_seq
	* @return
	* Method 설명 : reply_seq에 해당하는 reply를 반환 
	*/
	@Override
	public Reply getReply(int reply_seq) {
		return replyDao.getReply(reply_seq);
	}
	
	/**
	* Method : getReplyList
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param post_seq
	* @return
	* Method 설명 : post_seq에 해당하는 replyList를 반환
	*/
	@Override
	public List<Reply> getReplyList(int post_seq) {
		return replyDao.getReplyList(post_seq);
	}

	/**
	* Method : insertReply
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param reply
	* @return 성공 : 1, 실패 : 0 
	* Method 설명 : insert reply
	*/
	@Override
	public int insertReply(Reply reply) {
		return replyDao.insertReply(reply);
	}
	
	/**
	 * Method : updateReply
	 * 작성자 : JO MIN SOO
	 * 변경이력 :
	 * @param reply
	 * @return 성공 : 1, 실패 : 0
	 * Method 설명 : update reply
	 */
	@Override
	public int updateReply(Reply reply) {
		return replyDao.updateReply(reply);
	}
	
	/**
	* Method : deleteReply
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param reply_seq
	* @return 성공 : 1, 실패 : 0
	* Method 설명 : delete reply
	*/
	@Override
	public int deleteReply(int reply_seq) {
		return replyDao.deleteReply(reply_seq);
	}

}
