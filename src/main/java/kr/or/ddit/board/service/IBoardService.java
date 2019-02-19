package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;

public interface IBoardService {
	
	/**
	 * 
	 * Method : getAllBoard
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 모든 게시판 조회.
	 */
	List<BoardVo> getAllBoard();
	
	/**
	 * 
	 * Method : updateBoard
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 정보 수정.
	 */
	int updateBoard(BoardVo boardVo);

	/**
	 * 
	 * Method : selectBoard
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param board_nm
	 * @return
	 * Method 설명 : board_nm으로 게시판 조회.
	 */
	BoardVo selectBoard(String board_nm);
	
}
