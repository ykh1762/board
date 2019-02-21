package kr.or.ddit.reply.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.reply.dao.IReplyDao;
import kr.or.ddit.reply.dao.ReplyDaoImpl;
import kr.or.ddit.reply.model.ReplyVo;

public class ReplyServiceImpl implements IReplyService{
	private IReplyDao replyDao;
	
	public ReplyServiceImpl() {
		replyDao = new ReplyDaoImpl();
	}
	
	
	/**
	 * 
	 * Method : getReplyCnt
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 댓글 수 조회.
	 */
	@Override
	public int getReplyCnt() {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int replyCnt = replyDao.getReplyCnt(sqlSession);
		
		sqlSession.close();
		
		return replyCnt;
	}

	/**
	 * 
	 * Method : insertReply
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 댓글 등록.
	 */
	@Override
	public int insertReply(ReplyVo replyVo) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int insertCnt = replyDao.insertReply(sqlSession, replyVo);
		
		sqlSession.commit();
		sqlSession.close();
		
		return insertCnt;
	}

	/**
	 * 
	 * Method : getReplyList
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param post_no
	 * @return
	 * Method 설명 : post_no로 댓글 목록 조회.
	 */
	@Override
	public List<ReplyVo> getReplyList(String post_no) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<ReplyVo> replyList = replyDao.getReplyList(sqlSession, post_no);
		
		sqlSession.close();
		
		return replyList;
	}

}











