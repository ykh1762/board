package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.javassist.SerialVersionUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.attach_file.model.Attach_fileVo;
import kr.or.ddit.attach_file.service.Attach_fileServiceImpl;
import kr.or.ddit.attach_file.service.IAttach_fileService;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.post.controller.PostController;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostServiceImpl;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Logger logger = LoggerFactory.getLogger(PostController.class);
	private IPostService postService;
	private IBoardService boardService;
	private IAttach_fileService attach_fileService;
	
	@Override
	public void init() throws ServletException {
		postService = new PostServiceImpl();
		boardService = new BoardServiceImpl();
		attach_fileService = new Attach_fileServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String board_nm = request.getParameter("board_nm");
		request.setAttribute("board_nm", board_nm);
//		logger.debug("board_nm?? : {}", board_nm);
		
		logger.debug("????");
		
		BoardVo boardVo = boardService.selectBoard(board_nm);
		String board_no = boardVo.getBoard_no();
		
		String use_flag = boardVo.getUse_flag();
		request.setAttribute("use_flag", use_flag);
		
		// 여기서 게시글 설정.
//		List<PostVo> postList = postService.getAllPost();
		List<PostVo> postList = postService.getEditList(board_no);
		
		request.setAttribute("postList", postList);
		request.setAttribute("postList", postList);
		
		
		request.getRequestDispatcher("/board.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		logger.debug("????111");
		System.out.println("????111");
		
		// insertPost
		PostVo postVo = new PostVo();
		String userid = (String) request.getSession().getAttribute("userId");
//		logger.debug("userid : {}", userid);
		// userid를 못가져오네.
		if(userid == null){
			userid = "m";
		}
		
		int postCnt = postService.getPostCnt();
		
		// board_nm값 추가
		String board_nm = request.getParameter("board_nm");
		request.setAttribute("board_nm", board_nm);
		
		BoardVo boardVo = boardService.selectBoard(board_nm);
		String board_no = boardVo.getBoard_no();		
		
		postVo.setBoard_no(board_no);
		
		postVo.setUserid(userid);
		postVo.setPost_no(postCnt + 1 + "");
		postVo.setTitle(request.getParameter("title"));
		postVo.setContent(request.getParameter("smarteditor"));
		logger.debug("content?? : {}", request.getParameter("smarteditor"));
		
		// parent_post_no 값이 있으면 vo에 입력.
//		logger.debug("parent? : {}", request.getParameter("parent_post_no"));
		if(request.getParameter("parent_post_no") != null)
			postVo.setParent_post_no((String) request.getParameter("parent_post_no"));
		
		postService.insertPost(postVo);
//		logger.debug("posting!");
		
		updateAllLevel();
		updateAllGn();

		// 첨부파일 세팅.
		List<Attach_fileVo> fileList = attach_fileService.getFileList("1");
		for(Attach_fileVo attach_fileVo : fileList){
			attach_fileVo.setPost_no(postCnt + 1 + "");
			attach_fileVo.setInsertflag("t");
			logger.debug("file post_no setting?? : {}", postCnt + 1);
			
			attach_fileService.updateFileFlag(attach_fileVo);
		}
		
		
		doGet(request, response);
	}
	
	public void updateAllLevel(){
		/***Given***/
		List<PostVo> postList = postService.getAllPost();
		List<PostVo> levelList = postService.getLevel();
		
		/***When***/
		int updateCnt = 0;
		
		for(int i = 0; i < postList.size(); i++){
			PostVo postVo = postList.get(i);
			
			String level = levelList.get(i).getPost_level();
			postVo.setPost_level(level);
			
			updateCnt += postService.updateLevel(postVo);
		}
		
	}
	
	public void updateAllGn(){
		/***Given***/
		List<PostVo> postList = postService.getAllPost();
		
		/***When***/
		int updateCnt = 0;
		
		for(PostVo postVo : postList){
//			logger.debug("for??");
			logger.debug("level?? : {}", postVo.getPost_level());
			logger.debug("post_no?? : {}", postVo.getPost_no());
			
			if(postVo.getPost_level().equals("1")){
				logger.debug("level = 1 ??");
				
				postVo.setGn(postVo.getPost_no());
				updateCnt += postService.updateGn(postVo);
			}else{
				int parent_post_no = Integer.valueOf(postVo.getParent_post_no());
				
				boolean flag = false;
				
				while(true){
//					logger.debug("post_level : {} -> {}", postVo.getPost_no(), postList.get(parent_post_no - 1).getPost_level());
					
					// index -> (post_no - 1)... ...
					if(postList.get(parent_post_no - 1).getPost_level().equals("1") || flag){
						postVo.setGn(postList.get(parent_post_no - 1).getPost_no());	
						updateCnt += postService.updateGn(postVo);
						flag = false;
						break;
					}else{
						if(postList.get(parent_post_no - 1).getParent_post_no() == null){
							logger.debug("flag check");

							flag = true;
						}else{
							parent_post_no = Integer.valueOf(postList.get(parent_post_no - 1).getParent_post_no());
						}
					}
				}
				
			}
				
		}

		
	}

}










