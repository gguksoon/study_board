package kr.letech.home.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	/**
	* Method : homeView
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @return
	* Method 설명 : 메인 화면 출력 
	*/
	@RequestMapping("/")
	public String homeView() {
		return "tiles/./index";
	}
	
}
