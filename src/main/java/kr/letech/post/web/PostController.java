package kr.letech.post.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.letech.board.model.Board;
import kr.letech.board.service.IBoardService;
import kr.letech.post.model.Post;
import kr.letech.post.service.IPostService;
import kr.letech.postFile.model.PostFile;
import kr.letech.postFile.service.IPostFileService;

@Controller
public class PostController {
	
	@Resource(name="postService")
	private IPostService postService;
	
	@Resource(name="boardService")
	private IBoardService boardService;
	
	@Resource(name="postFileService")
	private IPostFileService postFileService;
	
	/**
	* Method : boardView
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param model
	* @param board_seq
	* @param page
	* @return
	* Method 설명 : 게시판 출력(게시글 페이징 리스트 출력)
	*/
	@RequestMapping("postList/{board_seq}/{page}")
	public String boardView(Model model, @PathVariable int board_seq, @PathVariable Integer page) {
		// 1. board_seq를 이용해 Board객체 불러오기
		Board board = boardService.getBoard(board_seq);
		// view로 Board객체 보내기
		model.addAttribute("board", board);
		
		// 2. pageList 불러오기
		if(page == null) page = 1; // page를 파라미터로 받지 않으면 1페이지 보여줌
		Integer pageLimit = 10; // 화면에 보여 줄 게시글 갯수(이 숫자를 고치면 페이지 내의 게시글 갯수가 변경됨)
		
		// map에 저장하여 service로 전송
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("page", page);
		pageMap.put("pageLimit", pageLimit);
		
		// service에서 받은 데이터를 postList에 저장
		List<Post> postList = postService.getPostList(board_seq, pageMap);
		
		// view로 Board객체 보내기
		model.addAttribute("postList", postList);
		model.addAttribute("page", page);
		
		// 3. board_seq를 이용해 전체 게시글 건수 불러오기
		int postTotalCnt = postService.getPostTotalCnt(board_seq);
		int pageTotalCnt = (postTotalCnt / pageLimit) + 1;

		// view로 Board객체 보내기
		model.addAttribute("postTotalCnt", postTotalCnt);
		model.addAttribute("pageTotalCnt", pageTotalCnt);
		
		return "tiles/board/postList";
	}
	
	/**
	* Method : postView
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param model
	* @param post_seq
	* @return
	* Method 설명 : 게시글 출력
	*/
	@RequestMapping("post/{post_seq}")
	public String postView(Model model, @PathVariable int post_seq) {
		// post_seq를 이용해 Post객체 불러오기
		Post post = postService.getPost(post_seq);
		// view로 Post객체 보내기
		model.addAttribute("post", post);
		
		// board의 이름 불러오기
		String board_name = boardService.getBoard(post.getBoard_seq()).getBoard_name();
		// view로 board_name 보내기
		model.addAttribute("board_name", board_name);
		
		// 첨부파일 불러오기
		List<PostFile> postFileList = postFileService.getPostFileList(post_seq);
		model.addAttribute("postFileList", postFileList);
		
		// 이전글, 다음글 불러오기
		Map<String, Post> beforeAfterPostMap = postService.getBeforeAfterPost(post_seq);
		model.addAttribute("beforeAfterPostMap", beforeAfterPostMap);
		
		return "tiles/board/post";
	}
	
	/**
	* Method : postFormView
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param model
	* @param board_seq
	* @param post_seq
	* @return
	* Method 설명 : insert, update를 하기 위한 postForm 페이지 출력
	* 			board_seq를 받으면 insert이고 post_seq를 받으면 update
	* 			(둘 중 하나만 받게 되어 있음) 
	*/
	@RequestMapping("postForm")
	public String postFormView(Model model, 
				@RequestParam(value="board_seq", required=false, defaultValue="-1") int board_seq, 
				@RequestParam(value="post_seq", required=false, defaultValue="-1") int post_seq) {
		// 새 글인 경우 board_seq만 받고 post_seq는 -1
		// 수정인 경우 post_seq만 받고 board_seq는 -1
		
		if(board_seq >= 0) {
			model.addAttribute("board_seq", board_seq);
		} else {
			model.addAttribute("post", postService.getPost(post_seq));
			model.addAttribute("postFileList", postFileService.getPostFileList(post_seq));
		}
		
		return "tiles/board/postForm";
	}
	
	/**
	* Method : insertPost
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param board_seq
	* @param mem_id
	* @param post_title
	* @param post_cont
	* @param files
	* @return
	* Method 설명 : insert post
	*/
	@PostMapping("insertPost")
	public String insertPost(int board_seq, String mem_id, String post_title, String post_cont,
			@RequestPart("files") List<MultipartFile> files) {
		Post post = new Post(0, board_seq, post_title, post_cont, mem_id, new Date(), null, 1, 0, 0);
		
		// 게시글 생성
		int post_seq = postService.insertPost(post);
		
		// 파일업로드
		fileUpload(files, post_seq, mem_id);
		
		return "redirect:/post/" + post_seq;
	}
	
	/**
	* Method : updatePost
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param post_seq
	* @param post_title
	* @param post_cont
	* @param files
	* @return
	* Method 설명 : update post
	*/
	@PostMapping("updatePost")
	public String updatePost(int post_seq, String post_title, String post_cont,
			@RequestPart("files") List<MultipartFile> files) {
		Post post = postService.getPost(post_seq);
		post.setPost_title(post_title);
		post.setPost_cont(post_cont);
		
		postService.updatePost(post);
		
		// 파일업로드
		fileUpload(files, post_seq, post.getMem_id());
		
		return "redirect:/post/" + post.getPost_seq();
	}
	
	
	/**
	* Method : deletePost
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param post_seq
	* @param board_seq
	* @return
	* Method 설명 : delete post
	*/
	@PostMapping("deletePost")
	public String deletePost(int post_seq, int board_seq) {
		postService.deletePost(post_seq);
		
		return "redirect:/postList/" + board_seq + "/1";
	}
	
	/**
	* Method : fileUpload
	* 작성자 : JO MIN SOO
	* 변경이력 :
	* @param files
	* @param post_seq
	* @param mem_id
	* Method 설명 : 파일 업로드 메서드
	*/
	private void fileUpload(List<MultipartFile> files, int post_seq, String mem_id) {
		for(MultipartFile file : files) {
			if(file.getSize() > 0) {
				// 파일명 (getOriginalFilename() => "사진.png"처럼 가져옴)
				String file_name = file.getOriginalFilename();
				
				// 경로 생성
				String file_path = "C:/MySpace/DownloadFile/";
				File pathFile = new File(file_path);
				if(!pathFile.exists()) pathFile.mkdirs();
				
				// 실제 저장된 이름(UUID 이용)
				String file_realname = UUID.randomUUID().toString();
				File fileInfo = new File(file_path + "/" + file_realname + "");
							
				try {
					file.transferTo(fileInfo);
					PostFile postFile = new PostFile(0, post_seq, mem_id, new Date(), file_name, file_path, file_realname);
					postFileService.insertPostFile(postFile);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
