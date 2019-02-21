package kr.or.ddit.post.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.attach_file.model.Attach_fileVo;
import kr.or.ddit.attach_file.service.Attach_fileServiceImpl;
import kr.or.ddit.attach_file.service.IAttach_fileService;
import kr.or.ddit.post.dao.IPostDao;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostServiceImpl;
import kr.or.ddit.reply.model.ReplyVo;
import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/post")
public class PostController extends HttpServlet {
	private Logger logger = LoggerFactory.getLogger(PostController.class);
	private IPostService postService;
	private IReplyService replyService;
	private IAttach_fileService attach_fileService;
	
	@Override
	public void init() throws ServletException {
		postService = new PostServiceImpl();
		replyService = new ReplyServiceImpl();
		attach_fileService = new Attach_fileServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전체 게시글 조회.
		List<PostVo> postList = postService.getAllPost();
		request.setAttribute("postList", postList);
		
		request.getRequestDispatcher("/board.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String post_no = request.getParameter("post_no");
		
		PostVo postVo = postService.selectPost(post_no);
		logger.debug("board_nm, post_no, title : {}, {}, {}", request.getParameter("board_nm"), post_no, postVo.getTitle());
		
		request.setAttribute("post_no", post_no);
		request.setAttribute("userid", postVo.getUserid());
		request.setAttribute("title", postVo.getTitle());
		request.setAttribute("content", postVo.getContent());
		request.setAttribute("board_nm", request.getParameter("board_nm"));
		
		List<ReplyVo> replyList = replyService.getReplyList(post_no);
		request.setAttribute("replyList", replyList);
		
		List<Attach_fileVo> fileList = attach_fileService.getPostFileList(post_no);
		request.setAttribute("fileList", fileList);
		
		request.getRequestDispatcher("/post.jsp").forward(request, response);
	}

}













