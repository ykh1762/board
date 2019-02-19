package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/boardSetting")
public class BoardSettingController extends HttpServlet {
	private Logger logger = LoggerFactory.getLogger(BoardSettingController.class);
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/boardSetting.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩 설정하기.
		request.setCharacterEncoding("UTF-8");
		
		List<BoardVo> boardList = boardService.getAllBoard();
		
		// boardSetting.jsp에서 이름 수정했을 때 update 하기.
		String editName = request.getParameter("editName");
		String editFlag = request.getParameter("editFlag");
		String editIndex = request.getParameter("editIndex");
		logger.debug("editName : {}", editName);
		logger.debug("editFlag : {}", editFlag);
		logger.debug("editIndex : {}", editIndex);
		// flag -> null / on
		if(editFlag.equals("")){
			editFlag = "f";
		}else{
			editFlag = "t";
		}
		
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_nm(editName);
		boardVo.setBoard_no(editIndex);
		boardVo.setUse_flag(editFlag);
		
		boardService.updateBoard(boardVo);
		boardList = boardService.getAllBoard();
		request.setAttribute("boardList", boardList);
		
		doGet(request, response);
	}

}
