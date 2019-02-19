package kr.or.ddit.post.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostServiceImpl;
import kr.or.ddit.post.service.PostServiceImplTest;
import kr.or.ddit.user.model.UserVo;

@WebServlet("/posting")
public class PostingController extends HttpServlet {
	private IPostService postService;
	private Logger logger = LoggerFactory.getLogger(PostingController.class);
	
	@Override
	public void init() throws ServletException {
		postService = new PostServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("board_nm", request.getParameter("board_nm"));
		logger.debug("board_nm? : {}", request.getParameter("board_nm"));
		
		
		request.getRequestDispatcher("/post/posting.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	


}
