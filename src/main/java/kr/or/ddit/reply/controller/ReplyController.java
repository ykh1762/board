package kr.or.ddit.reply.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.controller.PostController;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostServiceImpl;
import kr.or.ddit.reply.model.ReplyVo;
import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyServiceImpl;

@WebServlet("/reply")
public class ReplyController extends HttpServlet {
	private Logger logger = LoggerFactory.getLogger(PostController.class);
	private IPostService postService;
	private IReplyService replyService;
	
	@Override
	public void init() throws ServletException {
		postService = new PostServiceImpl();
		replyService = new ReplyServiceImpl();
	}	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String post_no = request.getParameter("replyPost_no");
		
		PostVo postVo = postService.selectPost(post_no);
//		logger.debug("board_nm, post_no, title : {}, {}, {}", request.getParameter("board_nm"), post_no, postVo.getTitle());
		logger.debug("post_no?? : {}", post_no);
		
		request.setAttribute("post_no", post_no);
		request.setAttribute("userid", postVo.getUserid());
		request.setAttribute("title", postVo.getTitle());
		request.setAttribute("content", postVo.getContent());
		request.setAttribute("board_nm", request.getParameter("replyBoard_nm"));
		
		// insertReply
		ReplyVo replyVo = new ReplyVo();
		replyVo.setContent(request.getParameter("replyContent"));
		replyVo.setPost_no(post_no);
		
		int replyCnt = replyService.getReplyCnt();
		replyVo.setReply_no(replyCnt + 1 +"");
		
		// userid
		replyVo.setUserid(request.getParameter("replyUserid"));
		
//		logger.debug("userid, Reply_no, post_no, content: {}, {}, {}, {}", request.getParameter("userid"), replyCnt + 1, request.getParameter("post_no"), request.getParameter("replyContent"));
		replyService.insertReply(replyVo);
		
		List<ReplyVo> replyList = replyService.getReplyList(post_no);
		request.setAttribute("replyList", replyList);
		
		request.getRequestDispatcher("/post.jsp").forward(request, response);
	}

}
