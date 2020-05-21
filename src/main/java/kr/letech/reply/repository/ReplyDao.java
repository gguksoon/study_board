package kr.letech.reply.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.letech.reply.model.Reply;

@Repository
public class ReplyDao implements IReplyDao {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
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
		return sqlSession.selectOne("reply.getReply", reply_seq);
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
		return sqlSession.selectList("reply.getReplyList", post_seq);
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
		return sqlSession.insert("reply.insertReply", reply);
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
		return sqlSession.update("reply.updateReply", reply);
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
		return sqlSession.update("reply.deleteReply", reply_seq);
	}

}
