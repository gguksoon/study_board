package kr.letech.postFile.repository;

import java.util.List;

import kr.letech.postFile.model.PostFile;

public interface IPostFileDao {

	/**
	* Method : getPostFile
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param file_seq
	* @return
	* Method 설명 : file_seq에 해당하는 파일객체 반환  
	*/
	PostFile getPostFile(int file_seq);
	
	/**
	* Method : getPostFileList
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param post_seq
	* @return
	* Method 설명 : 한 게시글의 전체 파일 리스트 반환
	*/
	public List<PostFile> getPostFileList(int post_seq);
	
	/**
	* Method : insertPostFile
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param postFile
	* @return 성공 : 1, 실패 : 0
	* Method 설명 : 첨부파일 추가
	*/
	int insertPostFile(PostFile postFile);
	
	/**
	* Method : deletePostFile
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param file_seq
	* @return 성공 : 1, 실패 : 0
	* Method 설명 : 첨부파일 삭제
	*/
	int deletePostFile(int file_seq);
	
}
