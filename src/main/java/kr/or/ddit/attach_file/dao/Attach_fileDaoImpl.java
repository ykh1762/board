package kr.or.ddit.attach_file.dao;

import java.util.List;

import kr.or.ddit.attach_file.model.Attach_fileVo;

import org.apache.ibatis.session.SqlSession;

public class Attach_fileDaoImpl implements IAttach_fileDao{

	/**
	 * 
	 * Method : insertAttach_file
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @param attach_fileVo
	 * @return
	 * Method 설명 : 파일 등록.
	 */
	@Override
	public int insertAttach_file(SqlSession sqlSession, Attach_fileVo attach_fileVo) {
		int insertCnt = sqlSession.insert("attach_file.insertAttach_file", attach_fileVo);
		
		return insertCnt;
	}

	/**
	 * 
	 * Method : getAttach_fileCnt
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 전체 첨부파일 수 조회.
	 */
	@Override
	public int getAttach_fileCnt(SqlSession sqlSession) {
		int attach_fileCnt = sqlSession.selectOne("attach_file.getAttach_fileCnt");
		
		return attach_fileCnt;
	}

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
	@Override
	public List<Attach_fileVo> getFileList(SqlSession sqlSession,
			String insertflag) {
		List<Attach_fileVo> fileList = sqlSession.selectList("attach_file.getFileList", insertflag);
		
		return fileList;
	}

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
	@Override
	public int updateFileFlag(SqlSession sqlSession, Attach_fileVo attach_fileVo) {
		int updateCnt = sqlSession.update("attach_file.updateFileFlag", attach_fileVo);
		
		return updateCnt;
	}
	
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
	@Override
	public List<Attach_fileVo> getPostFileList(SqlSession sqlSession,
			String post_no) {
		List<Attach_fileVo> fileList = sqlSession.selectList("attach_file.getPostFileList", post_no);
		
		return fileList;
	}

}











