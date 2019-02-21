package kr.or.ddit.reply.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.reply.dao.IReplyDao;
import kr.or.ddit.reply.model.ReplyVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReplyServiceImplTest {
	private IReplyService replyService;
	private Logger logger = LoggerFactory.getLogger(ReplyServiceImplTest.class);

	@Before
	public void setUp() throws Exception {
		replyService = new ReplyServiceImpl();
	}

	@Test
	public void testInsertReply() {
		/***Given***/
		ReplyVo replyVo = new ReplyVo();
		replyVo.setContent("1111");
		replyVo.setPost_no("11");
		
		int replyCnt = replyService.getReplyCnt();
		replyVo.setReply_no(replyCnt + 1 + "");
		replyVo.setUserid("m");
		
		/***When***/
		int insertCnt = replyService.insertReply(replyVo);

		/***Then***/
		assertNotNull(insertCnt);

	}
	
	@Test
	public void testGetReplyList(){
		/***Given***/
		String post_no = "9";
		
		/***When***/
		List<ReplyVo> replyList = replyService.getReplyList(post_no);
		logger.debug("size? : {}", replyList.size());
		
		/***Then***/
		assertNotNull(replyList);
		
	}

}
