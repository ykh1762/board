package kr.or.ddit.reply.service;

import java.util.List;

import kr.or.ddit.reply.model.ReplyVo;

public interface IReplyService {

	/**
	 * 
	 * Method : getReplyCnt
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 댓글 수 조회.
	 */
	int getReplyCnt();
	
	/**
	 * 
	 * Method : insertReply
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 댓글 등록.
	 */
	int insertReply(ReplyVo replyVo);
	
	/**
	 * 
	 * Method : getReplyList
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param post_no
	 * @return
	 * Method 설명 : post_no로 댓글 목록 조회.
	 */
	List<ReplyVo> getReplyList(String post_no);
	
}

















