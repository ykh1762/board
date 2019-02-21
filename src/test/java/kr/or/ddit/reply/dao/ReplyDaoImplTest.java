package kr.or.ddit.reply.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.board.dao.BoardDaoImplTest;
import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.reply.model.ReplyVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReplyDaoImplTest {
	private Logger logger = LoggerFactory.getLogger(BoardDaoImplTest.class);
	private SqlSession sqlSession;
	private IReplyDao replyDao;
	
	
	@Before
	public void setUp() throws Exception {
		replyDao = new ReplyDaoImpl();
		
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
	}

	@After
	public void tearDown(){
		sqlSession.close();
	}		
	
	@Test
	public void testInsertReply() {
		/***Given***/
		ReplyVo replyVo = new ReplyVo();
		replyVo.setContent("1111");
		replyVo.setPost_no("11");
		
		int replyCnt = replyDao.getReplyCnt(sqlSession);
		replyVo.setReply_no(replyCnt + 1 + "");
		replyVo.setUserid("m");
		
		/***When***/
		int insertCnt = replyDao.insertReply(sqlSession, replyVo);
		
		/***Then***/
		assertNotNull(insertCnt);
		
	}
	
	@Test
	public void testGetReplyCnt(){
		/***Given***/
		
		/***When***/
		int replyCnt = replyDao.getReplyCnt(sqlSession);
		
		/***Then***/
		assertNotNull(replyCnt);
		
	}
	
	@Test
	public void testGetReplyList(){
		/***Given***/
		String post_no = "9";
		
		/***When***/
		List<ReplyVo> replyList = replyDao.getReplyList(sqlSession, post_no);
		
		/***Then***/
		assertNotNull(replyList);
		
	}

}













