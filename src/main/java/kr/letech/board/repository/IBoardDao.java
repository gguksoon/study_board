package kr.letech.board.repository;

import java.util.List;

import kr.letech.board.model.Board;

public interface IBoardDao {

	/**
	* Method : getBoard
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param board_seq
	* @return
	* Method 설명 : board_seq에 해당하는 Board객체 반환 
	*/
	Board getBoard(int board_seq);
	
	/**
	* Method : getBoardList
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @return
	* Method 설명 : 모든 board객체를 List<Board>로 반환 
	*/
	List<Board> getBoardList();

	/**
	* Method : insertBoard
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param board
	* @return
	* Method 설명 : insert board
	*/
	int insertBoard(Board board);
	
	/**
	* Method : updateBoard
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param board
	* @return
	* Method 설명 : update board 
	*/
	int updateBoard(Board board);
	
	/**
	* Method : updateBoardStat
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param board_seq
	* @return
	* Method 설명 : stat을 1로 변경
	*/
	int updateBoardStat(int board_seq);
}
