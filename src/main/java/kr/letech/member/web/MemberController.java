package kr.letech.member.web;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.letech.member.model.Member;
import kr.letech.member.service.IMemberService;

@Controller
public class MemberController {

	@Resource(name = "memberService")
	private IMemberService memberService;
	
	/**
	* Method : view
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @return
	* Method 설명 : 로그인 화면 요청 처리(forward) 
	*/
	@GetMapping("login") 
	public String loginView() {
//		return "login/login";
		Member member = memberService.getMember("admin");
		System.out.println(member.toString());
		return "tiles/./index";
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
		
		manageMemIdCookie(response, mem_id, rememberMe);

		Member member = memberService.getMember(mem_id);
		
		if(member == null) {
			return "login/login";
		} else if(mem_pass != null && mem_pass.equals(member.getMem_pass())) {
			// session에 member정보 넣기
			session.setAttribute("S_MEMBERVO", member);

			return "redirect:/main";
		} else {
			return "login/login";
		}
	}
	
	private void manageMemIdCookie(HttpServletResponse response, String mem_id, String rememberMe) {
		// rememberMe 파라미터가 존재할 경우 memId를 cookie로 생성
		Cookie cookie = new Cookie("mem_id", mem_id);
		if(rememberMe != null)
			cookie.setMaxAge(60 * 60 * 24 * 30); // second
		else 
			cookie.setMaxAge(0);
		response.addCookie(cookie);
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
