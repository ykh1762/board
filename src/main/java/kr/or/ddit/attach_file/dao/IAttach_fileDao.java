package kr.or.ddit.attach_file.dao;

import java.util.List;

import kr.or.ddit.attach_file.model.Attach_fileVo;

import org.apache.ibatis.session.SqlSession;

public interface IAttach_fileDao {
	
	/**
	 * 
	 * Method : insertAttach_file
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @param fileVo
	 * @return
	 * Method 설명 : 파일 등록.
	 */
	int insertAttach_file(SqlSession sqlSession, Attach_fileVo attach_fileVo);	
	
	/**
	 * 
	 * Method : getAttach_fileCnt
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 전체 첨부파일 수 조회.
	 */
	int getAttach_fileCnt(SqlSession sqlSession);
	
	/**
	 * 
	 * Method : getFileList
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @param insertflag
	 * @return
	 * Method 설명 : 등록 상태로 첨부파일 목록 조회.
	 */
	List<Attach_fileVo> getFileList(SqlSession sqlSession, String insertflag);
	
	/**
	 * 
	 * Method : updateFileFlag
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @param attach_fileVo
	 * @return
	 * Method 설명 : 첨부파일 등록 상태 수정.
	 */
	int updateFileFlag(SqlSession sqlSession, Attach_fileVo attach_fileVo);
	
	/**
	 * 
	 * Method : getPostFileList
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @param post_no
	 * @return
	 * Method 설명 : 게시글 번호로 첨부파일 목록 조회.
	 */
	List<Attach_fileVo> getPostFileList(SqlSession sqlSession, String post_no);	
	
}

















