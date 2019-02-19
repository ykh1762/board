package kr.or.ddit.board.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardServiceImplTest {
	private IBoardService boardService;
	private Logger logger = LoggerFactory.getLogger(BoardServiceImplTest.class);

	public BoardServiceImplTest() {
		boardService = new BoardServiceImpl();
	}
	
	@Test
	public void testUpdateBoard() {
		/***Given***/
		List<BoardVo> boardList = boardService.getAllBoard();
		BoardVo boardVo = boardList.get(0);
		boardVo.setBoard_nm("123 게시판");
		boardVo.setUse_flag("f");
		
		/***When***/
		int updateCnt = boardService.updateBoard(boardVo);

		/***Then***/
		assertEquals(1, updateCnt);

	}

}
