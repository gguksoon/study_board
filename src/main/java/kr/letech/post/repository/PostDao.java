package kr.letech.post.repository;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.letech.post.model.Post;

@Repository
public class PostDao implements IPostDao {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/**
	* Method : getPost
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param post_seq
	* @return
	* Method 설명 : post_seq에 해당하는 Post객체 반환
	*/
	@Override
	public Post getPost(int post_seq) {
		return sqlSession.selectOne("post.getPost", post_seq);
	}

	/**
	* Method : getPostList
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param board_seq
	* @param pageMap ==> page, pageLimit
	* @return
	* Method 설명 : board_seq에 해당하는 pageList를 반환(pageMap을 이용한 pageList)
	*/
	@Override
	public List<Post> getPostList(int board_seq, Map<String, Integer> pageMap) {
		// page(offset): 데이터를 가져오는 시작점에서 얼마나 떨어진 데이터인지
		int offset = (pageMap.get("page") - 1) * pageMap.get("pageLimit");
		// pageLimit(limit): 몇 개의 값을 가져올 지
		int limit = pageMap.get("pageLimit");
		
		RowBounds row = new RowBounds(offset, limit);
		
		List<Post> pageList = sqlSession.selectList("post.getPostList", board_seq, row);
		
		return pageList;
	}

	/**
	* Method : getPostTotalCnt
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param board_seq
	* @return
	* Method 설명 : board_seq에 해당하는 Post의 갯수를 반환
	*/
	@Override
	public int getPostTotalCnt(int board_seq) {
		return sqlSession.selectOne("post.getPostTotalCnt", board_seq);
	}
	
	/**
	* Method : getBeforePost
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param post_seq
	* @return
	* Method 설명 : 이전글의 post 객체 반환
	*/
	@Override
	public Post getBeforePost(int post_seq) {
		return sqlSession.selectOne("post.getBeforePost", post_seq);
	}

	/**
	* Method : getAfterPost
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param post_seq
	* @return
	* Method 설명 : 다음글의 post 객체 반환
	*/
	@Override
	public Post getAfterPost(int post_seq) {
		return sqlSession.selectOne("post.getAfterPost", post_seq);
	}
	
	/**
	* Method : insertPost
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param post
	* @return
	* Method 설명 : 게시글 추가
	*/
	@Override
	public int insertPost(Post post) {
		sqlSession.insert("post.insertPost", post);
		int cnt = post.getPost_seq();
		
		return cnt;
	}
	
	/**
	* Method : updatePost
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param post
	* @return
	* Method 설명 : 게시글 수정
	*/
	@Override
	public int updatePost(Post post) {
		return sqlSession.update("post.updatePost", post);
	}

	
	/**
	* Method : deletePost
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param post_seq
	* @return 
	* Method 설명 : 게시글 삭제 
	*/
	@Override
	public int deletePost(int post_seq) {
		return sqlSession.delete("post.deletePost", post_seq);
	}

}
