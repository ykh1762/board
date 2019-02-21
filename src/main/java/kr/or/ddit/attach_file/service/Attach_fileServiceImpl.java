package kr.or.ddit.attach_file.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.attach_file.dao.Attach_fileDaoImpl;
import kr.or.ddit.attach_file.dao.IAttach_fileDao;
import kr.or.ddit.attach_file.model.Attach_fileVo;
import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;

public class Attach_fileServiceImpl implements IAttach_fileService{
	private IAttach_fileDao attach_fileDao;
	
	public Attach_fileServiceImpl() {
		attach_fileDao = new Attach_fileDaoImpl();
	}

	/**
	 * 
	 * Method : getAttach_fileCnt
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 첨부파일 수 조회.
	 */
	@Override
	public int getAttach_fileCnt() {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int attach_fileCnt = attach_fileDao.getAttach_fileCnt(sqlSession);
		
		sqlSession.close();
		
		return attach_fileCnt;
	}

	/**
	 * 
	 * Method : insertAttach_file
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 첨부파일 등록.
	 */
	@Override
	public int insertAttach_file(Attach_fileVo attach_fileVo) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int insertCnt = attach_fileDao.insertAttach_file(sqlSession, attach_fileVo);
		
		sqlSession.commit();
		sqlSession.close();
		
		return insertCnt;
	}

	/**
	 * 
	 * Method : getFileList
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param insertflag
	 * @return
	 * Method 설명 : 등록 상태로 첨부파일 목록 조회.
	 */
	@Override
	public List<Attach_fileVo> getFileList(String insertflag) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<Attach_fileVo> fileList = attach_fileDao.getFileList(sqlSession, insertflag);
		
		sqlSession.close();
		
		return fileList;
	}

	/**
	 * 
	 * Method : updateFileFlag
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param attach_fileVo
	 * @return
	 * Method 설명 : 첨부파일 등록 상태 수정.
	 */
	@Override
	public int updateFileFlag(Attach_fileVo attach_fileVo) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int updateCnt = attach_fileDao.updateFileFlag(sqlSession, attach_fileVo);
		
		sqlSession.commit();
		sqlSession.close();
		
		return updateCnt;
	}

	/**
	 * 
	 * Method : getPostFileList
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param post_no
	 * @return
	 * Method 설명 : 게시글 번호로 첨부파일 목록 조회.
	 */
	@Override
	public List<Attach_fileVo> getPostFileList(String post_no) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<Attach_fileVo> fileList = attach_fileDao.getPostFileList(sqlSession, post_no);
		
		return fileList;
	}

}
