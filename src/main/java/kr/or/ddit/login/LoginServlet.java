package kr.or.ddit.login;

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
import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	
	private IUserService userService;
	private IBoardService boardService;

	
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
		boardService = new BoardServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("contextPath : {}", request.getContextPath());
		
		// session 기록 삭제.
		logger.debug("session userVo : {}", request.getSession().getAttribute("userVo"));
		if(request.getSession().getAttribute("userVo") != null)
			request.getSession().removeAttribute("userVo");
		
		// 로그인..부터 시작.
		String userId = request.getParameter("userId");
		logger.debug("userId : {}", userId);
		String pass = request.getParameter("pass");
		
		// 회원정보 일치여부 확인.
		UserVo userVo = userService.selectUser(userId);
		
		
		if(userVo ==null){
			doGet(request, response);
			return;
		}
		
		if(userVo.getPass().equals(KISA_SHA256.encrypt(pass))){
			request.getSession().setAttribute("userVo", userVo);
			
			List<BoardVo> boardList = boardService.getAllBoard();
			
			// session에 값 저장. <- request에 속성으로 저장하면 페이지 이동시 값이 유지되지 않음.
			// session도 자꾸 정보가 지워져..
			request.getSession().setAttribute("boardList", boardList);
			
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else{
			doGet(request, response);
			return;
		}
		
	}

}















