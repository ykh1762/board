package kr.or.ddit.post.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.attach_file.model.Attach_fileVo;
import kr.or.ddit.attach_file.service.Attach_fileServiceImpl;
import kr.or.ddit.attach_file.service.IAttach_fileService;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostServiceImpl;

@WebServlet("/posting")
public class PostingController extends HttpServlet {
	private IPostService postService;
	private IAttach_fileService attach_fileService;
	private Logger logger = LoggerFactory.getLogger(PostingController.class);
	
	@Override
	public void init() throws ServletException {
		postService = new PostServiceImpl();
		attach_fileService = new Attach_fileServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("board_nm", request.getParameter("board_nm"));
		logger.debug("board_nm? : {}", request.getParameter("board_nm"));
		
		// 등록 안된 파일 flag f로 수정.
		List<Attach_fileVo> fileList = attach_fileService.getFileList("1");
		for(Attach_fileVo attach_fileVo : fileList){
			attach_fileVo.setInsertflag("f");
			
			attach_fileService.updateFileFlag(attach_fileVo);
		}
		
		
		
		request.getRequestDispatcher("/SE2/posting.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	


}
