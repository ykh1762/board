package kr.or.ddit.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostServiceImpl;

@WebServlet("/repost")
public class RepostController extends HttpServlet {
	private IPostService postService;
	
	@Override
	public void init() throws ServletException {
		postService = new PostServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String board_nm = request.getParameter("board_nm");
		String post_no = request.getParameter("post_no");
		
		PostVo postVo = postService.selectPost(post_no);
		
		request.setAttribute("board_nm", board_nm);
		request.setAttribute("title", postVo.getTitle());
		request.setAttribute("content", postVo.getContent());
		request.setAttribute("post_no", postVo.getPost_no());
		
		
		request.getRequestDispatcher("/SE2/repost.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
