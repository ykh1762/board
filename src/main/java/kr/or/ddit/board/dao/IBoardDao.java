package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVo;

public interface IBoardDao {

	/**
	 * 
	 * Method : getAllBoard
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 모든 게시판 조회.
	 */
	List<BoardVo> getAllBoard(SqlSession sqlSession);
	
	/**
	 * 
	 * Method : updateBoard
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @param boardVo
	 * @return
	 * Method 설명 : 게시판 정보 수정
	 */
	int updateBoard(SqlSession sqlSession, BoardVo boardVo);
	
	/**
	 * 
	 * Method : selectBoard
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sqlSession
	 * @param board_nm
	 * @return
	 * Method 설명 : board_nm으로 게시판 조회.
	 */
	BoardVo selectBoard(SqlSession sqlSession, String board_nm);
	
}
