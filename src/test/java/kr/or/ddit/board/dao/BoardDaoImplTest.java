package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.post.model.PostVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardDaoImplTest {

	private Logger logger = LoggerFactory.getLogger(BoardDaoImplTest.class);
	private IBoardDao boardDao;
	private SqlSession sqlSession;
	
	@Before
	public void setUp() throws Exception {
		boardDao = new BoardDaoImpl();
		
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
	}

	@After
	public void tearDown(){
		sqlSession.close();
	}	
	
	@Test
	public void testGetAllBoard() {
		/***Given***/
		
		/***When***/
		List<BoardVo> boardList = boardDao.getAllBoard(sqlSession);
		logger.debug("list size : {}", boardList.size());
		
		/***Then***/
		assertNotNull(boardList);
		
	}
	
	@Test
	public void testUpdateBoard() {
		/***Given***/
		List<BoardVo> boardList = boardDao.getAllBoard(sqlSession);
		BoardVo boardVo = boardList.get(0);
		boardVo.setBoard_nm("123 게시판");
		boardVo.setUse_flag("f");
		
		/***When***/
		int updateCnt = boardDao.updateBoard(sqlSession, boardVo);
		logger.debug("updateCnt : {}", updateCnt);
		
		/***Then***/
		assertEquals(1, updateCnt);
		
	}	
	
	@Test
	public void testSelectBoard(){
		/***Given***/
		String board_nm = "으아아아";
		
		/***When***/
		BoardVo boardVo = boardDao.selectBoard(sqlSession, board_nm);
		logger.debug("number? : {}", boardVo.getBoard_no());

		/***Then***/
		assertNotNull(boardVo);

	}

}










