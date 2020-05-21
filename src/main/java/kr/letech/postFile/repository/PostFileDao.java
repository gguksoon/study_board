package kr.letech.postFile.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.letech.postFile.model.PostFile;

@Repository
public class PostFileDao implements IPostFileDao {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	/**
	* Method : getPostFile
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param file_seq
	* @return
	* Method 설명 : file_seq에 해당하는 파일객체 반환  
	*/
	@Override
	public PostFile getPostFile(int file_seq) {
		return sqlSession.selectOne("postFile.getPostFile", file_seq);
	}

	/**
	* Method : getPostFileList
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param post_seq
	* @return
	* Method 설명 : 한 게시글의 전체 파일 리스트 반환
	*/
	@Override
	public List<PostFile> getPostFileList(int post_seq) {
		return sqlSession.selectList("postFile.getPostFileList", post_seq);
	}

	/**
	* Method : insertPostFile
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param postFile
	* @return 성공 : 1, 실패 : 0
	* Method 설명 : 첨부파일 추가
	*/
	@Override
	public int insertPostFile(PostFile postFile) {
		return sqlSession.insert("postFile.insertPostFile", postFile);
	}
	
	/**
	* Method : deletePostFile
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param file_seq
	* @return 성공 : 1, 실패 : 0
	* Method 설명 : 첨부파일 삭제
	*/
	@Override
	public int deletePostFile(int file_seq) {
		return sqlSession.delete("postFile.deletePostFile", file_seq);
	}
	
}
