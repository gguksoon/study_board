package kr.letech.reply.web;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import kr.letech.reply.model.Reply;
import kr.letech.reply.service.IReplyService;

@Controller
public class ReplyController {

	@Resource(name = "replyService")
	private IReplyService replyService;
	
	@Resource(name = "jsonView")
	private View jsonView;
	
	@RequestMapping("getReplyList")
	public View getReplyList(Model model, int post_seq) {
		model.addAttribute(replyService.getReplyList(post_seq));
		
		return jsonView;
	}
	
	/**
	* Method : insertReply
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param model
	* @param post_seq
	* @param mem_id
	* @param reply_cont
	* @return
	* Method 설명 : insert reply
	*/
	@PostMapping("insertReply")
	public View insertReply(Model model, int post_seq, String mem_id, String reply_cont) {
		Reply reply = new Reply(0, post_seq, mem_id, reply_cont, new Date(), null, 1, null);
		
		model.addAttribute(replyService.insertReply(reply));
		
		return jsonView;
	}
	
	/**
	* Method : updateReply
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param model
	* @param reply_seq
	* @param reply_cont
	* @return
	* Method 설명 : update reply
	*/
	@PostMapping("updateReply")
	public View updateReply(Model model, int reply_seq, String reply_cont) {
		Reply reply = replyService.getReply(reply_seq);
		reply.setReply_mod(new Date());
		reply.setReply_cont(reply_cont);
		
		model.addAttribute(replyService.updateReply(reply));
		
		return jsonView;
	}
	
	/**
	* Method : deleteReply
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param model
	* @param reply_seq
	* @return
	* Method 설명 : delete reply
	*/
	@PostMapping("deleteReply")
	public View deleteReply(Model model, int reply_seq) {
		model.addAttribute(replyService.deleteReply(reply_seq));
		
		return jsonView;
	}
}
