package kr.letech.post.service;

import java.util.List;
import java.util.Map;

import kr.letech.post.model.Post;

public interface IPostService {

	/**
	* Method : getPost
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param post_seq
	* @return
	* Method 설명 : post_seq에 해당하는 Post객체 반환
	*/
	Post getPost(int post_seq);
	
	/**
	* Method : getPostList
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param board_seq
	* @param pageMap ==> page, pageLimit
	* @return
	* Method 설명 : board_seq에 해당하는 pageList를 반환(pageMap을 이용한 pageList)
	*/
	List<Post> getPostList(int board_seq, Map<String, Integer> pageMap);
	
	/**
	* Method : getPostTotalCnt
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param board_seq
	* @return
	* Method 설명 : board_seq에 해당하는 Post의 갯수를 반환
	*/
	int getPostTotalCnt(int board_seq);
	
	/**
	* Method : getBeforeAfterPost
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param post_seq
	* @return <"before_post", Post>, <"after_post", Post>
	* Method 설명 : post_seq의 이전글과 다음글을 Map형태로 반환
	*/
	Map<String, Post> getBeforeAfterPost(int post_seq);
	
	/**
	* Method : insertPost
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param post
	* @return
	* Method 설명 : 게시글 추가
	*/
	int insertPost(Post post);
	
	/**
	* Method : updatePost
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param post
	* @return
	* Method 설명 : 게시글 수정
	*/
	int updatePost(Post post);
	
	/**
	* Method : deletePost
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param post_seq
	* @return 
	* Method 설명 : 게시글 삭제 
	*/
	int deletePost(int post_seq);
}
