package kr.letech.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@RequestMapping("board")
	public String boardView(Model model, String board_seq) {
		model.addAttribute("board_seq", board_seq);
		return "tiles/board/board";
	}
}
