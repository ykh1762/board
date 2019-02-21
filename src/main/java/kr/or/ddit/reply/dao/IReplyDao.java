package kr.or.ddit.reply.dao;

import java.util.List;

import kr.or.ddit.reply.model.ReplyVo;

import org.apache.ibatis.session.SqlSession;

public interface IReplyDao {

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
	int insertReply(SqlSession sqlSession, ReplyVo replyVo);
	
	/**
	 * 
	 * Method : getReplyCnt
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 전체 댓글 수 조회.
	 */
	int getReplyCnt(SqlSession sqlSession);
	
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
	List<ReplyVo> getReplyList(SqlSession sqlSession, String post_no);
	
}




















