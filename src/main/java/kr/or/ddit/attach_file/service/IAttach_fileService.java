package kr.or.ddit.attach_file.service;

import java.util.List;

import kr.or.ddit.attach_file.model.Attach_fileVo;

public interface IAttach_fileService {
	
	/**
	 * 
	 * Method : getAttach_fileCnt
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 첨부파일 수 조회.
	 */
	int getAttach_fileCnt();
	
	/**
	 * 
	 * Method : insetAttach_file
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 첨부파일 등록.
	 */
	int insertAttach_file(Attach_fileVo attach_fileVo);
	
	/**
	 * 
	 * Method : getFileList
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param insertflag
	 * @return
	 * Method 설명 : 등록 상태로 첨부파일 목록 조회.
	 */
	List<Attach_fileVo> getFileList(String insertflag);
	
	/**
	 * 
	 * Method : updateFileFlag
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param attach_fileVo
	 * @return
	 * Method 설명 : 첨부파일 등록 상태 수정.
	 */
	int updateFileFlag(Attach_fileVo attach_fileVo);
	
	/**
	 * 
	 * Method : getPostFileList
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param post_no
	 * @return
	 * Method 설명 : 게시글 번호로 첨부파일 목록 조회.
	 */
	List<Attach_fileVo> getPostFileList(String post_no);
	
	
}












