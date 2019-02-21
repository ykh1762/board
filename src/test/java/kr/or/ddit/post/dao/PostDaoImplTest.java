package kr.or.ddit.post.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.board.dao.BoardDaoImplTest;
import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.post.model.PostVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostDaoImplTest {
	private Logger logger = LoggerFactory.getLogger(BoardDaoImplTest.class);
	private SqlSession sqlSession;
	private IPostDao postDao;
	
	@Before
	public void setUp() throws Exception {
		postDao = new PostDaoImpl();
		
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
	}

	@After
	public void tearDown(){
		sqlSession.close();
	}	
	
	@Test
	public void testGetAllPost() {
		/***Given***/
		
		/***When***/
		List<PostVo> postList = postDao.getAllPost(sqlSession);
		logger.debug("list size : {}", postList.size());
		
		/***Then***/
		assertNotNull(postList);
		
	}
	
	@Test
	public void testGetLevel() {
		/***Given***/
		
		/***When***/
		List<PostVo> postList = postDao.getLevel(sqlSession);
		logger.debug("list size : {}", postList.size());
		logger.debug("get(7).getLevel() : {}", postList.get(7).getPost_level());
		
		/***Then***/
		assertNotNull(postList);
		
	}
	
	@Test
	public void testUpdateLevel() {
		/***Given***/
		List<PostVo> postList = postDao.getAllPost(sqlSession);
		postList.get(0).setPost_level("1");
		PostVo postVo = postList.get(0);
		
		/***When***/
		int updateCnt = postDao.updateLevel(sqlSession, postVo);
		logger.debug("updateCnt : {}", updateCnt);
		logger.debug("postVo.getPostLevel() : {}", postVo.getPost_level());
		
		/***Then***/
		assertEquals(1, updateCnt);
		
	}
	
	@Test
	public void testUpdateGn() {
		/***Given***/
		List<PostVo> postList = postDao.getAllPost(sqlSession);
		PostVo postVo = postList.get(0);
		postVo.setGn("1");
		
		/***When***/
		int updateCnt = postDao.updateGn(sqlSession, postVo);
		logger.debug("updateCnt : {}", updateCnt);
		
		/***Then***/
		assertEquals(1, updateCnt);
		
	}
	
	@Test
	public void testGetEditList(){
		/***Given***/
		String board_no = "1";
		
		/***When***/
		List<PostVo> editList = postDao.getEditList(sqlSession, board_no);
		logger.debug("size?, 3rd post's title : {}, {}", editList.size(), editList.get(3).getTitle());

		/***Then***/
		assertNotNull(editList);

	}
	
	@Test
	public void testGetPostCnt(){
		/***Given***/
		
		/***When***/
		int postCnt = postDao.getPostCnt(sqlSession);
		logger.debug("postCnt : {}", postCnt);
		
		/***Then***/
		assertNotNull(postCnt) ; 

	}
	
	@Test
	public void testInsertPost(){
		/***Given***/
		PostVo postVo = new PostVo();
		int postCnt = postDao.getPostCnt(sqlSession);
		
		postVo.setPost_no(postCnt + 1 + "");
		postVo.setUserid("m");
		postVo.setTitle("열두번째 글");
		
		/***When***/
		int insertCnt = postDao.insertPost(sqlSession, postVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
		
	}

	@Test
	public void testSelectPost(){
		/***Given***/
		String post_no = "2";
		
		/***When***/
		PostVo postVo = postDao.selectPost(sqlSession, post_no);
		logger.debug("title : {}", postVo.getTitle());
		
		/***Then***/
		assertNotNull(postVo);

	}
	
	@Test
	public void testUpdatePost(){
		/***Given***/
		PostVo postVo = postDao.selectPost(sqlSession, "28");
		postVo.setTitle("1234565");
		postVo.setContent("123123123");
		
		/***When***/
		int updateCnt = postDao.updateGn(sqlSession, postVo);
		
		/***Then***/
		assertNotNull(updateCnt);

	}
	
}












