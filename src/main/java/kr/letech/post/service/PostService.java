package kr.letech.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import kr.letech.post.model.Post;
import kr.letech.post.repository.IPostDao;

@Service
public class PostService implements IPostService {

	@Resource(name="postDao")
	private IPostDao postDao;
	
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
		return postDao.getPost(post_seq);
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
		return postDao.getPostList(board_seq, pageMap);
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
		return postDao.getPostTotalCnt(board_seq);
	}
	
	/**
	* Method : getBeforeAfterPost
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param post_seq
	* @return <"before_post", Post>, <"after_post", Post>
	* Method 설명 : post_seq의 이전글과 다음글을 Map형태로 반환
	*/
	@Override
	public Map<String, Post> getBeforeAfterPost(int post_seq) {
		Map<String, Post> map = new HashMap<String, Post>();
		map.put("before_post", postDao.getBeforePost(post_seq));
		map.put("after_post", postDao.getAfterPost(post_seq));
		
		return map;
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
		return postDao.insertPost(post);
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
		return postDao.updatePost(post);
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
		return postDao.deletePost(post_seq);
	}

}
