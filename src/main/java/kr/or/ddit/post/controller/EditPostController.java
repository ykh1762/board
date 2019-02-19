package kr.or.ddit.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/editPost")
public class EditPostController extends HttpServlet {
	private Logger logger = LoggerFactory.getLogger(EditPostController.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// post data 전달
		// 이 방식은 post지.
		request.setAttribute("board_nm", request.getParameter("board_nm")); 
		request.setAttribute("title", request.getParameter("title")); 
		request.setAttribute("content", request.getParameter("content")); 
		
		logger.debug("param? : {}", request.getParameter("board_nm"));
		logger.debug("servlet in?");
		
		request.getRequestDispatcher("/editPost.jsp").forward(request, response);
	}

}
