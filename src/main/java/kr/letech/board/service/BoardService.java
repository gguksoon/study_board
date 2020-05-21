package kr.letech.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.letech.board.model.Board;
import kr.letech.board.repository.IBoardDao;

@Service
public class BoardService implements IBoardService {

	@Resource(name="boardDao")
	private IBoardDao boardDao;
	
	/**
	* Method : getBoard
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param board_seq
	* @return
	* Method 설명 : board_seq에 해당하는 Board객체 반환 
	*/
	@Override
	public Board getBoard(int board_seq) {
		return boardDao.getBoard(board_seq);
	}

	/**
	* Method : getBoardList
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @return
	* Method 설명 : 모든 board객체를 List<Board>로 반환 
	*/
	@Override
	public List<Board> getBoardList() {
		return boardDao.getBoardList();
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
	public int insertBoard(Board board) {
		return boardDao.insertBoard(board);
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
	public int updateBoard(Board board) {
		return boardDao.updateBoard(board);
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
		return boardDao.updateBoardStat(board_seq);
	}

}
