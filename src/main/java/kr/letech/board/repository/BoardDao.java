package kr.letech.board.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.letech.board.model.BoardVo;

@Repository
public class BoardDao implements IBoardDao {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/**
	* Method : getBoard
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param board_seq
	* @return
	* Method 설명 : board_seq에 해당하는 Board객체 반환 
	*/
	@Override
	public BoardVo getBoard(int board_seq) {
		return sqlSession.selectOne("board.getBoard", board_seq);
	}
	
	/**
	* Method : getBoardList
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @return
	* Method 설명 : 모든 board객체를 List<Board>로 반환 
	*/
	@Override
	public List<BoardVo> getBoardList() {
		return sqlSession.selectList("board.getBoardList");
	}

	/**
	* Method : insertBoard
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param board
	* @return
	* Method 설명 : insert board
	*/
	@Override
	public int insertBoard(BoardVo board) {
		return sqlSession.insert("board.insertBoard", board);
	}
	
	/**
	* Method : updateBoard
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param board
	* @return
	* Method 설명 : update board 
	*/
	@Override
	public int updateBoard(BoardVo board) {
		return sqlSession.update("board.updateBoard", board);
	}

	/**
	* Method : updateBoardStat
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param board_seq
	* @return
	* Method 설명 : stat을 1로 변경
	*/
	@Override
	public int updateBoardStat(int board_seq) {
		return sqlSession.update("board.updateBoardStat", board_seq);
	}

}
