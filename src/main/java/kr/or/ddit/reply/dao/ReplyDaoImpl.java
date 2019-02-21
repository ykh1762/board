package kr.or.ddit.reply.dao;

import java.util.List;

import kr.or.ddit.reply.model.ReplyVo;

import org.apache.ibatis.session.SqlSession;

public class ReplyDaoImpl implements IReplyDao{

	/**
	 * 
	 * Method : insertReply
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @param replyVo
	 * @return
	 * Method 설명 : 댓글 등록.
	 */
	@Override
	public int insertReply(SqlSession sqlSession, ReplyVo replyVo) {
		int insertCnt = sqlSession.insert("reply.insertReply", replyVo);
		
		return insertCnt;
	}

	/**
	 * 
	 * Method : getReplyCnt
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 전체 댓글 수 조회.
	 */
	@Override
	public int getReplyCnt(SqlSession sqlSession) {
		int replyCnt = sqlSession.selectOne("reply.getReplyCnt");
		
		return replyCnt;
	}

	/**
	 * 
	 * Method : getReplyList
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @param post_no
	 * @return
	 * Method 설명 : post_no로 댓글 조회.
	 */
	@Override
	public List<ReplyVo> getReplyList(SqlSession sqlSession, String post_no) {
		List<ReplyVo> replyList = sqlSession.selectList("reply.getReplyList", post_no);
		
		return replyList;
	}

}
