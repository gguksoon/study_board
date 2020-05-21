package kr.letech.member.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.letech.board.service.IBoardService;
import kr.letech.member.model.Member;
import kr.letech.member.service.IMemberService;

@Controller
public class MemberController {

	@Resource(name = "memberService")
	private IMemberService memberService;
	
	@Resource(name = "boardService")
	private IBoardService boardService;
	
	/**
	* Method : view
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @return
	* Method 설명 : 로그인 화면 요청 처리(forward) 
	*/
	@GetMapping("login") 
	public String loginView() {
		return "login/login";
	}
	
	/**
	* Method : loginProcess
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param mem_id
	* @param mem_pass
	* @param rememberMe
	* @param response
	* @param session
	* @return
	* Method 설명 : 로그인 요청 처리 
	*/
	@PostMapping("login")
	public String loginProcess(String mem_id, String mem_pass, String rememberMe,
								HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		Member member = memberService.getMember(mem_id);
		
		if(mem_pass != null && mem_pass.equals(member.getMem_pass())) {
			// session에 member정보 넣기
			session.setAttribute("S_MEM", member);
			// session에 boardList 넣기
			session.setAttribute("S_BOARDLIST", boardService.getBoardList());
			
			return "redirect:/";
		} else {
			return "login";
		}
	}
	
	/**
	* Method : logout
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param session
	* @return
	* Method 설명 : 로그아웃 요청
	*/
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션의 모든 내용을 지움
		
		return "redirect:/login";
	}
}
