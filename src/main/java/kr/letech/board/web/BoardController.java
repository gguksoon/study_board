package kr.letech.board.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import kr.letech.board.model.Board;
import kr.letech.board.service.IBoardService;

/**
 * @author JO MIN SOO
 *
 */
@Controller
public class BoardController {

	@Resource(name = "boardService")
	private IBoardService boardService;
	
	@Resource(name = "jsonView")
	private View jsonView;
	
	/**
	* Method : getBoardList
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param model
	* @return
	* Method 설명 : boardList를 json형태로 반환 
	*/
	@RequestMapping("getBoardList") 
	public View getBoardList(Model model) {
		model.addAttribute("boardList", boardService.getBoardList());
		
		return jsonView;
	}
	
	/**
	* Method : manageBoardView
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param model
	* @return
	* Method 설명 : 게시판 관리 페이지 호출
	*/
	@RequestMapping("manageBoard")
	public String manageBoardView() {
		
		return "tiles/manage/manageBoard";
	}
	
	/**
	* Method : insertBoard
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param board
	* @return
	* Method 설명 : insert board
	*/
	@PostMapping("insertBoard")
	public View insertBoard(HttpSession session, @ModelAttribute Board board) {
		// 게시판 추가
		boardService.insertBoard(board);
		
		// 추가한 Board를 세션에 저장
		session.setAttribute("S_BOARDLIST", boardService.getBoardList());
		
		return jsonView;
	}
	
	/**
	* Method : updateBoard
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param session
	* @param board
	* @return
	* Method 설명 : update board
	*/
	@PostMapping("updateBoard")
	public View updateBoard(HttpSession session, @ModelAttribute Board board) {
		// 게시판 수정
		boardService.updateBoard(board);
		
		// 갱신한 Board를 세션에 저장
		session.setAttribute("S_BOARDLIST", boardService.getBoardList());
		
		return jsonView;
	}
	
	/**
	* Method : updateBoardStat
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param session
	* @param board_seq
	* @return
	* Method 설명 : stat을 1로 변경
	*/
	@PostMapping("updateBoardStat")
	public View updateBoardStat(HttpSession session, int board_seq) {
		// 게시판 수정
		boardService.updateBoardStat(board_seq);
		
		// 갱신한 Board를 세션에 저장
		session.setAttribute("S_BOARDLIST", boardService.getBoardList());
		
		return jsonView;
	}
}
