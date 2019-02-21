package kr.or.ddit.attach_file.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.attach_file.model.Attach_fileVo;
import kr.or.ddit.board.dao.BoardDaoImplTest;
import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Attach_fileDaoImplTest {
	private Logger logger = LoggerFactory.getLogger(BoardDaoImplTest.class);
	private SqlSession sqlSession;
	private IAttach_fileDao attach_fileDao;

	@Before
	public void setUp() throws Exception {
		attach_fileDao = new Attach_fileDaoImpl();
		
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
	}
	
	@After
	public void tearDown(){
		sqlSession.close();
	}	

	@Test
	public void testInsertAttach_file() {
		/***Given***/
		Attach_fileVo attach_fileVo = new Attach_fileVo();
		
		int attach_fileCnt = attach_fileDao.getAttach_fileCnt(sqlSession);
		attach_fileVo.setFile_no(attach_fileCnt + 1 + "");
		attach_fileVo.setFilename("22");
		attach_fileVo.setInsertflag("1");
		attach_fileVo.setRealfilename("22");
		
		/***When***/
		int insertCnt = attach_fileDao.insertAttach_file(sqlSession, attach_fileVo);

		/***Then***/
		assertNotNull(insertCnt);

	}
	
	@Test
	public void testGetAttach_fileCnt(){
		/***Given***/
		
		/***When***/
		int attach_fileCnt = attach_fileDao.getAttach_fileCnt(sqlSession);
		
		/***Then***/
		assertNotNull(attach_fileCnt);

	}

	@Test
	public void testGetFileList(){
		/***Given***/
		String insertflag = "1";
		
		/***When***/
		List<Attach_fileVo> fileList = attach_fileDao.getFileList(sqlSession, insertflag);
		logger.debug("size? : {}", fileList.size());
		
		/***Then***/
		assertNotNull(fileList);
		
	}
	
	@Test
	public void testUpdateFileFlag(){
		/***Given***/
		List<Attach_fileVo> fileList = attach_fileDao.getFileList(sqlSession, "1");
		
		/***When***/
		int updateCnt = 0;
		for(Attach_fileVo attach_fileVo : fileList){
			attach_fileVo.setInsertflag("f");
			
			updateCnt = attach_fileDao.updateFileFlag(sqlSession, attach_fileVo);
		}

		/***Then***/
		assertNotNull(updateCnt);

	}
	
	@Test
	public void testGetPostFileList(){
		/***Given***/
		String post_no = "41";
		
		/***When***/
		List<Attach_fileVo> fileList = attach_fileDao.getPostFileList(sqlSession, post_no);

		/***Then***/
		assertNotNull(fileList);

	}
	
	
	
	
	
	
	
}










