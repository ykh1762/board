package kr.or.ddit.attach_file.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.attach_file.model.Attach_fileVo;
import kr.or.ddit.attach_file.service.Attach_fileServiceImpl;
import kr.or.ddit.attach_file.service.IAttach_fileService;
import kr.or.ddit.util.PartUtil;

import org.slf4j.LoggerFactory;

@WebServlet("/attach_fileUpload")

// 5MB = 5 * 1MB = 5 * 1024KB = 5 * 1024 * 1024BYTE
@MultipartConfig(maxFileSize=5*1024*1024, maxRequestSize= 5*5*1024*1024)
public class Attact_fileUploadServlet extends HttpServlet {
	private static final String UPLOAD_PATH = "d:\\picture\\";
	private IAttach_fileService attach_fileService;
	
	// logger객체 생성.
	private org.slf4j.Logger logger = LoggerFactory.getLogger(Attact_fileUploadServlet.class);
       
	@Override
	public void init() throws ServletException {
		attach_fileService = new Attach_fileServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("board_nm", request.getParameter("board_nm"));
//		logger.debug("board_nm? : {}", request.getParameter("board_nm"));
		
		
		request.getRequestDispatcher("/SE2/posting.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 사용자 사진
		Part profilePart = request.getPart("fileUpload");
		logger.debug("part? : {}", request.getPart("fileUpload"));
		
		// 사용자가 사진을 올린 경우 
		String fileName = "";
		String realFileName = "";
		
		if(profilePart.getSize() > 0){
			// 사용자 테이블에 파일명을 저장(실제 업로드한 파일명 - fileName, 파일 충돌을 방지하기
			// 위해 사용한 uuid - realFileName)
			String contentDisposition = profilePart.getHeader("Content-Disposition");
			
			fileName = PartUtil.getFileNameFromPart(contentDisposition);
			realFileName = "d:\\picture\\" + UUID.randomUUID().toString();
			
			// 디스크에 기록 (d:\picture\ + realFileName)
			profilePart.write(realFileName);
			
		}
		
		// 등록 안된 첨부파일 flag를 f로 수정.
		
		
		
		// attach_fileInsert
		Attach_fileVo attach_fileVo = new Attach_fileVo();
		attach_fileVo.setFilename(fileName);
		attach_fileVo.setRealfilename(realFileName);
		
		int attach_fileCnt = attach_fileService.getAttach_fileCnt();
		attach_fileVo.setFile_no(attach_fileCnt + 1 + "");
		attach_fileVo.setInsertflag("1");
		
		attach_fileService.insertAttach_file(attach_fileVo);
		
		List<Attach_fileVo> fileList = attach_fileService.getFileList("1");
		logger.debug("size? : {}", fileList.size());
		
		request.setAttribute("fileList", fileList);
		
		// board_nm 받아서 다시 넘기기 fileBoard_nm
		String board_nm = request.getParameter("fileBoard_nm");
		logger.debug("board_nm?? : {}", request.getParameter("fileBoard_nm"));
		request.setAttribute("board_nm", board_nm);
		
		
		request.getRequestDispatcher("/SE2/posting.jsp").forward(request, response);
	}

}
















